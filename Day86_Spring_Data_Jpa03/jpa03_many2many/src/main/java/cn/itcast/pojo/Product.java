package cn.itcast.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int pid;
    @Column
    private String pname;
    @Column
    private double price;
    @ManyToMany(mappedBy = "productList",cascade = CascadeType.ALL)
    /*@JoinTable(
            name="t_product_order",
            joinColumns = @JoinColumn(name = "fk_pid",referencedColumnName = "pid"),
            inverseJoinColumns = @JoinColumn(name = "fk_oid",referencedColumnName = "oid")
    )*/
    private List<Order> orderList=new ArrayList<>();

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product() {
    }

    public Product(String pname, double price) {
        this.pname = pname;
        this.price = price;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                '}';
    }
}
