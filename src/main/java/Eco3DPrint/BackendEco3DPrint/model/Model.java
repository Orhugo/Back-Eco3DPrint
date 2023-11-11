package Eco3DPrint.BackendEco3DPrint.model;

import jakarta.persistence.*;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String cathegory;
    private String tags;
    @ManyToOne
    private Usuario author;
    @OneToOne
    private PrintSettings printSettings;
    private String mainUrl;

    public Model() {
    }

    public Model(String title, String description, String cathegory, String tags, Usuario author, PrintSettings printSettings, String mainUrl) {
        this.title = title;
        this.description = description;
        this.cathegory = cathegory;
        this.tags = tags;
        this.author = author;
        this.printSettings = printSettings;
        this.mainUrl = mainUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCathegory() {
        return cathegory;
    }

    public void setCathegory(String cathegory) {
        this.cathegory = cathegory;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setId(int id) {
        this.id = id;
    }
    public PrintSettings getPrintSettings() {
        return printSettings;
    }
    public void setPrintSettings(PrintSettings printSettings) {
        this.printSettings = printSettings;
    }
    public Usuario getAuthor() {
        return author;
    }
    public void setAuthor(Usuario author) {
        this.author = author;
    }
    public String getMainUrl() {
        return mainUrl;
    }
    public void setMainUrl(String mainUrl) {
        this.mainUrl = mainUrl;
    }
}
