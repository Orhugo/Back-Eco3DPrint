package Eco3DPrint.BackendEco3DPrint.model;

import jakarta.persistence.*;

@Entity
@Table(name= "tutorial_votes")
public class TutorialVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tutorial_id")
    private int tutorialId;

    @Column(name = "user_id")
    private int userId;

    public TutorialVote() {
    }

    public TutorialVote(int tutorialId, int userId) {
        this.tutorialId = tutorialId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTutorialId() {
        return tutorialId;
    }

    public void setTutorialId(int tutorialId) {
        this.tutorialId = tutorialId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
