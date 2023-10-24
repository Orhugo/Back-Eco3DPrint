package Eco3DPrint.BackendEco3DPrint.service.urlService;

import Eco3DPrint.BackendEco3DPrint.model.Url;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface UrlService {

    public Url crearModelo(Url url);
}
