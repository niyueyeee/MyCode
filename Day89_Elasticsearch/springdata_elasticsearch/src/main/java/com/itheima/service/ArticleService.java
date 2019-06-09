package com.itheima.service;

import com.itheima.pojo.Article;

import java.util.List;

/**
 * @author NiYueYeee
 * @create 2019-06-08 21:36
 */
public interface ArticleService {
    void save(Article article);

    void saveAll(List list);

    void update(Article article);

    void delete(Article article);

    Iterable<Article> findAll();

    Iterable<Article> findAll(int i, int i1);

    List<Article> findByTitleAndContent(String title, String content);

    List<Article> findByIdBetween(int min, int max);
}
