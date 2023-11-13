package Eco3DPrint.BackendEco3DPrint.repository;

import Eco3DPrint.BackendEco3DPrint.model.TutorialVote;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TutorialVoteRepository extends JpaRepository<TutorialVote, Integer> {

    @Query("SELECT tv FROM TutorialVote tv WHERE tv.tutorialId = :tutorialId AND tv.userId = :userId")
    Optional<TutorialVote> findByTutorialIdAndUserId(@Param("tutorialId") int tutorialId, @Param("userId") int userId);

    @Query("SELECT tv.tutorialId FROM TutorialVote tv WHERE tv.userId = :userId")
    Optional<List<Integer>> findByUserId(@Param("userId") int userId);

    @Query("SELECT tv FROM TutorialVote tv WHERE tv.tutorialId =:tutorialId")
    Optional<List<TutorialVote>> findByTutorialId(@Param("tutorialId") int tutorialId);

    @Query("SELECT u FROM TutorialVote tv JOIN Usuario u ON u.id = tv.userId WHERE tv.tutorialId = :tutorialId")
    Optional<List<Usuario>> findUsersByTutorialId(@Param("tutorialId") int tutorialId);

    @Query("SELECT count(*) FROM TutorialVote tv WHERE tv.tutorialId = :tutorialId")
    Optional<Integer> findLikesByTutorialId(@Param("tutorialId") int tutorialId);
}
