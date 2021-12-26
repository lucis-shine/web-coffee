package dao.web;

import POJO.UserPOJO;
import VO.web.UserLoginVO;

public interface IUserDao {
    //按照用户名和密码查询用户信息
    UserLoginVO selectUserInfoByUserNameAndPassword(String username, String password);
    //修改密码
    boolean updatePassword(Integer userId, String newPassword);
    //会员注册
    boolean insert(UserPOJO userPOJO);
    //是否有相同用户名
    boolean selectExistSameUsername(String username);
}
