package Eco3DPrint.BackendEco3DPrint.repository;

import Eco3DPrint.BackendEco3DPrint.model.ModelVote;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ModelVoteRepository extends JpaRepository<ModelVote, Integer> {
    @Query("SELECT mv FROM ModelVote mv WHERE mv.modelId = :modelId AND mv.userId = :userId")
    Optional<ModelVote> findByModelIdAndUserId(@Param("modelId") int modelId, @Param("userId") int userId);

    @Query("SELECT mv.modelId FROM ModelVote mv WHERE mv.userId = :userId")
    Optional<List<Integer>> findByUserId(@Param("userId") int userId);

    @Query("SELECT mv FROM ModelVote mv WHERE mv.modelId =:modelId")
    Optional<List<ModelVote>> findByModelId(@Param("modelId") int modelId);

    @Query("SELECT u FROM ModelVote mv JOIN Usuario u ON u.id = mv.userId WHERE mv.modelId = :modelId")
    Optional<List<Usuario>> findUsersByModelId(@Param("modelId") int modelId);

    @Query("SELECT count(*) FROM ModelVote mv WHERE mv.modelId = :modelId")
    Optional<Integer> findLikesByModelId(@Param("modelId") int modelId);
}