package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-15 20:11
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * 分页助手
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAll3")
    public ModelAndView findAll3(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Product> pageInfo = productService.findByPageHelper(pageNum, pageSize);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    /**
     * 手动分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAll2")
    public ModelAndView findAll2(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        PageBean<Product> pageBean = productService.findByPage(pageNum, pageSize);
        modelAndView.addObject("pageBean", pageBean);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    /**
     * 查询全部
     *
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        //1. 创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //2.  查询所有的产品
        List<Product> productList = productService.findAll();
        //3. 添加数据到模型
        modelAndView.addObject("productList", productList);
        //4. 指定页面
        modelAndView.setViewName("product-list");
        //5. 返回ModelAndView对象
        return modelAndView;
    }

    /**
     * 添加
     *
     * @return
     */
    @RequestMapping("/save")
    public String save(Product product) {
        productService.save(product);
        return "redirect:/product/findAll";
    }

    /**
     * 更新产品页面数据回显
     *
     * @param id
     * @return
     */
    @RequestMapping("/updateUI")
    public ModelAndView updateUI(Integer id) {
        //1. 创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //2.  查询所有的产品
        Product product = productService.findById(id);
        //3. 添加数据到模型
        modelAndView.addObject("product", product);
        //4. 指定页面
        modelAndView.setViewName("product-update");
        //5. 返回ModelAndView对象
        return modelAndView;
    }

    /**
     * 更新数据
     *
     * @param product
     */
    @RequestMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/product/findAll";
    }

    /**
     * 删除单个
     *
     * @return
     */
    @RequestMapping("/delOne")
    public String delOne(Integer id) {
        productService.delOne(id);
        return "redirect:/product/findAll";
    }

    /**
     * 删除多个
     *
     * @param ids
     * @return
     */
    @RequestMapping("/delMany")
    public String delMany(Integer[] ids) {
        productService.delMany(ids);
        return "redirect:/product/findAll";
    }
}
