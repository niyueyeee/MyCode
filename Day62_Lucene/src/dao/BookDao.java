package dao;


import pojo.Book;

import java.util.List;

public interface BookDao {
    //查询所有书的结果集
    public List<Book> queryBookList() throws ClassNotFoundException;
}
