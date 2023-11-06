package Eco3DPrint.BackendEco3DPrint.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario user;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "like_counter")
    private int likeCounter;

    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;


    public Comment() {

    }

    public Comment(Usuario user, Model model, String content){
        this.user = user;
        this.model = model;
        this.content = content;
        this.createdAt = Date.from(Instant.now());
    }

    public Comment(Usuario user, Model model, String content, Comment parentComment){
        this.user = user;
        this.model = model;
        this.content = content;
        this.parentComment = parentComment;
        this.createdAt = Date.from(Instant.now());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(int likeCounter) {
        this.likeCounter = likeCounter;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = Date.from(Instant.now());
    }
}
