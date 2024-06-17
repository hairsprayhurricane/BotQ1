import jakarta.persistence.*;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String user;
    private String mail;
    private String name;

    public User(){
        id = 0;
        user = null;
        mail = null;
        name = null;

    }

    public User(String user, String mail, String phone) {
        this.user = user;
        this.mail = mail;
        this.name = phone;
    }
    public User(int id, String user, String mail, String phone) {
        this.id = id;
        this.user = user;
        this.mail = mail;
        this.name = phone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return name;
    }

    public void setPhone(String phone) {
        this.name = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", mail='" + mail + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}