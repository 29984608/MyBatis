
import entity.UserBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class mybatisTest {
    @Test
    public void findUserById() throws IOException {
        //配置文件
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //通过SqlSession操作数据库
        //第一个参数：等于 = namespace+“.”+statement的id
        //第二个参数：指定映射文件中所匹配的parameterType类型的参数
        UserBean user = sqlSession.selectOne("test.findUserById", 1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void findUserByName() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<UserBean> list = sqlSession.selectList("test.findUserByName", "马");
        System.out.println(list + "\n");
    }

    @Test
    public void insertUser() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserBean user = new UserBean();
        user.setUsername("张三");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("美国纽约");
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        System.out.println(user.getId());
        System.out.println(new Date());
        sqlSession.close();
    }

    @Test
    public void deleteUser() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUser", 12);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserBean user = new UserBean();
        user.setId(12);
        user.setUsername("李四");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("英国伦敦");
        sqlSession.update("test.updateUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

}
