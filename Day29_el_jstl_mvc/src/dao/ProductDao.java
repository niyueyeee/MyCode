package dao;

import domain.product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.C3P0Util;

import java.sql.SQLException;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-01 20:10
 */
public class ProductDao {
    public void cs() throws SQLException {
        for (product product : queryAll()) {
            System.out.println(product);
        }
    }
    public List<product> queryAll() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = "SELECT * FROM product";
        return qr.query(sql,new BeanListHandler<>(domain.product.class));
    }
}
