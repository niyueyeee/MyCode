package service;
import dao.ProductDao;
import domain.product;

import java.sql.SQLException;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-01 20:58
 */
public class ProductService {
    public List<product> queryServlet() throws SQLException {
        ProductDao dp = new ProductDao();
        return dp.queryAll();
    }
}
