package com.huixin.haidong.service.news;

import java.util.List;
import com.huixin.framework.utils.PageData;
import com.huixin.system.entity.Page;


public interface NewsService {

	List<PageData> list(Page page) throws Exception;
	
	List<PageData> getAll(PageData pd) throws Exception;

	PageData findById(PageData pd) throws Exception;

	void save(PageData pd) throws Exception;

	void edit(PageData pd) throws Exception;

	void delete(PageData pd)throws Exception;
	
	void deleteTp(PageData pd) throws Exception;
}
