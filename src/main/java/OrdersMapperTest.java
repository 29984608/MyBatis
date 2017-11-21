import dao.OrdersMapperCustom;
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
}
