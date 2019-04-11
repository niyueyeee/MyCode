package dao;

import domain.conditionProduct;
import domain.product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;
import utils.C3P0Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-01 20:10
 */
public class ProductDao {
    @Test
    public void cs() throws SQLException {
        System.out.println(coundPage());
    }

    @Test
    public void ss() throws SQLException {
        List<product> products = limitQuery(44);
        for (product product : products) {
            System.out.println(product);
        }
    }

    QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

    //查询所有
    public List<product> queryAll() throws SQLException {

        String sql = "SELECT * FROM product";
        return qr.query(sql, new BeanListHandler<>(domain.product.class));
    }

    //按名字查询所有
    public int dlDao(String p) throws SQLException {
        String sql = "DELETE FROM product WHERE pid=?";
        return qr.update(sql, p);
    }

    //条件查询所有
    public List<product> conditionQuery(conditionProduct c) throws SQLException {
        StringBuilder sql = new StringBuilder("SELECT * FROM product WHERE 1=1");
        String mohu = c.getMohu();
        String min_price = c.getMin_price();
        String max_price = c.getMax_price();
        String is_hot = c.getIs_hot();

        ArrayList<String> list = new ArrayList<>();

        if (mohu != null && !"".equals(mohu.trim())) {
            sql.append(" AND pname LIKE ?");
            list.add("%" + mohu + "%");
        }

        if (min_price != null && !"".equals(min_price.trim())) {
            sql.append(" AND shop_price >= ?");
            list.add(min_price);
        }

        if (max_price != null && !"".equals(max_price.trim())) {
            sql.append(" AND shop_price <= ?");
            list.add(max_price);
        }

        if (is_hot != null && !"".equals(is_hot.trim())) {
            sql.append(" AND is_hot = ?");
            list.add(is_hot);
        }

        System.out.println(sql.toString());
        System.out.println(list.toArray());

        return qr.query(sql.toString(), new BeanListHandler<>(product.class), list.toArray());
    }

    //查询总页数
    public Object coundPage() throws SQLException {
        String sql = "SELECT count(*) FROM product";
        Object query = qr.query(sql, new ScalarHandler());
        return query;
    }

    //查询数据
    public List<product> limitQuery(int c) throws SQLException {
        String sql = "SELECT * FROM product LIMIT ?,12";
        return qr.query(sql, new BeanListHandler<>(product.class), (c - 1) * 12);

    }
}
