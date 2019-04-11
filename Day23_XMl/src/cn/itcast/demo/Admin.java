package cn.itcast.demo;

public class Admin {

    private String AdminName;

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "AdminName='" + AdminName + '\'' +
                '}';
    }

    public Admin(String adminName) {
        AdminName = adminName;
    }

    public Admin() {
    }
}
