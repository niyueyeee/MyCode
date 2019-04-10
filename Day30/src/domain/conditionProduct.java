package domain;

/**
 * @author niyueyeee
 * @create 2019-03-02 21:30
 */
public class conditionProduct {
    @Override
    public String toString() {
        return "conditionProduct{" +
                "mohu='" + mohu + '\'' +
                ", min_price='" + min_price + '\'' +
                ", max_price='" + max_price + '\'' +
                ", is_hot='" + is_hot + '\'' +
                '}';
    }

    public String getMohu() {
        return mohu;
    }

    public void setMohu(String mohu) {
        this.mohu = mohu;
    }

    public String getMin_price() {
        return min_price;
    }

    public void setMin_price(String min_price) {
        this.min_price = min_price;
    }

    public String getMax_price() {
        return max_price;
    }

    public void setMax_price(String max_price) {
        this.max_price = max_price;
    }

    public String getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(String is_hot) {
        this.is_hot = is_hot;
    }

    public conditionProduct() {
    }

    public conditionProduct(String mohu, String min_price, String max_price, String is_hot) {
        this.mohu = mohu;
        this.min_price = min_price;
        this.max_price = max_price;
        this.is_hot = is_hot;
    }

    private String mohu;   //  关键字 用户模糊查询
    private String min_price;    // 最低价格
    private String max_price;   // 最高价格
    private String is_hot;     //  热卖 .
}
