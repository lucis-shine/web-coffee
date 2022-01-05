package service.web;

import POJO.CartPOJO;
import VO.web.CartItemVO;
import VO.web.CartVO;
import dao.web.CartDao;
import dao.web.ICartDao;

import java.util.List;

public class CartManagerService implements ICartManagerService{
    ICartDao cartDAO = new CartDao();
	@Override
	public boolean addOrUpdateCart(String coffeeid, String num, int userid) {
		//查看该商品是否被加入购物车
		int cid = Integer.parseInt(coffeeid);
		int int_num = Integer.parseInt(num);
		CartVO cartVO = cartDAO.selectCartByCidAndUid(cid,userid);
		if(cartVO==null) {//不存在   插入
			CartPOJO cartPOJO = new CartPOJO(cid, userid, int_num);
			return cartDAO.insert(cartPOJO);
		}else {//存在   更新
			return cartDAO.updateNum(cartVO.getId(),int_num);
		}
	}

	@Override
	public List<CartItemVO> getCartListByUserid(int userid) {
		return cartDAO.selectCartItemListByUserid(userid);
	}

	@Override
	public boolean updateCartItemNumById(String cartId, String cartNum) {
		int id = Integer.parseInt(cartId);
		int num = Integer.parseInt(cartNum);
		return cartDAO.updateCartItemNumById(id,num);
	}

	@Override
	public boolean removeCartItem(String cartId) {
		int id = Integer.parseInt(cartId);
		return cartDAO.deleteById(id);
	}

	@Override
	public boolean submitCart(int userid, String strAddressId,double payMoney) {
		int addressId = Integer.parseInt(strAddressId);
		return cartDAO.submitCart(userid,addressId,payMoney);
	}
}
