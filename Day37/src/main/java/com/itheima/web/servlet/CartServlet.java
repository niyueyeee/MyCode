package com.itheima.web.servlet;

import com.itheima.constant.Constant;
import com.itheima.domain.Cart;
import com.itheima.domain.CartItem;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
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

@WebServlet("/cart")
public class CartServlet extends BaseServlet {

    private ProductService productService = BeanFactory.newInstance(ProductService.class);


    /**
     *  将 (商品+数量)---》购物项  添加到购物车中
     * @param request
     * @param response
     */
    public void addCart(HttpServletRequest request, HttpServletResponse response)
            throws InvocationTargetException, IllegalAccessException,
                   IOException {

        //1:获取pid  count
        String pid = request.getParameter("pid");
        int count = Integer.parseInt(request.getParameter("count"));

        //2:根据pid获取 商品信息
        Product product = productService.pinfo(pid);

        //3:封装 购物项对象
        CartItem cartItem = new CartItem();

        cartItem.setProduct(product);
        cartItem.setCount(count);
        cartItem.setSubTotal(cartItem.getSubTotal());


        //4:将购物项对象添加到购物车

        /*
           购物车在哪？
              分析的时候说了
                 购物车要存储与 session 当前会话中！！！

              想要购物车
                 去session中找
         */
        Cart cart = getCart(request);

        //完成添加
        cart.addCart(cartItem);

        // 将响应数据 封装 result对象 转换成json返回
        Result result = new Result(Constant.SUCCESS,"已经将该购物项添加到购物车");

        response.getWriter().write(JSONObject.fromObject(result).toString());


    }
    /**
     * 展示购物车方法
     */
    public void showCart(HttpServletRequest request, HttpServletResponse response)
            throws InvocationTargetException, IllegalAccessException,
                   IOException {

        //1:获取 session中的 cart对象
        Cart cart = getCart(request);

        //2 响应出去

        // 将响应数据 封装 result对象 转换成json返回
        Result result = new Result(Constant.SUCCESS,"购物车对象已经返回给前端！",cart);

        response.getWriter().write(JSONObject.fromObject(result).toString());


    }

    /**
     * 根据pid删除 购物项
     */
    public void removeItem(HttpServletRequest request, HttpServletResponse response)
            throws InvocationTargetException, IllegalAccessException,
                   IOException {

        //1:获取 pid
        String pid = request.getParameter("pid");

        //获取到 购物车
        Cart cart = getCart(request);

        cart.removeItem(pid);

        //2 响应出去

        // 将响应数据 封装 result对象 转换成json返回
        Result result = new Result(Constant.SUCCESS,"该购物项已被删除！");

        response.getWriter().write(JSONObject.fromObject(result).toString());



    }


    /**
     * 清空购物车
     */
    public void clearCart(HttpServletRequest request, HttpServletResponse response)
            throws InvocationTargetException, IllegalAccessException,
                   IOException {


        //获取到 购物车
        Cart cart = getCart(request);

        cart.clearCart();

        //2 响应出去

        // 将响应数据 封装 result对象 转换成json返回
        Result result = new Result(Constant.SUCCESS,"购物车已经清空！");

        response.getWriter().write(JSONObject.fromObject(result).toString());


    }


    /**
     *   从 session中 获取 Cart对象
     * @param request
     * @return
     */
    public Cart getCart(HttpServletRequest request) {

        // 从session域中取出 cart对象
        Cart cart = (Cart)request.getSession().getAttribute("cart");

        if(cart==null){//第一次来  需要new一个出来 存储到 session中

            cart = new Cart();

            request.getSession().setAttribute("cart",cart);

        }

        return cart;
    }

}
