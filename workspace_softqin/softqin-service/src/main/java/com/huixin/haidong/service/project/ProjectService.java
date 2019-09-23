package com.huixin.haidong.service.project;

import java.util.List;
import com.huixin.framework.utils.PageData;
import com.huixin.system.entity.Page;


public interface ProjectService {

	List<PageData> list(Page page) throws Exception;

	PageData findById(PageData pd) throws Exception;

	void save(PageData pd) throws Exception;

	void edit(PageData pd) throws Exception;

	void delete(PageData pd)throws Exception;
	
	void deleteTp(PageData pd) throws Exception;

	List<PageData> getProjectsBySeriesId(PageData pd) throws Exception;

	List<PageData> listAll(PageData pd)throws Exception;
}
