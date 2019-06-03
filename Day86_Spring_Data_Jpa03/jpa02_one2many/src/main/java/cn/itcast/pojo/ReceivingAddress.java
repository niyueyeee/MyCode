package cn.itcast.pojo;

import javax.persistence.*;

/**
 *
 * 收货地址
 *
 */
@Entity
@Table(name="t_ra")
public class ReceivingAddress {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int raid;
    @Column
    private String address;
    @Column
    private String postcode;
    @Column
    private String telephone;



    @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="rid",referencedColumnName = "id")
    private User user;




    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ReceivingAddress() {
    }

    public ReceivingAddress(String address, String postcode, String telephone) {
        this.address = address;
        this.postcode = postcode;
        this.telephone = telephone;
    }

    public int getRaid() {
        return raid;
    }

    public void setRaid(int raid) {
        this.raid = raid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "ReceivingAddress{" +
                "raid=" + raid +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
