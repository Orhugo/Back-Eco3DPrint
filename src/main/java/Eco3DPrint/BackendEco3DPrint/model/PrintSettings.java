package Eco3DPrint.BackendEco3DPrint.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PrintSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String printerBrand;
    private String printerModel;
    private boolean supports;
    private double resolution;
    private int infill;
    private String filamentBrand;
    private String filamentColor;
    private String filamentMaterial;

    public PrintSettings() {
    }

    public PrintSettings(String printerBrand, String printerModel, boolean supports, double resolution, int infill, String filamentBrand, String filamentColor, String filamentMaterial) {
        this.printerBrand = printerBrand;
        this.printerModel = printerModel;
        this.supports = supports;
        this.resolution = resolution;
        this.infill = infill;
        this.filamentBrand = filamentBrand;
        this.filamentColor = filamentColor;
        this.filamentMaterial = filamentMaterial;
    }

    public String getPrinterBrand() {
        return printerBrand;
    }

    public void setPrinterBrand(String printerBrand) {
        this.printerBrand = printerBrand;
    }

    public String getPrinterModel() {
        return printerModel;
    }

    public void setPrinterModel(String printerModel) {
        this.printerModel = printerModel;
    }

    public boolean isSupports() {
        return supports;
    }

    public void setSupports(boolean supports) {
        this.supports = supports;
    }

    public double getResolution() {
        return resolution;
    }

    public void setResolution(double resolution) {
        this.resolution = resolution;
    }

    public int getInfill() {
        return infill;
    }

    public void setInfill(int infill) {
        this.infill = infill;
    }

    public String getFilamentBrand() {
        return filamentBrand;
    }

    public void setFilamentBrand(String filamentBrand) {
        this.filamentBrand = filamentBrand;
    }

    public String getFilamentColor() {
        return filamentColor;
    }

    public void setFilamentColor(String filamentColor) {
        this.filamentColor = filamentColor;
    }

    public String getFilamentMaterial() {
        return filamentMaterial;
    }

    public void setFilamentMaterial(String filamentMaterial) {
        this.filamentMaterial = filamentMaterial;
    }
}
