package Eco3DPrint.BackendEco3DPrint.model;

import jakarta.persistence.*;

@Entity
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "content1")
    private String content1;

    @Column(name = "content2")
    private String content2;

    @Column(name = "content3")
    private String content3;

    @Column(name = "content4")
    private String content4;

    @Column(name = "content5")
    private String content5;

    @Column(name = "photo1")
    private String photo1;

    @Column(name = "photo2")
    private String photo2;

    @Column(name = "photo3")
    private String photo3;

    @Column(name = "subtitle1")
    private String subtitle1;

    @Column(name = "subtitle2")
    private String subtitle2;

    @Column(name = "subtitle3")
    private String subtitle3;

    @Column(name = "subtitle4")
    private String subtitle4;

    @Column(name = "subtitle5")
    private String subtitle5;

    @Column(name = "views")
    private int views;

    @Column(name = "main_photo")
    private String mainPhoto;

    public Tutorial() {
    }

    public Tutorial(Usuario user, String title, String content1, String content2, String content3, String content4, String content5, String photo1, String photo2, String photo3, String subtitle1, String subtitle2, String subtitle3, String subtitle4, String subtitle5, String mainPhoto){
        this.subtitle1 = subtitle1;
        this.subtitle2 = subtitle2;
        this.subtitle3 = subtitle3;
        this.subtitle4 = subtitle4;
        this.subtitle5 = subtitle5;
        this.title = title;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
        this.content1 = content1;
        this.content2 = content2;
        this.content3 = content3;
        this.content4 = content4;
        this.content5 = content5;
        this.mainPhoto = mainPhoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

}
