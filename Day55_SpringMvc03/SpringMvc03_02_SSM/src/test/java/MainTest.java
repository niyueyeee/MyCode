import com.itheima.ssm.pojo.Item;
import com.itheima.ssm.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-11 10:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml", "classpath:applicationContext-service.xml"})
public class MainTest {

    @Autowired
    private ItemService itemService;

    @Test
    public void queeryItemByList() throws Exception {
        List<Item> items = itemService.queryItemByList();

        if (items != null && items.size() > 0) {
            items.forEach(System.out::println);
        }
    }
}

