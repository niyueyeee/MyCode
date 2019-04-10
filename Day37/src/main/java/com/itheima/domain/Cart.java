package com.itheima.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
  购物车
      总金额
      多个购物项
 */
public class Cart {

    private double total;//总金额

    //多个购物项 使用Map集合表示  这样后期容易做添加以及删除
    private Map<String,CartItem> itemMap = new HashMap<>();

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    /**
     *   返回的 是  双列集合  转换成json 在前端就变成对象形式
     *
     *   如果 咱们把这个返回值类型变成 单列集合
     *       转成json的时候  前端就是变成数组
     * @return
     */
    public Collection<CartItem> getItemMap() {
        return itemMap.values();
    }

    public void setItemMap(
            Map<String, CartItem> itemMap) {
        this.itemMap = itemMap;
    }

    /**
     *   将 一个(商品+数量)购物项 添加到购物车中
     *     实际上就是将 一个购物项 添加到 购物车 的 map集合中
     */
    public void  addCart(CartItem cartItem){
        //1：获取 新的购物项中 商品的pid
        String pid = cartItem.getProduct().getPid();

        //2:判断 该pid有没有  在map集合中出现过
        if(itemMap.containsKey(pid)){//包含这个pid的 购物项已经存在了
            // 已经存在了 就找到之前的 购物项  将数量进行累加
            // 取出之前的
            CartItem oldItem = itemMap.get(pid);
            //  将数量进行累加
            //生成一个 新的数量
            int newCount = oldItem.getCount()+cartItem.getCount();
            //新的数量 再次存储到之前的购物项中
            oldItem.setCount(newCount);
        }else{//该pid对应的购物项 不存在 新添加
            itemMap.put(pid,cartItem);
        }
        // 总金额 =  以前的总金额+新购物项的小计
        total += cartItem.getSubTotal();
    }

    /**
     * 删除指定的购物项
     */
    public void removeItem(String pid){
        //根据pid删除
        CartItem removeItem = itemMap.remove(pid);

        total -=  removeItem.getSubTotal();
    }

    /**
     *  清空购物车
     */
    public void clearCart(){
        itemMap.clear();

        total = 0;
    }
}
