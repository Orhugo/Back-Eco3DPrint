package Eco3DPrint.BackendEco3DPrint;
import Eco3DPrint.BackendEco3DPrint.controller.ModelController;
import Eco3DPrint.BackendEco3DPrint.model.Model;
import Eco3DPrint.BackendEco3DPrint.repository.ModelRepository;
import Eco3DPrint.BackendEco3DPrint.repository.TutorialRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ModelControllerTests {

    @Autowired
    private ModelController modelController;

    @Autowired
    private ModelRepository modelRepository;


    @Test
    void testGetAllModels() {
        int allModels = modelController.getAllModels().size();
        assertEquals(16, allModels);
    }
    @Test
    void testAdd() {
        Model model = new Model("pruebaAVD", null, null, null, null, null, null);

        ResponseEntity<Model> responseEntity = modelController.add(model);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(responseEntity.getBody().getId(), modelController.getLastModelId());
    }

    @Test
    void testGetModelById() {
        Optional<Model> optionalModel = modelController.getModelbyId(1);
        assertTrue(optionalModel.isPresent());
    }

    @Test
    void testDeleteModelById() {
        int id = modelController.getLastModelId();
        modelController.deleteModelbyId(id);
        assertTrue(modelRepository.findById(id).isEmpty());
    }

}


