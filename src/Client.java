import java.io.Serializable;
import java.time.LocalDateTime;

public class Client implements Serializable {
    private String login;
    private LocalDateTime dateConnexion;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDateTime getDateConnexion() {
        return dateConnexion;
    }

    public void setDateConnexion(LocalDateTime dateConnexion) {
        this.dateConnexion = dateConnexion;
    }

    public Client(String login) {
        this.login = login;
        this.dateConnexion = LocalDateTime.now();
    }


}
