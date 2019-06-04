package cn.itcast.pojo;

import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int oid;
    @Column
    private String oname;
    @Column
    private double total;



    @ManyToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "t_product_order",
            joinColumns = @JoinColumn(name = "fk_oid", referencedColumnName = "oid"),
            inverseJoinColumns = @JoinColumn(name = "fk_pid", referencedColumnName = "pid")
    )



    private List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Order() {
    }

    public Order(String oname, double total) {
        this.oname = oname;
        this.total = total;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", oname='" + oname + '\'' +
                ", total=" + total +
                '}';
    }
}
