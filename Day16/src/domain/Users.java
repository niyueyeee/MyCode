package domain;

/**
 * @authro niyueyeee
 * @create 2019-02-12 上午 10:02
 */
public class Users {
    private String uid;
    private String uname;
    private String upass;

    public Users() {
    }

    public Users(String uid, String uname, String upass) {
        this.uid = uid;
        this.uname = uname;
        this.upass = upass;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }
}
