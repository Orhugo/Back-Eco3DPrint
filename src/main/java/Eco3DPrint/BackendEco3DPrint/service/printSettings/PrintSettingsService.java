package Eco3DPrint.BackendEco3DPrint.service.printSettings;

import Eco3DPrint.BackendEco3DPrint.model.PrintSettings;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface PrintSettingsService {
    public PrintSettings savePrintSettings(PrintSettings printSettings);
    public PrintSettings getLastPrintSettingsId();

    public Optional<PrintSettings> getPrintSettingsById(int id);
    public void deletePrintSettingsbyId(int id);
}
