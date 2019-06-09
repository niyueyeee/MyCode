package com.itheima.service.impl;

import com.itheima.dao.ArticleDao;
import com.itheima.pojo.Article;
import com.itheima.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author NiYueYeee
 * @create 2019-06-08 21:37
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public void save(Article article) {
        articleDao.save(article);
    }

    public void saveAll(List list) {
        articleDao.saveAll(list);
    }

    public void update(Article article) {
        articleDao.save(article);
    }

    public void delete(Article article) {
        articleDao.delete(article);
    }

    public Iterable<Article> findAll() {
        return articleDao.findAll();
    }

    public Iterable<Article> findAll(int i, int i1) {
        PageRequest of = PageRequest.of(i, i1);
        return articleDao.findAll(of);
    }

    public List<Article> findByTitleAndContent(String title, String content) {
        return articleDao.findByTitleAndContent(title, content);
    }

    public List<Article> findByIdBetween(int min, int max) {
        return articleDao.findByIdBetween(min, max);
    }


}
