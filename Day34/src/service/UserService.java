package service;

import dao.UserDao;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-09 10:32
 */
public class UserService {
    private UserDao userdao = new UserDao();

    public List<String> queryNameByKeyWord(String KeyWord)  {
        try {
            return userdao.queryNameByKeyWord(KeyWord);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
