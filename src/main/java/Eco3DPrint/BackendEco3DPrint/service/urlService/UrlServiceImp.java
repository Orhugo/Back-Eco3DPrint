package Eco3DPrint.BackendEco3DPrint.service.urlService;

import Eco3DPrint.BackendEco3DPrint.model.Model;
import Eco3DPrint.BackendEco3DPrint.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import Eco3DPrint.BackendEco3DPrint.model.Url;

import java.util.List;
import java.util.Optional;
@Service
public class UrlServiceImp implements UrlService {

    @Autowired
    private UrlRepository urlRepository;

    @Override
    public Url crearUrl(Url url) {
        return urlRepository.save(url);
    }

    @Override
    public List<Url> getAllUrl() {
        return urlRepository.findAll();
    }

    @Override
    public List<String> getUrlsByModel(int id_model) { return urlRepository.findById_model(id_model); }
}
