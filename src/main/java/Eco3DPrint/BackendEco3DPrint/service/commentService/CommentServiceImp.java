package Eco3DPrint.BackendEco3DPrint.service.commentService;

import Eco3DPrint.BackendEco3DPrint.model.Comment;
import Eco3DPrint.BackendEco3DPrint.model.Model;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import Eco3DPrint.BackendEco3DPrint.model.CommentVote;
import Eco3DPrint.BackendEco3DPrint.repository.CommentRepository;
import Eco3DPrint.BackendEco3DPrint.repository.ModelRepository;
import Eco3DPrint.BackendEco3DPrint.repository.UsuarioRepository;
import Eco3DPrint.BackendEco3DPrint.repository.CommentVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private CommentVoteRepository userVoteRepository;

    @Override
    public ResponseEntity<Comment> createComment(Comment comment) {
        Usuario user = userRepository.findById(comment.getUser().getId()).orElse(null);
        Model model = modelRepository.findById(comment.getModel().getId()).orElse(null);
        if (user == null || model == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        comment.setUser(user);
        comment.setModel(model);
        commentRepository.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Comment>> getAllComments() {
        return new ResponseEntity<>(commentRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Comment>> getCommentsByModelId(int modelId){
        Model model = modelRepository.findById(modelId).orElse(null);
        if(model == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Comment> comments = commentRepository.findByModelId(modelId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> deleteComment(long commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if(comment.isPresent()) {
            List<Comment> childComments = commentRepository.findByParentCommentId(comment.get().getId());
            commentRepository.deleteAll(childComments);
            Optional<List<CommentVote>> userVotes = userVoteRepository.findByCommentId(comment.get().getId());
            userVotes.ifPresent(votes -> userVoteRepository.deleteAll(votes));
            commentRepository.delete(comment.get());
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Comment> updateComment(long commentId, Comment comment) {
        Optional<Comment> existingComment = commentRepository.findById(commentId);
        if(existingComment.isPresent()){
            Comment commentToUpdate = existingComment.get();
            commentToUpdate.setContent(comment.getContent());
            commentToUpdate.setUpdatedAt(Date.from(Instant.now()));
            commentRepository.save(commentToUpdate);
            return new ResponseEntity<>(commentToUpdate, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Comment> likeComment(int commentId, int userId) {
        Optional<CommentVote> userVote = userVoteRepository.findByCommentIdAndUserId(commentId, userId);
        if (userVote.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Optional<Comment> existingComment = commentRepository.findById((long) commentId);
            if (existingComment.isPresent()) {
                Comment comment = existingComment.get();
                comment.setLikeCounter(comment.getLikeCounter() + 1);
                userVoteRepository.save(new CommentVote(userId, commentId));
                return new ResponseEntity<>(comment, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Comment> postReply(long parentCommentId, Comment reply) {
        Optional<Comment> parentComment = commentRepository.findById(parentCommentId);
        if (parentComment.isPresent()) {
            if (parentComment.get().getModel().getId() != reply.getModel().getId()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            reply.setParentComment(parentComment.get());
            Comment newComment = commentRepository.save(reply);
            return new ResponseEntity<>(newComment, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Comment>> getRepliesToComment(long parentCommentId) {
        List<Comment> replies = commentRepository.findByParentCommentId(parentCommentId);
        return new ResponseEntity<>(replies, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> dislikeComment(int commentId, int userId) {
        Optional<CommentVote> userVote = userVoteRepository.findByCommentIdAndUserId(commentId, userId);
        if (userVote.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Optional<Comment> existingComment = commentRepository.findById((long) commentId);
            if (existingComment.isPresent()) {
                Comment comment = existingComment.get();
                comment.setLikeCounter(comment.getLikeCounter() - 1);
                userVoteRepository.delete(userVote.get());
                return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Integer>> getLikedComments(int userId) {
        Optional<List<Integer>> likedCommentsForUser = userVoteRepository.findByUserId(userId);
        return likedCommentsForUser.map(comments -> new ResponseEntity<>(comments, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<List<Usuario>> getUsersThatLikedComment(int commentId) {
        Optional<List<Usuario>> userList = userVoteRepository.findUsersByCommentId(commentId);
        if(userList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            List<Usuario> usersThatInteracted = userList.get();
            return new ResponseEntity<>(usersThatInteracted, HttpStatus.OK);
        }
    }
}

