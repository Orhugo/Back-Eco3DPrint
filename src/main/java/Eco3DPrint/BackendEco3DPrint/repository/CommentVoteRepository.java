package Eco3DPrint.BackendEco3DPrint.repository;

import Eco3DPrint.BackendEco3DPrint.model.CommentVote;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentVoteRepository extends JpaRepository<CommentVote, Integer> {
    @Query("SELECT uv FROM CommentVote uv WHERE uv.commentId = :commentId AND uv.userId = :userId")
    Optional<CommentVote> findByCommentIdAndUserId(@Param("commentId") long commentId, @Param("userId") int userId);

    @Query("SELECT uv.commentId FROM CommentVote uv WHERE uv.userId = :userId")
    Optional<List<Integer>> findByUserId(@Param("userId") int userId);


    @Query("SELECT uv FROM CommentVote uv WHERE uv.commentId = :commentId")
    Optional<List<CommentVote>> findByCommentId(@Param("commentId") int commentId);

    @Query("SELECT u FROM CommentVote cv JOIN Usuario u ON u.id = cv.userId WHERE cv.commentId = :commentId")
    Optional<List<Usuario>> findUsersByCommentId(@Param("commentId") int commentId);

}
