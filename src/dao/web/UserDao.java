package dao.web;

import POJO.UserPOJO;
import VO.web.UserLoginVO;
import utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao implements IUserDao{

    @Override
    public UserLoginVO selectUserInfoByUserNameAndPassword(String username, String password) {
        UserLoginVO userLoginVO=null;
        Connection conn= DataSourceUtil.getConnection();
        PreparedStatement preparedStatement=null;
        try{
            String sql="select id,username,password,name,sex,email,phone,birthday,picture,address from user " +
                    "where username=? and password=?";
            preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet set=preparedStatement.executeQuery();
            if (set.next()){
                userLoginVO=new UserLoginVO(set.getInt("id"),
                        set.getString("username"),   set.getString("password"),
                        set.getString("name"),   set.getString("sex"),
                        set.getString("email"),   set.getString("phone"),
                        set.getString("birthday"),   set.getString("picture"),
                        set.getString("address"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return userLoginVO;
    }

    @Override
    public boolean updatePassword(Integer userId, String newPassword) {
        return false;
    }

    @Override
    public boolean insert(UserPOJO userPOJO) {
        Connection conn= DataSourceUtil.getConnection();
        PreparedStatement preparedStatement=null;
        try{
            String sql="insert into user(username,password,name,sex,email,phone,birthday,picture,address)"+
                    "values(?,?,?,?,?,?,?,?,?)";
            preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,userPOJO.getUsername());
            preparedStatement.setString(2,userPOJO.getPassword());
            preparedStatement.setString(3,userPOJO.getName());
            preparedStatement.setString(4,userPOJO.getSex());
            preparedStatement.setString(5,userPOJO.getEmail());
            preparedStatement.setString(6,userPOJO.getPhone());
            preparedStatement.setString(7,userPOJO.getBirthday());
            preparedStatement.setString(8,userPOJO.getPicture());
            preparedStatement.setString(9,userPOJO.getAddress());
            int row=preparedStatement.executeUpdate();
            if (row>0){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
