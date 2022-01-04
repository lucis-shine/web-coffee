package dao.web;

import POJO.CollectsPOJO;
import VO.web.CollectsVO;

import java.util.List;

public interface ICollectsDao {

	boolean insert(CollectsPOJO collectsPOJO);

	boolean isCollectsCoffee(CollectsPOJO collectsPOJO);

	boolean deleteCollects(CollectsPOJO collectsPOJO);

	List<CollectsVO> selectCollectsList(int userid);

	boolean deleteCollectsBycollectsId(int collectsId);

}
