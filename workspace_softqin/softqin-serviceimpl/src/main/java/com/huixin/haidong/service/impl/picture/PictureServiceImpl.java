package com.huixin.haidong.service.impl.picture;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huixin.framework.utils.PageData;
import com.huixin.framework.utils.UuidUtil;
import com.huixin.haidong.service.picture.PictureDao;
import com.huixin.haidong.service.picture.PictureService;
import com.huixin.system.entity.Page;


@Service("pictureService")
public class PictureServiceImpl implements PictureService {

	@Autowired
	private PictureDao pictureDao;
	public List<PageData> list(Page page) throws Exception {
		// TODO Auto-generated method stub
		return pictureDao.list(page);
	}
	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  pictureDao.findById(pd);
	}
	public void save(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		pd.put("id", UuidUtil.get32UUID());
		pictureDao.save(pd);
	}
	public void edit(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		pictureDao.edit(pd);
	}
	public void delete(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		pictureDao.delete(pd);
	}
	public void deleteTp(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		pictureDao.delTp(pd);
	}
	public List<PageData> getPictureByType(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return pictureDao.getPictureByType(pd);
	}
	public List<PageData> getPictureByTypeId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return pictureDao.getPictureByTypeId(pd);
	}
}