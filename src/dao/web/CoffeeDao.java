package dao.web;

import VO.web.CoffeeTypeVO;
import VO.web.CoffeeVO;
import utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CoffeeDao implements ICoffeeDao{
    @Override
    public List<CoffeeVO> selectCoffeeList() {
        List<CoffeeVO> coffeeList=new ArrayList<>();
        Connection conn= DataSourceUtil.getConnection();
        PreparedStatement preparedStatement=null;
        try{
            String sql="select Id ,name,from coffee";
            preparedStatement=conn.prepareStatement(sql);
            ResultSet set= preparedStatement.executeQuery();
            while(set.next()){
                /*CoffeeVO vo=new CoffeeVO(set.getInt("Id"), set.getString("name"));
                coffeeList.add(vo);*/
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return coffeeList;
    }
}
