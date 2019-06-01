package com.itheima.dao.impl;

import com.itheima.constant.Constant;
import com.itheima.dao.CategoryDao;
import com.itheima.dao.ProductDao;
import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    //查询最新商品
    @Override
    public List<Product> findNews() throws SQLException {
        String sql = "SELECT * FROM product WHERE pflag=? ORDER BY pdate DESC LIMIT ?";
        Object[] params = {Constant.WEI_XIA_JIA, 9};

        return qr.query(sql, new BeanListHandler<>(Product.class), params);
    }

    //查询最热门 商品
    @Override
    public List<Product> findHots() throws SQLException {
        String sql = "SELECT * FROM product WHERE pflag=? AND is_hot=? ORDER BY pdate DESC LIMIT ?";
        Object[] params = {Constant.WEI_XIA_JIA, Constant.IS_HOT, 9};

        return qr.query(sql, new BeanListHandler<>(Product.class), params);
    }

    //根据pid查询指定的商品信息
    @Override
    public Product pinfo(String pid) throws SQLException {
        String sql = "select * from product where pid=?";
        Object[] params = {pid};

        return qr.query(sql, new BeanHandler<>(Product.class), params);
    }

    /*
    查询某个分类下的 商品总条数
     */
    @Override
    public long totalByCid(String cid) throws SQLException {
        String sql = "select count(*) from product where cid=?";
        Object[] params = {cid};
        return qr.query(sql, new ScalarHandler<>(), params);
    }

    @Override
    public List<Product> findProductsByCid(String cid, int pageNumber,
                                           int pageSize) throws SQLException {
        String sql = "select * from product where cid=? limit ?,?";

        Object[] params = {cid, (pageNumber - 1) * pageSize, pageSize};

        return qr.query(sql, new BeanListHandler<>(Product.class), params);
    }

    //查询所有商品
    @Override
    public List<Product> findProducts(int pageNumber, int pageSize) throws SQLException {
        String sql = "select * from product limit ?,?";

        Object[] params = {(pageNumber - 1) * pageSize, pageSize};

        return qr.query(sql, new BeanListHandler<>(Product.class), params);
    }

    //查询所有商品数量
    @Override
    public long ProductTotal() throws SQLException {
        String sql = "select count(*) from product";
        return qr.query(sql, new ScalarHandler<>());
    }
    //添加商品

    @Override
    public void saveProduct(Product p) throws SQLException {
        String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {p.getPid(), p.getPname(), p.getMarket_price(),
                p.getShop_price(), p.getPimage(), p.getPdate(),
                p.getIs_hot(), p.getPdesc(), p.getPflag(),
                p.getCid()};

        qr.update(sql, params);
    }
}
