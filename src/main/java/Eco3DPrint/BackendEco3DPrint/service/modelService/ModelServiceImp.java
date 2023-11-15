package Eco3DPrint.BackendEco3DPrint.service.modelService;

import Eco3DPrint.BackendEco3DPrint.model.Model;
import Eco3DPrint.BackendEco3DPrint.model.ModelVote;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import Eco3DPrint.BackendEco3DPrint.repository.ModelRepository;
import Eco3DPrint.BackendEco3DPrint.repository.ModelVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImp implements ModelService {

    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private ModelVoteRepository modelVoteRepository;
    @Override
    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Optional<Model> getModelbyId(int id) {return modelRepository.findById(id);}

    @Override
    public void deleteModelbyId(int id) {modelRepository.deleteById(id);}

    @Override
    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    @Override
    public Model getLastModelId() {return modelRepository.findFirstByOrderByIdDesc();}

    @Override
    public ResponseEntity<Model> likeModel(int modelId, int userId) {
        Optional<ModelVote> modelVote = modelVoteRepository.findByModelIdAndUserId(modelId, userId);
        if(modelVote.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            Optional<Model> existingModel = modelRepository.findById(modelId);
            if(existingModel.isPresent()){
                Model model = existingModel.get();
                model.setLikeCounter(model.getLikeCounter() + 1);
                modelVoteRepository.save(new ModelVote(userId, modelId));
                return new ResponseEntity<>(model, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Boolean> dislikeModel(int modelId, int userId) {
        Optional<ModelVote> modelVote = modelVoteRepository.findByModelIdAndUserId(modelId, userId);
        if(modelVote.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            Optional<Model> existingModel = modelRepository.findById(modelId);
            if(existingModel.isPresent()){
                Model model = existingModel.get();
                model.setLikeCounter(model.getLikeCounter() - 1);
                modelVoteRepository.delete(modelVote.get());
                return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Usuario>> getUsersThatLikedModel(int modelId) {
        Optional<List<Usuario>> userList = modelVoteRepository.findUsersByModelId(modelId);
        if(userList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            List<Usuario> usersThatInteracted = userList.get();
            return new ResponseEntity<>(usersThatInteracted, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Integer> likeCountForModel(int modelId) {
        Optional<Integer> likeCount = modelVoteRepository.findLikesByModelId(modelId);
        if(likeCount.isPresent()){
            int likes = likeCount.get();
            return new ResponseEntity<>(likes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Integer>> getLikedModels(int userId) {
        Optional<List<Integer>> likedModelsForUser = modelVoteRepository.findByUserId(userId);
        return likedModelsForUser.map(models -> new ResponseEntity<>(models, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
