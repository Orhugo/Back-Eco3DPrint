package Eco3DPrint.BackendEco3DPrint.repository;

import Eco3DPrint.BackendEco3DPrint.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    @Query("SELECT t FROM Tutorial t WHERE t.id = :tutorialId")
    Tutorial findById(@Param("tutorialId") int tutorialId);

    @Query("SELECT t FROM Tutorial t ORDER BY t.views DESC")
    List<Tutorial> getMostPopularTutorials(@Param("count") int count);
}
