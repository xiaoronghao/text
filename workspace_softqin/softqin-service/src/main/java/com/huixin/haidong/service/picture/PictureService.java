package com.huixin.haidong.service.picture;

import java.util.List;
import com.huixin.framework.utils.PageData;
import com.huixin.system.entity.Page;


public interface PictureService {

	List<PageData> list(Page page) throws Exception;

	PageData findById(PageData pd) throws Exception;

	void save(PageData pd) throws Exception;

	void edit(PageData pd) throws Exception;

	void delete(PageData pd)throws Exception;
	
	void deleteTp(PageData pd) throws Exception;

	List<PageData> getPictureByType(PageData pd)throws Exception;

	List<PageData> getPictureByTypeId(PageData pd)throws Exception;
}
