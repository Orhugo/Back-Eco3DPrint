package Eco3DPrint.BackendEco3DPrint.controller;

import Eco3DPrint.BackendEco3DPrint.model.Model;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import Eco3DPrint.BackendEco3DPrint.service.modelService.ModelService;
import Eco3DPrint.BackendEco3DPrint.service.userService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/models")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @PostMapping("/add")
    public String add(@RequestBody Model model) {
        modelService.saveModel(model);
        return "new Model added";
    }
    @GetMapping("/getModel")
    public Optional<Model> getModelbyId(@RequestParam int id){return modelService.getModelbyId(id);}

    @DeleteMapping("/deleteModel")
    public String deleteModelbyId(@RequestParam int id){
        modelService.deleteModelbyId(id);
        return "Model deleted";
    }

    @GetMapping("/getAll")
    public List<Model> getAllModels() {
        return modelService.getAllModels();
    }

    @GetMapping("getLastModelId")
    public int getLastModelId() { return modelService.getLastModelId().getId(); }
}
