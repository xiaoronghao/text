package com.huixin.haidong.service.picture;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huixin.framework.utils.PageData;
import com.huixin.system.dao.DaoSupport;
import com.huixin.system.entity.Page;

@Service("pictureDao")
public class PictureDao {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	
	/*
	 * 查询系列列表
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page) throws Exception {
		return (List<PageData>) dao.findForList("PictureMapper.listPage", page);
	}


	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.findForObject("PictureMapper.findById", pd);
	}


	public void save(PageData pd) throws Exception{
		// TODO Auto-generated method stub
		dao.save("PictureMapper.save", pd);
	}


	public void edit(PageData pd) throws Exception{
		// TODO Auto-generated method stub
		dao.update("PictureMapper.edit", pd);
	}


	public void delete(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("PictureMapper.delete", pd);
	}
	/*
	* 删除图片
	*/
	public void delTp(PageData pd)throws Exception{
		dao.update("PictureMapper.delTp", pd);
	}


	public List<PageData> getPictureByType(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (List<PageData>) dao.findForList("PictureMapper.findByType", pd);
	}


	public List<PageData> getPictureByTypeId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  (List<PageData>) dao.findForList("PictureMapper.findByTypeId", pd);
	}
	
	
}
