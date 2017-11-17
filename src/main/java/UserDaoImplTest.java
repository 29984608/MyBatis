import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class UserDaoImplTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    //测试前执行
    public void setUp() throws IOException {
        //配置文件
        String resource = "SqlMapConfig.xml";
        //的到配置文件流
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //创建会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testFinUserById() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(12);
        System.out.println(user);
    }
    @Test
    public void insertUser() throws Exception{
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user1 = new User();
        user1.setUsername("王麻子");
        user1.setBirthday(new Date());
        user1.setSex("女");
        user1.setAddress("日本东京");
        userDao.insertUser(user1);
    }
    @Test
    public void deleteUser() throws Exception{
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        userDao.deleteUser(13);
    }
}
