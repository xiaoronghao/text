package com.huixin.haidong.service.series;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huixin.framework.utils.PageData;
import com.huixin.system.dao.DaoSupport;
import com.huixin.system.entity.Page;

@Service("seriesDao")
public class SeriesDao {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	
	/*
	 * 查询系列列表
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page) throws Exception {
		return (List<PageData>) dao.findForList("SeriesMapper.listPage", page);
	}

	/*
	 * 查询所有系列
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("SeriesMapper.listAll", pd);
	}

	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.findForObject("SeriesMapper.findById", pd);
	}


	public void save(PageData pd) throws Exception{
		// TODO Auto-generated method stub
		dao.save("SeriesMapper.save", pd);
	}


	public void edit(PageData pd) throws Exception{
		// TODO Auto-generated method stub
		dao.update("SeriesMapper.edit", pd);
	}


	public void delete(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("SeriesMapper.delete", pd);
	}
	/*
	* 删除图片
	*/
	public void delTp(PageData pd)throws Exception{
		dao.update("SeriesMapper.delTp", pd);
	}
	
	
}
