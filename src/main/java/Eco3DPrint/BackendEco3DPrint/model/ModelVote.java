package Eco3DPrint.BackendEco3DPrint.model;

import jakarta.persistence.*;


@Entity
@Table(name = "model_votes")
public class ModelVote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "model_id")
    private int modelId;

    public ModelVote() {
    }

    public ModelVote(int userId, int modelId){
        this.userId = userId;
        this.modelId = modelId;
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

    public int getModelId() { return modelId; }

    public void setModelId(int modelId) { this.modelId = modelId; }
}