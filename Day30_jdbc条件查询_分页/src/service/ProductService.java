package service;

import dao.ProductDao;
import domain.PageBean;
import domain.conditionProduct;
import domain.product;

import java.sql.SQLException;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-01 20:58
 */
public class ProductService {
    ProductDao dp = new ProductDao();

    public List<product> queryService() {

        try {
            return dp.queryAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean dlService(String p) {
        try {
            if (dp.dlDao(p) == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //条件查询
    public List<product> conditionService(conditionProduct c) {
        try {
            return dp.conditionQuery(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //分页查询
    public PageBean fenye(String p) {
        PageBean page = new PageBean();

        //设置当前页
        page.setCurrentPage(Integer.parseInt(p));

        //获取总页数
        Object o = null;
        try {
            o = new ProductDao().coundPage();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int i = Integer.parseInt(o.toString());
        double ceil = Math.ceil(i / 12.0);
        System.out.println(ceil);
        page.setTotalPage((int) ceil);
        //获取页数据
        List<product> products = null;
        try {
            products = new ProductDao().limitQuery(Integer.parseInt(p));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        page.setProductList(products);
        return page;
    }

}
