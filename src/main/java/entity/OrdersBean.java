package entity;

import java.util.Date;
import java.util.List;

public class OrdersBean {
    private int id;
    private int user_id;
    private String number;
    private Date createtime;
    private String note;
    //用户信息
    private UserBean userBean;

    //订单信息
    private List<OrderdetailBean> orderdetailBeans;

    public List<OrderdetailBean> getOrderdetailBeans() {
        return orderdetailBeans;
    }

    public void setOrderdetailBeans(List<OrderdetailBean> orderdetailBeans) {
        this.orderdetailBeans = orderdetailBeans;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
