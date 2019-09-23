package com.huixin.haidong.service.project;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huixin.framework.utils.PageData;
import com.huixin.system.dao.DaoSupport;
import com.huixin.system.entity.Page;

@Service("projectDao")
public class ProjectDao {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	
	/*
	 * 查询系列列表
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page) throws Exception {
		return (List<PageData>) dao.findForList("ProjectMapper.listPage", page);
	}


	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.findForObject("ProjectMapper.findById", pd);
	}


	public void save(PageData pd) throws Exception{
		// TODO Auto-generated method stub
		dao.save("ProjectMapper.save", pd);
	}


	public void edit(PageData pd) throws Exception{
		// TODO Auto-generated method stub
		dao.update("ProjectMapper.edit", pd);
	}


	public void delete(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("ProjectMapper.delete", pd);
	}
	/*
	* 删除图片
	*/
	public void delTp(PageData pd)throws Exception{
		dao.update("ProjectMapper.delTp", pd);
	}


	public List<PageData> getProjectsBySeriesId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("ProjectMapper.findBySeriesId", pd);
	}


	public List<PageData> listAll(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("ProjectMapper.listAll", pd);
	}
	
	
}
