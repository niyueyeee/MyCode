package com.itheima.web.servlet;

import com.itheima.annotation.Auth;
import com.itheima.constant.Constant;
import com.itheima.domain.*;
import com.itheima.service.OrderService;
import com.itheima.service.ProductService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.PaymentUtil;
import com.itheima.utils.UUIDUtils;
import com.itheima.web.view.Result;
import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/order")
public class OrderServlet extends BaseServlet {

    private ProductService productService = BeanFactory.newInstance(ProductService.class);
    private OrderService orderService = BeanFactory.newInstance(OrderService.class);


    /**
     * 提交订单
     *
     * @param request
     * @param response
     */
    @Auth
    public void submitOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {

        User user = (User) request.getSession().getAttribute("user");


        // 登陆就可以继续
        //2:判断 购物车有没有 还有购物车中是否购物项
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart == null || cart.getItemMap().size() == 0) {//没有购物车 购物车里面没有购物项
            // 将响应数据 封装 result对象 转换成json返回
            Result result = new Result(Constant.FAILS, "你还没有添加商品，请先添加商品到购物车中！");

            response.getWriter().write(JSONObject.fromObject(result).toString());
            return;
        }

        // 代码执行这里  说明 用户登陆了 购物车中 有购物项
        /**
         *  进行数据转换 将 购物车信息 ----->订单信息
         *     封装 订单信息
         */
        Orders orders = new Orders();

        // oid,ordertime,total,state,uid
        // 生成 oid 当前订单id
        String oid = UUIDUtils.getUUID();
        orders.setOid(oid);
        // ordertime  yyyy-MM-dd HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ordertime = sdf.format(new Date());
        orders.setOrdertime(ordertime);
        // total
        orders.setTotal(cart.getTotal());
        // state 默认未付款
        orders.setState(Constant.WEI_FU_KUAN);
        // uid  用户id
        orders.setUid(user.getUid());

        // 将订单信息 存到数据
        orderService.saveOrders(orders);


        // 完成订单项的转换   购物项---->订单项
        Collection<CartItem> cartItems = cart.getItemMap();

        for (CartItem cartItem : cartItems) {
            // cartItem 每一个 购物项信息  ----变成 订单项信息
            OrderItem orderItem = new OrderItem();
            //设置订单号
            orderItem.setOid(oid);
            //商品id
            orderItem.setPid(cartItem.getProduct().getPid());
            //数量
            orderItem.setCount(cartItem.getCount());
            //小计
            orderItem.setSubTotal(cartItem.getSubTotal());

            //将生成的订单项 存到数据库
            orderService.saveOrderItem(orderItem);
        }

        // 清空购物车
        cart.clearCart();

        Result result = new Result(Constant.SUCCESS, "订单已经提交了,明儿记得付款！");

