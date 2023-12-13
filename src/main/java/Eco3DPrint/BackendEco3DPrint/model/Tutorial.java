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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }

    public String getContent4() {
        return content4;
    }

    public void setContent4(String content4) {
        this.content4 = content4;
    }

    public String getContent5() {
        return content5;
    }

    public void setContent5(String content5) {
        this.content5 = content5;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public String getSubtitle1() {
        return subtitle1;
    }

    public void setSubtitle1(String subtitle1) {
        this.subtitle1 = subtitle1;
    }

    public String getSubtitle2() {
        return subtitle2;
    }

    public void setSubtitle2(String subtitle2) {
        this.subtitle2 = subtitle2;
    }

    public String getSubtitle3() {
        return subtitle3;
    }

    public void setSubtitle3(String subtitle3) {
        this.subtitle3 = subtitle3;
    }

    public String getSubtitle4() {
        return subtitle4;
    }

    public void setSubtitle4(String subtitle4) {
        this.subtitle4 = subtitle4;
    }

    public String getSubtitle5() {
        return subtitle5;
    }

    public void setSubtitle5(String subtitle5) {
        this.subtitle5 = subtitle5;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }
}
