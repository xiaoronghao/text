package com.huixin.haidong.service.impl.news;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huixin.framework.utils.PageData;
import com.huixin.framework.utils.UuidUtil;
import com.huixin.haidong.service.news.NewsDao;
import com.huixin.haidong.service.news.NewsService;
import com.huixin.system.entity.Page;


@Service("newsService")
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;
	public List<PageData> list(Page page) throws Exception {
		// TODO Auto-generated method stub
		return newsDao.list(page);
	}
	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  newsDao.findById(pd);
	}
	public void save(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		pd.put("id", UuidUtil.get32UUID());
		newsDao.save(pd);
	}
	public void edit(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		newsDao.edit(pd);
	}
	public void delete(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		newsDao.delete(pd);
	}
	public void deleteTp(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		newsDao.delTp(pd);
	}
	public List<PageData> getAll(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return newsDao.getAll(pd);
	}
}