        response.getWriter().write(JSONObject.fromObject(result).toString());
    }

    /**
     * 订单查询
     *
     * @param request
     * @param response
     */
    @Auth
    public void showOrders(HttpServletRequest request, HttpServletResponse response) throws Exception {

        User user = (User) request.getSession().getAttribute("user");

        //设置参数
        String pageNumber = request.getParameter("pageNumber");
        String uid = user.getUid();
        int pagesize = 3;

        PageBean<Orders> byPage = orderService.findByPage(uid, Integer.parseInt(pageNumber), pagesize);

        Result result = new Result(Constant.SUCCESS, "查询订单成功！", byPage);
        response.getWriter().write(JSONObject.fromObject(result).toString());
    }

    /**
     * 订单详情
     *
     * @param request
     * @param response
     */
    @Auth
    public void info(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //设置参数
        String oid = request.getParameter("oid");
        Orders info = orderService.info(oid);

        Result result = new Result(Constant.SUCCESS, "查询订单成功！", info);
        response.getWriter().write(JSONObject.fromObject(result).toString());
    }

    /**
     * 发起支付
     *
     * @param request
     * @param response
     */
    public void pay(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //接受参数
        String address = request.getParameter("address");
        String name = request.getParameter("name");
        String telephone = request.getParameter("telephone");
        String oid = request.getParameter("oid");


        //业务层方法,修改订单信息
        orderService.updateOrders(oid, address, name, telephone);


        // 组织发送支付公司需要哪些数据
        // 银行信息
        String pd_FrpId = request.getParameter("pd_FrpId");
        //
        String p0_Cmd = "Buy";
        //商户id
        String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
        //订单id
        String p2_Order = oid;
        // 支付金额
        String p3_Amt = "0.01";
        String p4_Cur = "CNY";
        String p5_Pid = "";
        String p6_Pcat = "";
        String p7_Pdesc = "";
        // 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
        // 第三方支付可以访问网址
        String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("responseURL");
        String p9_SAF = "";
        String pa_MP = "";
        String pr_NeedResponse = "1";
        // 加密hmac 需要密钥
        String keyValue = ResourceBundle.getBundle("merchantInfo").getString("keyValue");
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
                p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
                pd_FrpId, pr_NeedResponse, keyValue);


        //发送给第三方
        StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
        sb.append("p0_Cmd=").append(p0_Cmd).append("&");
        sb.append("p1_MerId=").append(p1_MerId).append("&");
        sb.append("p2_Order=").append(p2_Order).append("&");
        sb.append("p3_Amt=").append(p3_Amt).append("&");
        sb.append("p4_Cur=").append(p4_Cur).append("&");
        sb.append("p5_Pid=").append(p5_Pid).append("&");
        sb.append("p6_Pcat=").append(p6_Pcat).append("&");
        sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
        sb.append("p8_Url=").append(p8_Url).append("&");
        sb.append("p9_SAF=").append(p9_SAF).append("&");
        sb.append("pa_MP=").append(pa_MP).append("&");
        sb.append("pd_FrpId=").append(pd_FrpId).append("&");
        sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
        sb.append("hmac=").append(hmac);

        //        respone.sendRedirect(sb.toString());
        Result re = new Result(Constant.SUCCESS, "", sb.toString());
        response.getWriter().print(JSONObject.fromObject(re));

    }

    //支付成功后的回调方法
    public void callback(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String p1_MerId = request.getParameter("p1_MerId");
        String r0_Cmd = request.getParameter("r0_Cmd");
        String r1_Code = request.getParameter("r1_Code");
        String r2_TrxId = request.getParameter("r2_TrxId");
        String r3_Amt = request.getParameter("r3_Amt");
        String r4_Cur = request.getParameter("r4_Cur");
        String r5_Pid = request.getParameter("r5_Pid");
        String r6_Order = request.getParameter("r6_Order");
        String r7_Uid = request.getParameter("r7_Uid");
        String r8_MP = request.getParameter("r8_MP");
        String r9_BType = request.getParameter("r9_BType");
        String rb_BankId = request.getParameter("rb_BankId");
        String ro_BankOrderId = request.getParameter("ro_BankOrderId");
        String rp_PayDate = request.getParameter("rp_PayDate");
        String rq_CardNo = request.getParameter("rq_CardNo");
        String ru_Trxtime = request.getParameter("ru_Trxtime");
        // 身份校验 --- 判断是不是支付公司通知你
        String hmac = request.getParameter("hmac");
        String keyValue = ResourceBundle.getBundle("merchantInfo").getString(
                "keyValue");

        // 自己对上面数据进行加密 --- 比较支付公司发过来hamc
        boolean isValid = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
                r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
                r8_MP, r9_BType, keyValue);
        if (isValid) {
            // 响应数据有效
            if (r9_BType.equals("1")) {
                // 请求转发
                System.out.println("111");
                request.setAttribute("msg", "您的订单号为:" + r6_Order + ",金额为:" + r3_Amt + "已经支付成功,等待发货~~");

                request.setAttribute("oid", r6_Order);
                request.getRequestDispatcher("/success.jsp").forward(request, response);
            } else if (r9_BType.equals("2")) {
                // 服务器点对点 --- 支付公司通知你
                System.out.println("付款成功！222");
                // 修改订单状态 为已付款
                // 回复支付公司
                response.getWriter().print("success");
            }
            //订单状态,修改为已经付款
            orderService.updateState(r6_Order);

        } else {
            // 数据无效
            System.out.println("数据被篡改！");
        }
    }
}
