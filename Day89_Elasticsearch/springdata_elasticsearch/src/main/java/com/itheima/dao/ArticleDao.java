package com.itheima.dao;

import com.itheima.pojo.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author NiYueYeee
 * @create 2019-06-08 21:34
 */
@Repository
public interface ArticleDao extends ElasticsearchRepository<Article,Integer> {

    List<Article> findByTitleAndContent(String title, String content);

    List<Article> findByIdBetween(int min, int max);
}
