package com.huixin.haidong.service.customer;

import java.util.List;
import com.huixin.framework.utils.PageData;
import com.huixin.system.entity.Page;


public interface CustomerService {

	List<PageData> list(Page page) throws Exception;

	PageData findById(PageData pd) throws Exception;

	void save(PageData pd) throws Exception;

	void edit(PageData pd) throws Exception;

	void delete(PageData pd)throws Exception;
}
