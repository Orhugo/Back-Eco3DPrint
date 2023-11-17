package Eco3DPrint.BackendEco3DPrint.repository;

import Eco3DPrint.BackendEco3DPrint.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    @Query("SELECT m FROM Model m ORDER BY m.id DESC LIMIT 1")
    Model findFirstByOrderByIdDesc();

    @Query("SELECT m FROM Model m WHERE m.author.id = :author_id")
    Collection<Model> findByAuthorId(@Param("author_id") int author_id);
}
