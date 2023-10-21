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

}

