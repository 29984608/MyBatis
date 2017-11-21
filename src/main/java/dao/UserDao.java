package dao;

import entity.UserBean;

public interface UserDao {
    //根据id查询信息
    public UserBean findUserById(int id) throws Exception;

    //添加用户信息
    public void insertUser(UserBean user) throws Exception;

    //删除用户信息
    public void deleteUser(int id) throws Exception;
}
