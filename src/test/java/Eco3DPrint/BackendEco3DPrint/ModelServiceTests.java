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
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@SpringBootTest
public class ModelServiceTests {
    @Autowired
    private ModelService modelService;

    @Autowired
    private ModelRepository modelRepository;
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
        ModelRepository modelRepository = mock(ModelRepository.class);
        ModelVoteRepository modelVoteRepository = mock(ModelVoteRepository.class);
        ModelServiceImp modelService = new ModelServiceImp();

        int modelId = 1;
        int userId = 1;

        when(modelVoteRepository.findByModelIdAndUserId(eq(modelId), eq(userId)))
                .thenReturn(Optional.empty());

        when(modelRepository.findById(eq(modelId))).thenReturn(Optional.of(new Model()));

        ResponseEntity<Model> responseEntity = modelService.likeModel(modelId, userId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, responseEntity.getBody().getLikeCounter());
    }
}


