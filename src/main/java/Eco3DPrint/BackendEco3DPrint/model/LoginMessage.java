package Eco3DPrint.BackendEco3DPrint.model;

public class LoginMessage {
    private String message;
    private Boolean status;
    private Usuario user;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public LoginMessage(String message, Boolean status, Usuario user) {
        this.message = message;
        this.status = status;
        this.user = user;
    }
}
