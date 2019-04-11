package domain;

/**
 * @author niyueyeee
 * @create 2019-03-08 19:58
 */
public class User {
    private int id;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password=" + password +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public User() {
    }

    public User(int id, String name, int password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    private String name;
    private int password;
}
