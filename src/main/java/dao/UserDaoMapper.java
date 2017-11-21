package dao;

import entity.UserBean;
import entity.UserCustom;
import entity.UserQuerVo;

public interface UserDaoMapper {
    //根据id查询
    public UserBean findUserById(int id) throws Exception;

    //插入用户
    public void insertUser(UserBean user) throws Exception;

    //删除用户
    public void deleteUser(int id) throws Exception;

    //修改用户信息
    public void updateUser(UserBean user) throws Exception;

    //输入映射 pojo包装类型
    public UserCustom findUserByinfo(UserQuerVo userQuerVo) throws Exception;

    //输出映射 pojo resultType
    public int findUserCount(UserQuerVo userQuerVo) throws Exception;

    //输出映射 pojo resultMap
    public UserBean findUserByResultMap(int id) throws Exception;

    //
    public UserCustom findUserList(UserQuerVo userQuerVo) throws Exception;
}
