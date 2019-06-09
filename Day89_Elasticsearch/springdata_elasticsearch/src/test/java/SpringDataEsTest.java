import com.itheima.pojo.Article;
import com.itheima.service.ArticleService;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
    public void createIndex() {
        elasticsearchTemplate.createIndex(Article.class);//创建索引
        elasticsearchTemplate.putMapping(Article.class);//配置映射
    }

    /**
     * 创建文档
     */
    @Test
    public void save() {
        Article article = new Article();
        article.setId(1);
        article.setTitle("ElasticSearch是一个基于Lucene的搜索服务器。");
        article.setContent("它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful");
        articleService.save(article);
    }

    /**
     * 批量新增100条
     */
    @Test
    public void saveAll() {
        List list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            Article article = new Article();
            article.setId(i);
            article.setTitle("[" + i + "]ElasticSearch是一个基于Lucene的搜索服务器。");
            article.setContent("[" + i + "]它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的，并作为Apache许可条款下的开");
            list.add(article);
        }
        articleService.saveAll(list);
    }

    /**
     * 修改文档
     */
    @Test
    public void update() {
        Article article = new Article();
        article.setId(1);
        article.setTitle("[修改]ElasticSearch是一个基于Lucene的搜索服务器。");
        article.setContent("[修改]它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的，并作为Apache许可条款下的开");
        articleService.update(article);
    }

    /**
     * 删除文档
     */
    @Test
    public void del() {
        Article article = new Article();
        article.setId(1);
        articleService.delete(article);
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll() {
        Iterable<Article> list = articleService.findAll();
        int i = 0;
        for (Article article : list) {
            System.out.println(article);
            i++;
        }
        System.out.println("总条数:" + 1);
    }

    /**
     * 分页查询
     */
    @Test
    public void finAllByPage() {
        Iterable<Article> list = articleService.findAll(0, 20);
        int i = 0;
        for (Article article : list) {
            System.out.println(article);
            i++;
        }
        System.out.println("总条数：" + i);
    }

    /**
     * 复合查询and、or、Between
     */
    @Test
    public void findByTitleAndContent() {
        String title = "搜索";
        String content = "分布式";
        int min = 1;
        int max = 5;
        //And 条件
//        List<Article> list = articleService.findByTitleAndContent(title, content);
        List<Article> list = articleService.findByIdBetween(min, max);
        for (Article article : list) {
            System.out.println(article);
        }
        System.out.println("总条数：" + list.size());
    }

    /**
     * 原生查询
     * 分页、高亮，term，queryString
     */
    @Test
    public void nativeQuery() {
        //原生查询对象
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(QueryBuilders.termQuery("title", "搜索"));
        queryBuilder.withPageable(PageRequest.of(0, 5));
        NativeSearchQuery searchQuery = queryBuilder.build();

        List<Article> articles = elasticsearchTemplate.queryForList(searchQuery, Article.class);
        for (Article article : articles) {
            System.out.println(article);
        }
    }
    /**
     * 客户端注入
     */
//    @Test
//    public void Client(){
//        SearchRequestBuilder requestBuilder = client.prepareSearch("blog2");
//        System.out.println(requestBuilder);
//    }
}
