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
    private User author;
    @OneToOne
    private PrintSettings printSettings;

    public Model() {
    }

    public Model(String title, String description, String cathegory, String tags) {
        this.title = title;
        this.description = description;
        this.cathegory = cathegory;
        this.tags = tags;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
