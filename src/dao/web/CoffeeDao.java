package dao.web;

import VO.web.CoffeeDetailVO;
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
            String sql="select id,picture,name,coffeetypeid,price,num,netweight,qualitydate,tasteid,brand,storage,detail from coffee";
            preparedStatement=conn.prepareStatement(sql);
            ResultSet set= preparedStatement.executeQuery();
            while(set.next()){
                CoffeeVO vo=new CoffeeVO(
                set.getInt("Id"), set.getString("picture"),
                set.getString("name"),set.getInt("coffeetypeid"),
                set.getDouble("price"), set.getInt("num"),
                set.getString("netweight"),set.getString("qualitydate"),
                set.getInt("tasteid"),set.getString("brand"),
                set.getString("storage"),set.getString("detail"));
                coffeeList.add(vo);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return coffeeList;
    }

    @Override
    public List<CoffeeVO> selectCoffeeListByType(int type) {
        List<CoffeeVO> coffeeList = new ArrayList<CoffeeVO>();
        Connection connection = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        try {
            String sql="select id,picture,name,coffeetypeid,price,num,netweight,qualitydate,tasteid,brand,storage,detail"
                    +" from coffee where coffeetypeid=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, type);
            ResultSet set = ps.executeQuery();
            while(set.next()) {
                CoffeeVO vo = new CoffeeVO(set.getInt("id"),set.getString("picture") ,set.getString("name") ,
                        set.getInt("coffeetypeid") , set.getDouble("price"),set.getInt("num") ,
                        set.getString("netweight") ,set.getString("qualitydate") ,
                        set.getInt("tasteid"),set.getString("brand") ,set.getString("storage") ,
                        set.getString("detail"));
                coffeeList.add(vo);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return coffeeList;
    }

    @Override
    public CoffeeDetailVO selectCoffeeDetailById(int int_id) {
        CoffeeDetailVO coffeeDetailVO = null;
        Connection connection = DataSourceUtil.getConnection();
        PreparedStatement ps = null;
        try {
            String sql="select c.id,picture,c.name,coffeetypeid,price,num,netweight,qualitydate,"
                    + "tasteid,brand,storage,detail,t.name tasteName "
                    +" from coffee c,taste t where c.id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, int_id);
            ResultSet set = ps.executeQuery();
            while(set.next()) {
                coffeeDetailVO = new CoffeeDetailVO(set.getInt("id"),set.getString("picture") ,set.getString("name") ,
                        set.getInt("coffeetypeid") , set.getDouble("price"),set.getInt("num") ,
                        set.getString("netweight") ,set.getString("qualitydate") ,
                        set.getInt("tasteid"),set.getString("brand") ,set.getString("storage") ,
                        set.getString("detail"),set.getString("tasteName"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return coffeeDetailVO;
    }
}
