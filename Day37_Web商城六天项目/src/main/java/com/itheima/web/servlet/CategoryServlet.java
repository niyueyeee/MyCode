package com.itheima.web.servlet;

import com.itheima.constant.Constant;
import com.itheima.domain.Category;
import com.itheima.domain.User;
import com.itheima.service.CategoryService;
import com.itheima.service.UserService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.UUIDUtils;
import com.itheima.web.view.Result;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/category")
public class CategoryServlet extends BaseServlet {

    private CategoryService categoryService = BeanFactory.newInstance(CategoryService.class);


    /**
     * 查询所有的分类信息
     *
     * @param request
     * @param response
     */
    public void findAllCategorys(HttpServletRequest request, HttpServletResponse response)
            throws InvocationTargetException, IllegalAccessException,
            IOException {

        // 找service
        List<Category> categorys = categoryService.findAllCategorys();


        if (categorys != null && categorys.size() > 0) {

            // 将响应数据 封装 result对象 转换成json返回
            Result result = new Result(Constant.SUCCESS, "查询成功", categorys);

            response.getWriter().write(JSONObject.fromObject(result).toString());

            return;
        }

        // 将响应数据 封装 result对象 转换成json返回
        Result result = new Result(Constant.FAILS, "没有分类信息");

        response.getWriter().write(JSONObject.fromObject(result).toString());

    }


}
