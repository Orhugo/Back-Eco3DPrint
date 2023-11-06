package Eco3DPrint.BackendEco3DPrint.model;

import jakarta.persistence.*;


@Entity
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int id_model;
    private String url;

    public Url() {
    }

    public Url(int id, int id_model, String url) {
        this.id = id;
        this.id_model = id_model;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public int getId_model() {
        return id_model;
    }

    public String getUrl() {
        return url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_model(int id_model) {
        this.id_model = id_model;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
