import com.itheima.pojo.Article;
import com.itheima.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author NiYueYeee
 * @create 2019-06-08 21:44
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class SpringDataEsTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ArticleService articleService;

    /**
     * 创建索引
     * 配置映射
     */
    @Test
    public void createIndex(){
        elasticsearchTemplate.createIndex(Article.class);//创建索引
        elasticsearchTemplate.putMapping(Article.class);//配置映射
    }

}
