package frame.pojo;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;

    private Map<String, Mapper> mapperMap = new HashMap<>();

    public Map<String, Mapper> getMapperMap() {
        return mapperMap;
    }

    public void setMapperMap(
            Map<String, Mapper> mapperMap) {
        this.mapperMap = mapperMap;
    }

    public Configuration() {
    }

    public Configuration(String driver, String url, String username,
                         String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}