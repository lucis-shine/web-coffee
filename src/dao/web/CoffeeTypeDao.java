package dao.web;

import VO.web.CoffeeTypeVO;
import utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CoffeeTypeDao implements ICoffeeTypeDao{
    @Override
    public List<CoffeeTypeVO> selectCoffeeTypeList() {
        List<CoffeeTypeVO> coffeeTypeList=new ArrayList<>();
        Connection conn= DataSourceUtil.getConnection();
        PreparedStatement preparedStatement=null;
        try{
          String sql="select id ,name from coffeetype";
          preparedStatement=conn.prepareStatement(sql);
          ResultSet set= preparedStatement.executeQuery();
         while(set.next()){
             CoffeeTypeVO vo=new CoffeeTypeVO(set.getInt("Id"), set.getString("name"));
             coffeeTypeList.add(vo);
         }
        } catch (Exception e){
            e.printStackTrace();
        }
        return coffeeTypeList;
    }
}
