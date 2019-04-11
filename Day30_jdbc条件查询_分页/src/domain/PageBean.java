package domain;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-03-03 14:24
 */
public class PageBean {
    private int totalPage;  // 总页数
    private int currentPage;  // 当前页数
    private  int num =12;    // 每个 12个

    @Override
    public String toString() {
        return "PageBean{" +
                "totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", num=" + num +
                ", productList=" + productList +
                '}';
    }

    public double getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(double totalPage) {
        this.totalPage = (int) totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<product> getProductList() {
        return productList;
    }

    public void setProductList(List<product> productList) {
        this.productList = productList;
    }

    public PageBean(int totalPage, int currentPage, int num, List<product> productList) {
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.num = num;
        this.productList = productList;
    }

    public PageBean() {
    }

    private List<product> productList;   // 分页的商品数据 .
}
