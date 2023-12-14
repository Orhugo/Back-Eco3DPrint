package Eco3DPrint.BackendEco3DPrint.repository;

import Eco3DPrint.BackendEco3DPrint.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends JpaRepository<Url, Integer> {
    @Query("SELECT u.url FROM Url u WHERE u.id_model = :id_model")
    List<String> findById_model(int id_model);

}
