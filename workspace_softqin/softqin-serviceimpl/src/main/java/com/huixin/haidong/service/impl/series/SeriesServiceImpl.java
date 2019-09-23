package com.huixin.haidong.service.impl.series;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huixin.framework.utils.PageData;
import com.huixin.framework.utils.UuidUtil;
import com.huixin.haidong.service.series.SeriesDao;
import com.huixin.haidong.service.series.SeriesService;
import com.huixin.system.entity.Page;


@Service("seriesService")
public class SeriesServiceImpl implements SeriesService {

	@Autowired
	private SeriesDao seriesDao;
	public List<PageData> list(Page page) throws Exception {
		// TODO Auto-generated method stub
		return seriesDao.list(page);
	}
	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  seriesDao.findById(pd);
	}
	public void save(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		pd.put("id", UuidUtil.get32UUID());
		seriesDao.save(pd);
	}
	public void edit(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		seriesDao.edit(pd);
	}
	public void delete(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		seriesDao.delete(pd);
	}
	public void deleteTp(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		seriesDao.delTp(pd);
	}
	public List<PageData> listAll(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return seriesDao.listAll(pd);
	}
}