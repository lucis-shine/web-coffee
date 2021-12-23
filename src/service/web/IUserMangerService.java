package service.web;

import VO.web.UserLoginVO;
//用户管理接口
public interface IUserMangerService {
    UserLoginVO login(String username, String password);
    boolean updatePassword(Integer userId, String newPassword);
}
