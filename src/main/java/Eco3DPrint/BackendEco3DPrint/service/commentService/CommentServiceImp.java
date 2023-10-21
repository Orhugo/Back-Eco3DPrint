package Eco3DPrint.BackendEco3DPrint.service.commentService;

import Eco3DPrint.BackendEco3DPrint.model.Comment;
import Eco3DPrint.BackendEco3DPrint.model.Model;
import Eco3DPrint.BackendEco3DPrint.model.User;
import Eco3DPrint.BackendEco3DPrint.repository.CommentRepository;
import Eco3DPrint.BackendEco3DPrint.repository.ModelRepository;
import Eco3DPrint.BackendEco3DPrint.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelRepository modelRepository;

    @Override
    public ResponseEntity<Comment> createComment(Comment comment) {
        User user = userRepository.findById(comment.getUser().getId()).orElse(null);
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
}

