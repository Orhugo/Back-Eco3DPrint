package Eco3DPrint.BackendEco3DPrint;

import Eco3DPrint.BackendEco3DPrint.model.Model;
import Eco3DPrint.BackendEco3DPrint.model.ModelVote;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import Eco3DPrint.BackendEco3DPrint.repository.ModelRepository;
import Eco3DPrint.BackendEco3DPrint.repository.ModelVoteRepository;
import Eco3DPrint.BackendEco3DPrint.service.modelService.ModelServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ModelServiceTests {

    @Test
    public void testSaveModel() {
        ModelRepository modelRepository = mock(ModelRepository.class);
        ModelVoteRepository modelVoteRepository = mock(ModelVoteRepository.class);
        ModelServiceImp modelService = new ModelServiceImp();

        Model modelToSave = new Model();
        when(modelRepository.save(any(Model.class))).thenReturn(modelToSave);

        Model savedModel = modelService.saveModel(new Model());
        assertEquals(modelToSave, savedModel);
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


