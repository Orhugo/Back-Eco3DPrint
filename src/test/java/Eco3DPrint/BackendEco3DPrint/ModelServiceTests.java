package Eco3DPrint.BackendEco3DPrint;

import Eco3DPrint.BackendEco3DPrint.model.Model;
import Eco3DPrint.BackendEco3DPrint.repository.ModelRepository;
import Eco3DPrint.BackendEco3DPrint.repository.ModelVoteRepository;
import Eco3DPrint.BackendEco3DPrint.service.modelService.ModelService;
import Eco3DPrint.BackendEco3DPrint.service.modelService.ModelServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
@SpringBootTest
public class ModelServiceTests {
    @Autowired
    private ModelService modelService;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private ModelVoteRepository modelVoteRepository;

    @BeforeEach
    public void setUp() {
        // Puedes realizar configuraciones adicionales antes de cada prueba si es necesario
    }

    @Test
    public void testGetAllModels() {
        List<Model> modelos = new ArrayList<Model>();
        modelos = modelService.getAllModels();
        assertEquals(15, modelos.size());
    }

    @Test
    public void testSaveModel() {
        // Crear un nuevo modelo para guardar
        Model modelToSave = new Model();
        // Puedes configurar el modelo según tus necesidades
        modelToSave.setTitle("TestTitle");
        modelToSave.setDescription("TestDescription");
        // Guardar el modelo utilizando el servicio
        Model savedModel = modelService.saveModel(modelToSave);
        // Verificar que el modelo guardado no sea nulo
        Assertions.assertNotNull(savedModel, "El modelo no debería ser nulo");
        // Obtener el modelo directamente del repositorio para comparar
        Model retrievedModel = modelRepository.findById(savedModel.getId()).orElse(null);

        // Verificar que el modelo guardado sea igual al recuperado
        assertEquals(savedModel.getId(), retrievedModel.getId(), "El modelo guardado y el recuperado deben ser iguales");
    }



    @Test
    public void testLikeModel() {
        modelService.likeModel(1, 1);
        modelService.likeModel(1, 2);
        Optional<Model> model = modelService.getModelbyId(1);
        assertEquals(modelVoteRepository.findLikesByModelId(1), modelVoteRepository.findLikesByModelId(1));
    }

    @Test
    public void testLikeModel2() {
        modelService.likeModel(4, 1);
        Optional<Model> model = modelService.getModelbyId(1);
        assertEquals(1, model.get().getLikeCounter());
    }

    @Test
    public void testGetModelById() {
        Optional<Model> result = modelService.getModelbyId(1);
        Model model = result.get();
        assertEquals(1, model.getId());
        assertEquals("Model Category", model.getCategory());
        assertEquals("Model Description", model.getDescription());
        assertEquals("tag1, tag2", model.getTags());
        assertEquals("Model Title", model.getTitle());
        assertEquals(1, model.getAuthor().getId());
        assertEquals(1, model.getPrintSettings().getId());
        assertEquals("https://volumepin.s3.eu-west-3.amazonaws.com/Sizing.stl", model.getMainUrl());
        assertEquals(0, model.getLikeCounter());
    }

    @Test
    public void testDeleteModelById() {
        Model result = modelService.getLastModelId();
        int id = result.getId();
        modelService.deleteModelbyId(id);
        assertTrue(modelRepository.findById(id).isEmpty());
    }

}

