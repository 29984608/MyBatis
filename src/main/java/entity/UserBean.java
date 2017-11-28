package entity;

import java.util.Date;
import java.util.List;

public class UserBean {
    private int id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    private List<OrdersBean> ordersBeans;

    public List<OrdersBean> getOrdersBeans() {
        return ordersBeans;
    }

    public void setOrdersBeans(List<OrdersBean> ordersBeans) {
        this.ordersBeans = ordersBeans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
