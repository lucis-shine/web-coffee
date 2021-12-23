package dao.web;

import VO.web.UserLoginVO;

public interface IUserDao {
    //按照用户名和密码查询用户信息
    UserLoginVO selectUserInfoByUserNameAndPassword(String username, String password);
    //修改密码
    boolean updatePassword(Integer userId, String newPassword);
}
