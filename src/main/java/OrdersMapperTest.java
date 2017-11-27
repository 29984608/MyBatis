import dao.OrdersMapperCustom;
import entity.OrdersBean;
import entity.UserBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrdersMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void findOrdersUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
         OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
         List<OrdersMapperCustom> ordersCustom = ordersMapperCustom.findOrdersUser();
        System.out.println(ordersCustom);
    }
    @Test
    public void findOrdersUserResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
        List<OrdersBean> ordersBeans = ordersMapperCustom.findOrdersUserResultMap();
        System.out.println(ordersBeans);
    }
    @Test
    public void findOrdersAndOrderdetailResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
        List<OrdersBean> ordersBeans = ordersMapperCustom.findOrdersAndOrderdetailResultMap();
        System.out.println(ordersBeans);
    }
    @Test
    public void findUserAndItemsResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
        List<UserBean> userBeans  = ordersMapperCustom.findUserAndItemsResultMap();
        System.out.println(userBeans);
    }

}
