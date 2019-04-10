package com.itheima.web.servlet;

import com.itheima.constant.Constant;
import com.itheima.domain.Category;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.CategoryService;
import com.itheima.service.ProductService;
import com.itheima.utils.BeanFactory;
import com.itheima.web.view.Result;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/product")
public class ProductServlet extends BaseServlet {

    private ProductService productService = BeanFactory.newInstance(ProductService.class);


    /**
     *  查询 最新最热商品信息
     * @param request
     * @param response
     */
    public void findNewsAndHots(HttpServletRequest request, HttpServletResponse response)
            throws InvocationTargetException, IllegalAccessException,
                   IOException {

        //找 service查询
        List<Product> news = productService.findNews();
        List<Product> hots = productService.findHots();

        //一起放在 map里面
        Map<String,List<Product>> map = new HashMap<>();

        map.put("news",news);
        map.put("hots",hots);

        // 将响应数据 封装 result对象 转换成json返回
        Result result = new Result(Constant.SUCCESS,"查询最新最热商品成功",map);

        response.getWriter().write(JSONObject.fromObject(result).toString());


    }

    /**
     *  根据pid查询指定商品
     * @param request
     * @param response
     */
    public void pinfo(HttpServletRequest request, HttpServletResponse response)
            throws InvocationTargetException, IllegalAccessException,
                   IOException {

        // 获取pid
        String pid = request.getParameter("pid");

        // 找service查询
        Product product = productService.pinfo(pid);

        if(product==null){
            // 将响应数据 封装 result对象 转换成json返回
            Result result = new Result(Constant.FAILS,"此商品不存在");

            response.getWriter().write(JSONObject.fromObject(result).toString());

            return;
        }

        //有数据  封装到result中
        // 将响应数据 封装 result对象 转换成json返回
        Result result = new Result(Constant.SUCCESS,"查询指定商品成功",product);

        response.getWriter().write(JSONObject.fromObject(result).toString());




    }

    /**
     *  根据cid查询商品 并分页展示
     * @param request
     * @param response
     */
    public void findProductsByCid(HttpServletRequest request, HttpServletResponse response)
            throws InvocationTargetException, IllegalAccessException,
                   IOException {
        //获取 分类cid
        String cid = request.getParameter("cid");
        //查询页码
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        //每页条数
        int pageSize = 12;

        //找service 返回PageBean对象
        PageBean<Product> pb = productService
                .getPageBeanByCid(cid, pageNumber, pageSize);

        //有数据  封装到result中
        // 将响应数据 封装 result对象 转换成json返回
        Result result = new Result(Constant.SUCCESS,"分页查询成功",pb);

        response.getWriter().write(JSONObject.fromObject(result).toString());




    }



}
