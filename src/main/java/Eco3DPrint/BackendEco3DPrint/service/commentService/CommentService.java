package Eco3DPrint.BackendEco3DPrint.service.commentService;

import Eco3DPrint.BackendEco3DPrint.model.Comment;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * This interface defines the methods for managing comments.
 */
public interface CommentService {

    /**
     * Create a new comment.
     *
     * @param comment The comment to be created.
     * @return A ResponseEntity containing the created comment.
     */
    ResponseEntity<Comment> createComment(Comment comment);

    /**
     * Get a list of all comments.
     *
     * @return A ResponseEntity containing a list of all comments.
     */
    ResponseEntity<List<Comment>> getAllComments();

    /**
     * Get a list of comments associated with a specific model.
     *
     * @param modelId The ID of the model.
     * @return A ResponseEntity containing a list of comments for the specified model.
     */
    ResponseEntity<List<Comment>> getCommentsByModelId(int modelId);

    /**
     * Delete a comment by its ID.
     *
     * @param commentId The ID of the comment to be deleted.
     * @return A ResponseEntity indicating the success of the operation.
     */
    ResponseEntity<Boolean> deleteComment(long commentId);

    /**
     * Update a comment with new content.
     *
     * @param commentId The ID of the comment to be updated.
     * @param comment   The updated comment with new content.
     * @return A ResponseEntity containing the updated comment.
     */
    ResponseEntity<Comment> updateComment(long commentId, Comment comment);

    /**
     * Like a comment.
     *
     * @param commentId The ID of the comment to be liked.
     * @param userId    The ID of the user who is liking the comment.
     * @return A ResponseEntity containing the liked comment.
     */
    ResponseEntity<Comment> likeComment(int commentId, int userId);

    /**
     * Dislike a comment.
     *
     * @param commentId The ID of the comment to be disliked.
     * @param userId    The ID of the user who is disliking the comment.
     * @return A ResponseEntity indicating the success of the operation.
     */
    ResponseEntity<Boolean> dislikeComment(int commentId, int userId);

    /**
     * Get a list of comment IDs that the user has liked.
     *
     * @param userId The ID of the user.
     * @return A ResponseEntity containing a list of liked comment IDs.
     */
    ResponseEntity<List<Integer>> getLikedComments(int userId);

    /**
     * Post a reply to a parent comment.
     *
     * @param parentCommentId The ID of the parent comment to which the reply is posted.
     * @param reply           The reply comment to be posted.
     * @return A ResponseEntity containing the posted reply comment.
     * @throws Exception If an error occurs during the operation.
     */
    ResponseEntity<Comment> postReply(long parentCommentId, Comment reply) throws Exception;

    /**
     * Get a list of replies to a specific parent comment.
     *
     * @param parentCommentId The ID of the parent comment.
     * @return A ResponseEntity containing a list of reply comments to the specified parent comment.
     */
    ResponseEntity<List<Comment>> getRepliesToComment(long parentCommentId);

    ResponseEntity<List<Usuario>> getUsersThatLikedComment(int commentId);
}
