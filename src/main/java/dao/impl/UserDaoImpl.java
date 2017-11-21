package dao.impl;

import dao.UserDao;
import entity.UserBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements UserDao {
    //需要向dao实现类中注入SqlSessionFactory
    //这里通过构造方法注入
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    public UserBean findUserById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserBean user = sqlSession.selectOne("test.findUserById", id);
        sqlSession.close();
        return user;
    }

    public void insertUser(UserBean user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteUser(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUser", id);
        sqlSession.commit();
        sqlSession.close();
    }
}
