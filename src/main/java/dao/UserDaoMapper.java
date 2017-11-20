package dao;

import entity.User;
import entity.UserCustom;
import entity.UserQuerVo;

public interface UserDaoMapper {
    //根据id查询
    public User findUserById(int id) throws Exception;

    //插入用户
    public void insertUser(User user) throws Exception;

    //删除用户
    public void deleteUser(int id) throws Exception;

    //修改用户信息
    public void updateUser(User user) throws Exception;

    //输入映射 pojo包装类型
    public UserCustom findUserByinfo(UserQuerVo userQuerVo) throws Exception;

    //
    public int findUserCount(UserQuerVo userQuerVo) throws Exception;
}
