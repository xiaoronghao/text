package com.huixin.haidong.service.news;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huixin.framework.utils.PageData;
import com.huixin.system.dao.DaoSupport;
import com.huixin.system.entity.Page;

@Service("newsDao")
public class NewsDao {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	
	/*
	 * 查询系列列表
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page) throws Exception {
		return (List<PageData>) dao.findForList("NewsMapper.listPage", page);
	}


	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.findForObject("NewsMapper.findById", pd);
	}


	public void save(PageData pd) throws Exception{
		// TODO Auto-generated method stub
		dao.save("NewsMapper.save", pd);
	}


	public void edit(PageData pd) throws Exception{
		// TODO Auto-generated method stub
		dao.update("NewsMapper.edit", pd);
	}


	public void delete(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("NewsMapper.delete", pd);
	}
	/*
	* 删除图片
	*/
	public void delTp(PageData pd)throws Exception{
		dao.update("NewsMapper.delTp", pd);
	}


	public List<PageData> getAll(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("NewsMapper.listAll", pd);
	}
	
	
}
