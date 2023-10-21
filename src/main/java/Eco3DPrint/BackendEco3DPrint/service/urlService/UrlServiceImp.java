package Eco3DPrint.BackendEco3DPrint.service.urlService;

import Eco3DPrint.BackendEco3DPrint.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Eco3DPrint.BackendEco3DPrint.model.Url;

import java.util.List;
import java.util.Optional;
@Service
public class UrlServiceImp implements UrlService{

        @Autowired
        private UrlRepository urlRepository;

        @Override
        public Url crearModelo(Url url) {
            return urlRepository.save(url);
        }
    }

