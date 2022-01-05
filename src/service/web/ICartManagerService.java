package service.web;

import VO.web.CartItemVO;

import java.util.List;

public interface ICartManagerService {

     //商品详情页添加或者更新购物车
	boolean addOrUpdateCart(String coffeeid, String num, int userid);

     //获得会员的购物车列表
	List<CartItemVO> getCartListByUserid(int userid);

	//购物车页根据购物车id修改数量
	boolean updateCartItemNumById(String cartId, String cartNum);

	//删除购物项
	boolean removeCartItem(String cartId);

	// 提交订单
	boolean submitCart(int userid, String strAddressId,double payMoney);

}
