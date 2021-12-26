package service.web;

import VO.web.UserLoginVO;
//用户管理接口
public interface IUserMangerService {
    UserLoginVO login(String username, String password);
    boolean updatePassword(Integer userId, String newPassword);

    boolean register(String username, String password, String name, String sex, String email, String phone, String birthday, String picture, String address);
}
