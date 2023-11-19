package Eco3DPrint.BackendEco3DPrint.repository;

import Eco3DPrint.BackendEco3DPrint.model.Model;
import Eco3DPrint.BackendEco3DPrint.model.PrintSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PrintSettingsRepository extends JpaRepository<PrintSettings, Integer> {
    @Query("SELECT m FROM PrintSettings m ORDER BY m.id DESC LIMIT 1")
    PrintSettings findFirstByOrderByIdDesc();
}
