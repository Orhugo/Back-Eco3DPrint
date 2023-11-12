package Eco3DPrint.BackendEco3DPrint.model;

import jakarta.persistence.*;


@Entity
@Table(name = "user_votes")
public class CommentVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "comment_id")
    private int commentId;

    public CommentVote() {
    }

    public CommentVote(int userId, int commentId){
        this.userId = userId;
        this.commentId = commentId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

}
