package com.huixin.haidong.service.impl.project;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huixin.framework.utils.PageData;
import com.huixin.framework.utils.UuidUtil;
import com.huixin.haidong.service.project.ProjectDao;
import com.huixin.haidong.service.project.ProjectService;
import com.huixin.system.entity.Page;


@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;
	public List<PageData> list(Page page) throws Exception {
		// TODO Auto-generated method stub
		return projectDao.list(page);
	}
	public PageData findById(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return  projectDao.findById(pd);
	}
	public void save(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		pd.put("id", UuidUtil.get32UUID());
		projectDao.save(pd);
	}
	public void edit(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		projectDao.edit(pd);
	}
	public void delete(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		projectDao.delete(pd);
	}
	public void deleteTp(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		projectDao.delTp(pd);
	}
	public List<PageData> getProjectsBySeriesId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return projectDao.getProjectsBySeriesId(pd);
	}
	public List<PageData> listAll(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		return projectDao.listAll(pd);
	}
}