package Eco3DPrint.BackendEco3DPrint.model;

import jakarta.persistence.*;


@Entity
@Table(name = "user_votes")
public class UserVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "comment_id")
    private int commentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "vote_type")
    private VoteType voteType;

    public UserVote() {
    }

    public UserVote(int userId, int commentId, VoteType voteType){
        this.userId = userId;
        this.commentId = commentId;
        this.voteType = voteType;
    }

    public enum VoteType {
        LIKE, DISLIKE
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

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }
}
