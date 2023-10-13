package Eco3DPrint.BackendEco3DPrint.controller;

import Eco3DPrint.BackendEco3DPrint.model.Archive;
import Eco3DPrint.BackendEco3DPrint.repository.ArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@CrossOrigin("http://localhost:8080/")
@RequestMapping("/api")
public class ArchiveController {
    @Autowired
    private ArchiveRepository archiveRepository;

    @PostMapping("/upload-stl")
    public ResponseEntity<String> uploadArchive(/*@RequestParam("file")*/ MultipartFile file){
        try {

            Archive archive = new Archive();
            archive.setName(StringUtils.cleanPath(file.getOriginalFilename()));
            archive.setFileData(file.getBytes());

            archiveRepository.save(archive);

            return ResponseEntity.ok("Archivo STL subido con éxito");

        } catch (Exception e) {
            return ResponseEntity.ok("Error al subir el archivo: " + e.getMessage());
        }
    }
}
