package service.web;

import java.util.List;

import POJO.CollectsPOJO;

import VO.web.CollectsVO;
import dao.web.CollectsDao;
import dao.web.ICollectsDao;

public class CollectsManagerService implements ICollectsManagerService {
	ICollectsDao collectsDao = new CollectsDao();
	@Override
	public boolean addCollects(String coffeeid, int userid) {
		int cid  = Integer.parseInt(coffeeid);
		CollectsPOJO collectsPOJO = new CollectsPOJO(cid, userid);
		return collectsDao.insert(collectsPOJO);
	}
	@Override
	public boolean isCollectsCoffee(String coffeeid, Integer userid) {
		int cid = Integer.parseInt(coffeeid);
		CollectsPOJO collectsPOJO = new CollectsPOJO(cid, userid);
		return collectsDao.isCollectsCoffee(collectsPOJO);
	}
	@Override
	public boolean removeCollects(String coffeeid, int userid) {
		int cid  = Integer.parseInt(coffeeid);
		CollectsPOJO collectsPOJO = new CollectsPOJO(cid, userid);
		return collectsDao.deleteCollects(collectsPOJO);
	}
	@Override
	public List<CollectsVO> getCollectsList(int userid) {
		return collectsDao.selectCollectsList(userid);
	}
	@Override
	public boolean removeBycollectsId(String collectsId) {
		int coId = Integer.parseInt(collectsId);
		return collectsDao.deleteCollectsBycollectsId(coId);
	}

}
