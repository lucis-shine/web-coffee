package service.web;

import VO.web.UserLoginVO;
import dao.web.IUserDao;
import dao.web.UserDao;

public class UserMangerService implements IUserMangerService {
    IUserDao userDao=new UserDao();
    @Override
    public UserLoginVO login(String username, String password) {
        return userDao.selectUserInfoByUserNameAndPassword(username,password);
    }

    @Override
    public boolean updatePassword(Integer userId, String newPassword) {
        return userDao.updatePassword(userId,newPassword);
    }
}
