package Eco3DPrint.BackendEco3DPrint.service.modelService;

import Eco3DPrint.BackendEco3DPrint.model.Model;
import Eco3DPrint.BackendEco3DPrint.model.Usuario;
import Eco3DPrint.BackendEco3DPrint.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelServiceImp implements ModelService {

    @Autowired
    private ModelRepository modelRepository;
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
}
