package dao;

import entity.OrdersBean;
import entity.UserBean;

import java.util.List;

public interface OrdersMapperCustom {
    //查询订单关联查询用户信息
    public List<OrdersMapperCustom> findOrdersUser() throws Exception;

    //查询订单关联查询用户,使用resultMap
    public List<OrdersBean> findOrdersUserResultMap() throws Exception;

    //查询订单关联用户及订单明细，使用resultMap
    public List<OrdersBean> findOrdersAndOrderdetailResultMap() throws Exception;

    //查询用户及用户购买商品信息
    public List<UserBean> findUserAndItemsResultMap() throws Exception;
}
