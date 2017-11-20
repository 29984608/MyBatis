import dao.UserDaoMapper;
import entity.User;
import entity.UserCustom;
import entity.UserQuerVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class UserDaoMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserDaoMapper userDaoMapper = sqlSession.getMapper(UserDaoMapper.class);
        //调用usermapper对象
        User user = userDaoMapper.findUserById(10);
        System.out.println(user);
    }

    @Test
    public void insertUserd() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，mybatis自动生成mapper代理对象
        UserDaoMapper userDaoMapper = sqlSession.getMapper(UserDaoMapper.class);
        //调用usermapper对象
        User user = new User();
        user.setUsername("短毛");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("德国柏林");
        userDaoMapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDaoMapper userDaoMapper = sqlSession.getMapper(UserDaoMapper.class);
        userDaoMapper.deleteUser(13);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDaoMapper userDaoMapper = sqlSession.getMapper(UserDaoMapper.class);
        User user = new User();
        user.setId(12);
        user.setUsername("短毛");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("德国柏林");
        userDaoMapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findUserByinfo() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDaoMapper userDaoMapper = sqlSession.getMapper(UserDaoMapper.class);
        UserQuerVo userQuerVo = new UserQuerVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("马云");
        userCustom.setSex("男");
        userQuerVo.setUserCustom(userCustom);

        UserCustom userCustom1= userDaoMapper.findUserByinfo(userQuerVo);
        System.out.println(userCustom1);
    }
    @Test
    public void findUserCount() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDaoMapper userDaoMapper = sqlSession.getMapper(UserDaoMapper.class);
        UserQuerVo userQuerVo = new UserQuerVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("马");
        userQuerVo.setUserCustom(userCustom);
        int num= userDaoMapper.findUserCount(userQuerVo);
        System.out.println(num);
    }

}
