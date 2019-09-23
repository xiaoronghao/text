package com.huixin.haidong.service.customer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huixin.framework.utils.PageData;
import com.huixin.system.dao.DaoSupport;
import com.huixin.system.entity.Page;

@Service("customerDao")
public class CustomerDao {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	
	/*
	 * 查询客户列表
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page) throws Exception {
		return (List<PageData>) dao.findForList("CustomerMapper.listPage", page);
	}


	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return (PageData)dao.findForObject("CustomerMapper.findById", pd);
	}


	public void save(PageData pd) throws Exception{
		// TODO Auto-generated method stub
		dao.save("CustomerMapper.save", pd);
	}


	public void edit(PageData pd) throws Exception{
		// TODO Auto-generated method stub
		dao.update("CustomerMapper.edit", pd);
	}


	public void delete(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		dao.update("CustomerMapper.delete", pd);
	}
	
}
