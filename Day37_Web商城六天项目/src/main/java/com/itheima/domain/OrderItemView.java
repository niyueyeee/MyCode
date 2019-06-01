package com.itheima.domain;

/*
   订单展示项类
         用于 给前端  让前端方便展示的

         属性 六个
            商品主键  商品图片  商品名称 商品价格  商品数量  小计
 */
public class OrderItemView {

    private String pid;
    private String pimage;
    private String pname;
    private double shop_price;
    private int count;
    private double subTotal;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getShop_price() {
        return shop_price;
    }

    public void setShop_price(double shop_price) {
        this.shop_price = shop_price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
