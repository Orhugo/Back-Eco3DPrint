package Eco3DPrint.BackendEco3DPrint.controller;

import Eco3DPrint.BackendEco3DPrint.model.Comment;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import Eco3DPrint.BackendEco3DPrint.service.commentService.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Comment>> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/get/{modelId}")
    public ResponseEntity<List<Comment>> getCommentsByModelId(@PathVariable int modelId) {
        return commentService.getCommentsByModelId(modelId);
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<Boolean> deleteComment(@PathVariable long commentId) {
        return commentService.deleteComment(commentId);
    }

    @PutMapping("/update/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable long commentId, @RequestBody Comment comment) {
        return commentService.updateComment(commentId, comment);
    }

    @PostMapping("/like/{commentId}")
    public ResponseEntity<Comment> likeComment(@PathVariable int commentId, @RequestParam int userId) {
        return commentService.likeComment(commentId, userId);
    }

    @DeleteMapping("/dislike/{commentId}")
    public ResponseEntity<Boolean> dislikeComment(@PathVariable int commentId, @RequestParam int userId) {
        return commentService.dislikeComment(commentId, userId);
    }

    @GetMapping("/liked/{userId}")
    public ResponseEntity<List<Integer>> getLikedComments(@PathVariable int userId){
        return commentService.getLikedComments(userId);
    }

    @GetMapping("/userInteractions/{commentId}")
    public ResponseEntity<List<Usuario>> getUsersThatLikedComment(@PathVariable int commentId){
        return commentService.getUsersThatLikedComment(commentId);
    }

    @PostMapping("/reply/{parentCommentId}")
    public ResponseEntity<Comment> postReplyToComment(@PathVariable int parentCommentId, @RequestBody Comment reply) throws Exception {
        return commentService.postReply(parentCommentId, reply);
    }

    @GetMapping("/replies/{parentCommentId}")
    public ResponseEntity<List<Comment>> getRepliesToComment(@PathVariable int parentCommentId) {
        return commentService.getRepliesToComment(parentCommentId);
    }

}

