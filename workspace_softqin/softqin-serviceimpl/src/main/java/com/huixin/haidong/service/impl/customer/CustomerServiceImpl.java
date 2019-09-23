package com.huixin.haidong.service.impl.customer;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huixin.framework.utils.PageData;
import com.huixin.framework.utils.UuidUtil;
import com.huixin.haidong.service.customer.CustomerDao;
import com.huixin.haidong.service.customer.CustomerService;
import com.huixin.system.entity.Page;


@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	public List<PageData> list(Page page) throws Exception {
		// TODO Auto-generated method stub
		return customerDao.list(page);
	}
	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  customerDao.findById(pd);
	}
	public void save(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		pd.put("id", UuidUtil.get32UUID());
		customerDao.save(pd);
	}
	public void edit(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		customerDao.edit(pd);
	}
	public void delete(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		customerDao.delete(pd);
	}
}