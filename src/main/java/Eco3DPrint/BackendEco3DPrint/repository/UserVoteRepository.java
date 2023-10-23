package Eco3DPrint.BackendEco3DPrint.repository;

import Eco3DPrint.BackendEco3DPrint.model.UserVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserVoteRepository extends JpaRepository<UserVote, Integer> {
    @Query("SELECT uv FROM UserVote uv WHERE uv.commentId = :commentId AND uv.userId = :userId")
    Optional<UserVote> findByCommentIdAndUserId(@Param("commentId") long commentId, @Param("userId") int userId);

}
