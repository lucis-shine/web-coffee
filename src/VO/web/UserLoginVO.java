package VO.web;

import POJO.UserPOJO;

public class UserLoginVO  extends UserPOJO {
    public UserLoginVO() {}

    public UserLoginVO(Integer id, String username, String password, String name, String sex, String email, String phone, String birthday, String picture, String address) {
        super(id, username, password, name, sex, email, phone, birthday, picture, address);
    }

    public UserLoginVO(String username, String password, String name, String sex, String email, String phone, String birthday, String picture, String address) {
        super(username, password, name, sex, email, phone, birthday, picture, address);
    }

    public UserLoginVO(Integer id, String username, String password, String name, String sex, String email, String phone, String birthday, String picture, String address, double money) {
        super(id, username, password, name, sex, email, phone, birthday, picture, address, money);
    }
    public UserLoginVO( String username, String password, String name, String sex, String email, String phone, String birthday, String picture, String address, double money) {
        super(username, password, name, sex, email, phone, birthday, picture, address, money);
    }
}
