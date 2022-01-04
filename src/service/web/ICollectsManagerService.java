package service.web;

import VO.web.CollectsVO;

import java.util.List;

public interface ICollectsManagerService {
    // 添加收藏
	boolean addCollects(String coffeeid, int userid);
	//用户是否收藏该咖啡
	boolean isCollectsCoffee(String coffeeid, Integer userid);
    //移除收藏
	boolean removeCollects(String coffeeid, int userid);
	//根据会员id查找收藏的商品
	List<CollectsVO> getCollectsList(int userid);
    //按照收藏id删除收藏信息
	boolean removeBycollectsId(String collectsId);
}
