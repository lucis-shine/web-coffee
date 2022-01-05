package dao.web;

import POJO.CartPOJO;
import VO.web.CartItemVO;
import VO.web.CartVO;

import java.util.List;

public interface ICartDao {

    //查看该商品是否被该会员加入购物车
	CartVO selectCartByCidAndUid(int cid, int userid);

	//根据购物车id修改数量
	boolean updateNum(Integer id, int num);

    //插入数据
	boolean insert(CartPOJO cartPOJO);

	// 获得用户购物列表
	List<CartItemVO> selectCartItemListByUserid(int userid);

	 //根据购物车id修改数量
	boolean updateCartItemNumById(int id, int num);

	 //按照id删除商品
	boolean deleteById(int id);

     // 提交购物车
	boolean submitCart(int userid,int addressId,double payMoney);

}
