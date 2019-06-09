package com.itheima.dao;

import com.itheima.pojo.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author NiYueYeee
 * @create 2019-06-08 21:34
 */
@Repository
public interface ArticleDao extends ElasticsearchCrudRepository<Article,Integer> {

}
