package Eco3DPrint.BackendEco3DPrint.service.printSettings;

import Eco3DPrint.BackendEco3DPrint.model.PrintSettings;
import Eco3DPrint.BackendEco3DPrint.repository.PrintSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrintSettingsServiceImple implements PrintSettingsService{
    @Autowired
    private PrintSettingsRepository printSettingsRepository;

    @Override
    public PrintSettings savePrintSettings(PrintSettings printSettings) {return printSettingsRepository.save(printSettings);}

    @Override
    public PrintSettings getLastPrintSettingsId() {
        return printSettingsRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Optional<PrintSettings> getPrintSettingsById(int id) {
        return printSettingsRepository.findById(id);
    }

    @Override
    public void deletePrintSettingsbyId(int id) {
        printSettingsRepository.deleteById(id);
    }
}
