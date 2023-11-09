package Eco3DPrint.BackendEco3DPrint.controller;

import Eco3DPrint.BackendEco3DPrint.model.Model;
import Eco3DPrint.BackendEco3DPrint.model.Url;
import Eco3DPrint.BackendEco3DPrint.service.urlService.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/url")
public class UrlController {
    @Autowired
    private UrlService urlService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/add")
    public String add(@RequestBody Url url) {
        urlService.crearUrl(url);
        return "new url added";
    }

    @GetMapping("/getAll")
    public List<Url> getAllModels() {
        return urlService.getAllUrl();
    }
}
