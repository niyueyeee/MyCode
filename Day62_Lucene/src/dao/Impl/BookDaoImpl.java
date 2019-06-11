package dao.Impl;


import dao.BookDao;
import pojo.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-20 21:04
 */
public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> queryBookList() throws ClassNotFoundException {
        ArrayList<Book> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm?useSSL=false&serverTimezone=Hongkong&characterEncoding=utf-8&autoReconnect=true", "root", "00008888");
            // SQL语句
            String sql = "SELECT * FROM book";
            ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setPrice(resultSet.getFloat("price"));
                book.setPic(resultSet.getString("pic"));
                book.setDesc(resultSet.getString("description"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
