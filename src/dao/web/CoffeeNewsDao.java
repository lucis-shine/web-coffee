package dao.web;

import VO.web.CoffeeNewsVO;
import VO.web.CoffeeTypeVO;
import utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CoffeeNewsDao implements ICoffeeNewsDao{
    @Override
    public List<CoffeeNewsVO> selectcoffeeNewsList() {
        List<CoffeeNewsVO> coffeeNewsList=new ArrayList<>();
        Connection conn= DataSourceUtil.getConnection();
        PreparedStatement preparedStatement=null;
        try{
            String sql="select id,picture,title,content,data_format(addtime,'%Y-%m-%d') addtime,isDelete from coffeenews";
            preparedStatement=conn.prepareStatement(sql);
            ResultSet set= preparedStatement.executeQuery();
            while(set.next()){
                CoffeeNewsVO vo=new CoffeeNewsVO(set.getInt("id"), set.getString("picture"),
                        set.getString("title"),set.getString("content"),
                        set.getString("addtime"),set.getString("isDelete"));
                coffeeNewsList.add(vo);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return coffeeNewsList;
    }
}
