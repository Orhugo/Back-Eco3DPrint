package Eco3DPrint.BackendEco3DPrint.controller;

import Eco3DPrint.BackendEco3DPrint.model.Comment;
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

    @GetMapping("/get{modelId}")
    public ResponseEntity<List<Comment>> getCommentsByModelId(@PathVariable int modelId) {
        return commentService.getCommentsByModelId(modelId);
    }

    @DeleteMapping("/delete{commentId}")
    public ResponseEntity<Boolean> deleteComment(@PathVariable long commentId) {
        return commentService.deleteComment(commentId);
    }

    @PutMapping("/update{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable long commentId, @RequestBody String updatedContent) {
        return commentService.updateComment(commentId, updatedContent);
    }

    @PostMapping("/{commentId}/like")
    public ResponseEntity<Comment> likeComment(@PathVariable long commentId) {
        return commentService.likeComment(commentId);
    }

    @PostMapping("/{commentId}/dislike")
    public ResponseEntity<Comment> dislikeComment(@PathVariable long commentId) {
        return commentService.dislikeComment(commentId);
    }

}

