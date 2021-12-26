package service.web;

import VO.web.UserLoginVO;
//用户管理接口
public interface IUserMangerService {
    //登录
    UserLoginVO login(String username, String password);
    boolean updatePassword(Integer userId, String newPassword);
    //注册
    boolean register(String username, String password, String name, String sex, String email, String phone, String birthday, String picture, String address);
    //检查用户名是否相同
    boolean isExistSameUsername(String username);
}
