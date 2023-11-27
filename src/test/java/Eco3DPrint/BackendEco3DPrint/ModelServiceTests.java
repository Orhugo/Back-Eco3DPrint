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

import java.util.Objects;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        Model modelToSave = new Model();
        modelToSave.setTitle("TestLikeTitle");
        modelToSave.setDescription("TestLikeDescription");
        Model savedModel = modelService.saveModel(modelToSave);
        int id = savedModel.getId();
        int userId = 1;
        modelService.likeModel(id, userId);
        Integer num = 1;
        assertEquals(Optional.of(num), modelVoteRepository.findLikesByModelId(id));
    }
}

