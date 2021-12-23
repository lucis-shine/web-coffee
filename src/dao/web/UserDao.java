package dao.web;

import VO.web.UserLoginVO;

public class UserDao implements IUserDao{

    @Override
    public UserLoginVO selectUserInfoByUserNameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public boolean updatePassword(Integer userId, String newPassword) {
        return false;
    }
}
