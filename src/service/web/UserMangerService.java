package service.web;

import POJO.UserPOJO;
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

    @Override
    public boolean register(String username, String password, String name, String sex, String email, String phone, String birthday, String picture, String address) {
        UserPOJO userPOJO=new UserPOJO(username,password,name,sex,email,phone,birthday,picture,address);
        return userDao.insert(userPOJO);
    }
}
