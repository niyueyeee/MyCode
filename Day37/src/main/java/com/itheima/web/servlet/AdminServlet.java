package com.itheima.web.servlet;

import com.itheima.constant.Constant;
import com.itheima.domain.Category;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.exception.CanNotDeleteException;
import com.itheima.service.CategoryService;
import com.itheima.service.ProductService;
import com.itheima.service.impl.ProductServiceImpl;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.UUIDUtils;
import com.itheima.web.view.Result;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-23 20:15
 */
@WebServlet("/admin")
public class AdminServlet extends BaseServlet {
    private CategoryService categoryService = BeanFactory.newInstance(CategoryService.class);
    private ProductService productService = BeanFactory.newInstance(ProductService.class);

    /**
     * 查询所有的分类信息
     *
     * @param request
     * @param response
     */
    public void findAllCategorys(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Category> allCategorys = categoryService.findAllCategorys();
        if (allCategorys != null && allCategorys.size() > 0) {

            // 将响应数据 封装 result对象 转换成json返回
            Result result = new Result(Constant.SUCCESS, "查询成功", allCategorys);
            response.getWriter().write(JSONObject.fromObject(result).toString());
            return;
        }

        // 将响应数据 封装 result对象 转换成json返回
        Result result = new Result(Constant.FAILS, "没有分类信息");
        response.getWriter().write(JSONObject.fromObject(result).toString());
    }

    /**
     * 添加分类
     *
     * @param request
     * @param response
     */
    public void addCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cname = request.getParameter("cname");
        Category category = new Category();
        category.setCname(cname);
        category.setCid(UUIDUtils.getUUID());

        categoryService.addCategory(category);

        // 将响应数据 封装 result对象 转换成json返回
        Result result = new Result(Constant.SUCCESS, "添加分类信息成功");
        response.getWriter().write(JSONObject.fromObject(result).toString());
    }

    /**
     * 按名字查找分类信息
     *
     * @param request
     * @param response
     */
    public void fandCategoryByCid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cid = request.getParameter("cid");
        Category allCategorys = categoryService.fandCategoryByCid(cid);
        if (allCategorys != null) {

            // 将响应数据 封装 result对象 转换成json返回
            Result result = new Result(Constant.SUCCESS, "查询成功", allCategorys);
            response.getWriter().write(JSONObject.fromObject(result).toString());
            return;
        }

        // 将响应数据 封装 result对象 转换成json返回
        Result result = new Result(Constant.FAILS, "没有分类信息");
        response.getWriter().write(JSONObject.fromObject(result).toString());
    }

    /**
     * 按名字修改分类信息
     *
     * @param request
     * @param response
     */
    public void editCategroy(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cname = request.getParameter("cname");
        String cid = request.getParameter("cid");
        Category category = new Category();
        category.setCid(cid);
        category.setCname(cname);
        categoryService.editCategroy(category);

        Result result = new Result(Constant.SUCCESS, "数据修改成功");
        response.getWriter().write(JSONObject.fromObject(result).toString());
        return;
    }

    /**
     * 删除分类信息
     *
     * @param request
     * @param response
     */
    public void delByCid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cid = request.getParameter("cid");

        try {
            categoryService.delByCid(cid);
        } catch (CanNotDeleteException e) {
            System.out.println("******************************************");
            Result result = new Result(Constant.FAILS, e.getMessage());
            response.getWriter().write(JSONObject.fromObject(result).toString());
            return;
        }

        Result result = new Result(Constant.SUCCESS, "该分类信息删除成功！！");
        response.getWriter().write(JSONObject.fromObject(result).toString());
        return;
    }


    /**
     * 查询商品信息
     *
     * @param request
     * @param response
     */
    public void findAllProducts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pageNumber = request.getParameter("pageNumber");
        PageBean<Product> list = productService.getPageBeanBy(Integer.parseInt(pageNumber), 15);

        Result result = new Result(Constant.SUCCESS, "查询商品信息成功！", list);
        response.getWriter().write(JSONObject.fromObject(result).toString());
        return;
    }
}
