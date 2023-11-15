package Eco3DPrint.BackendEco3DPrint.controller;

import Eco3DPrint.BackendEco3DPrint.model.Model;
import Eco3DPrint.BackendEco3DPrint.model.PrintSettings;
import Eco3DPrint.BackendEco3DPrint.service.printSettings.PrintSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/printSettings")
public class PrintSettingsController {
    @Autowired
    private PrintSettingsService printSettingsService;

    @PostMapping("/add")
    public int add(@RequestBody PrintSettings printSettings) {
        printSettingsService.savePrintSettings(printSettings);
        return printSettingsService.getLastPrintSettingsId().getId();
    }

    @GetMapping("/getPrintSettings")
    public Optional<PrintSettings> getPrintSettingsbyId(@RequestParam int id){return printSettingsService.getPrintSettingsById(id);}

    @DeleteMapping("/deletePrintSettings")
    public String deletePrintSettingsbyId(@RequestParam int id){
        printSettingsService.deletePrintSettingsbyId(id);
        return "PrintSettings deleted";
    }
}
