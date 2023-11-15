package Eco3DPrint.BackendEco3DPrint.controller;

import Eco3DPrint.BackendEco3DPrint.model.Model;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import Eco3DPrint.BackendEco3DPrint.service.modelService.ModelService;
import Eco3DPrint.BackendEco3DPrint.service.userService.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/models")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @PostMapping("/add")
    public int add(@RequestBody Model model) {
        modelService.saveModel(model);
        return modelService.getLastModelId();
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

    @PostMapping("/like/{modelId}")
    public ResponseEntity<Model> likeModel(@PathVariable int modelId, @RequestParam int userId){
        return modelService.likeModel(modelId, userId);
    }

    @DeleteMapping("/dislike/{modelId}")
    public ResponseEntity<Boolean> dislikeModel(@PathVariable int modelId, @RequestParam int userId){
        return modelService.dislikeModel(modelId, userId);
    }

    @GetMapping("/userInteractions/{modelId}")
    public ResponseEntity<List<Usuario>> getUsersThatLikedModel(@PathVariable int modelId){
        return modelService.getUsersThatLikedModel(modelId);
    }

    @GetMapping("likeCount/{modelId}")
    public ResponseEntity<Integer> likeCountForModel(@PathVariable int modelId){
        return modelService.likeCountForModel(modelId);
    }

    @GetMapping("/liked/{userId}")
    public ResponseEntity<List<Integer>> getLikedModels(@PathVariable int userId){
        return modelService.getLikedModels(userId);
    }
}
