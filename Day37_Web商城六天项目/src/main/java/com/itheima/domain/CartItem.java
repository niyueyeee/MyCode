package com.itheima.domain;
/*
  购物项类
      对应商品信息
      数量
      小计
 */
public class CartItem {

    private Product product;//购物项对应的商品
    private int count;//当前购物项中商品的数量
    private double subTotal;//当前购物项中商品小计

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubTotal() {

        subTotal = count*product.getShop_price();

        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
