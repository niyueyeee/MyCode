import cn.itcast.dao.OrderDao;
import cn.itcast.dao.ProductDao;
import cn.itcast.pojo.Order;
import cn.itcast.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author NiYueYeee
 * @create 2019-06-03 21:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class AppTest {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private OrderDao orderDao;

    @Test
    @Transactional
    public void testSave1() {
        Product product1 = new Product("小米9", 2999);
        Product product2 = new Product("华为p30 plus", 4999);

        Order order = new Order("买给媳妇儿礼物", 7998);


        //创建数据间的关系
        order.getProductList().add(product1);
        order.getProductList().add(product2);

        product1.getOrderList().add(order);
        product2.getOrderList().add(order);


        productDao.save(product1);
        productDao.save(product2);
        orderDao.save(order);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testSave2() {
        Product product1 = new Product("小米9", 2999);
        Product product2 = new Product("华为p30 plus", 4999);

        Order order = new Order("买给媳妇儿礼物", 7998);


        //创建数据间的关系
        order.getProductList().add(product1);
        order.getProductList().add(product2);


        orderDao.save(order);

    }


    @Test
    @Transactional
    @Rollback(false)
    public void testDelete() {
        Product product = productDao.findById(1).get();


        productDao.delete(product);

    }

}
