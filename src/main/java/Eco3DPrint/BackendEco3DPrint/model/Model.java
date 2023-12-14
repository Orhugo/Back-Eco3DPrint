package Eco3DPrint.BackendEco3DPrint.model;

import jakarta.persistence.*;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    @Column(name = "category")
    private String category;
    private String tags;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Usuario author;
    @OneToOne
    private PrintSettings printSettings;
    private String mainUrl;
    @Column(name= "image_url")
    private String imageUrl;

    @Column(name= "like_counter")
    private int likeCounter;

    public Model() {
    }

    public Model(String title, String description, String category, String tags, Usuario author, PrintSettings printSettings, String mainUrl, String imageUrl) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.tags = tags;
        this.author = author;
        this.printSettings = printSettings;
        this.mainUrl = mainUrl;
        this.imageUrl = imageUrl;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setId(Integer id) {
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
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(int likeCounter) {
        this.likeCounter = likeCounter;
    }
}
