package Eco3DPrint.BackendEco3DPrint.service.commentService;

import Eco3DPrint.BackendEco3DPrint.model.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {
    ResponseEntity<Comment> createComment(Comment comment);
    ResponseEntity<List<Comment>> getAllComments();
    ResponseEntity<List<Comment>> getCommentsByModelId(int modelId);
    ResponseEntity<Boolean> deleteComment(long commentId);
}

