package com.huixin.haidong.controller.web.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huixin.framework.base.ResponseResult;
import com.huixin.framework.base.RestResultGenerator;
import com.huixin.framework.enums.ContentType;
import com.huixin.framework.utils.PageData;
import com.huixin.haidong.controller.base.BaseController;
import com.huixin.haidong.service.project.ProjectService;



@Controller
@RequestMapping(value = "/webProjectInterface")
public class WebProjectInterfaceController extends BaseController {
	@Autowired
	private ProjectService projectService;
	/**
	 * 根据类型获取图片
	 * 
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/getProjectBySeriesId", method = RequestMethod.GET, produces = ContentType.APPLICATION_JSON_UTF8)
	@ResponseBody
	public  ResponseResult<List<PageData>> getProjectBySeriesId() {
		logBefore(logger, "API根据系列id获取项目");
		PageData pd = this.getPageData();
		try {
			List<PageData> projectList = projectService.getProjectsBySeriesId(pd);
			if(projectList == null || projectList.size() == 0){
				return RestResultGenerator.genErrorResult("获取项目失败");
			}
			return RestResultGenerator.genResult(projectList,"获取项目成功");
		} catch (Exception e) {
			logger.error("获取项目失败", e);
			return RestResultGenerator.genErrorResult("获取项目失败");
		}
	}
	/**
	 * 获取所有项目
	 * 
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/getAllProject", method = RequestMethod.GET, produces = ContentType.APPLICATION_JSON_UTF8)
	@ResponseBody
	public  ResponseResult<List<PageData>> getAllProject() {
		logBefore(logger, "API获取所有项目");
		PageData pd = this.getPageData();
		try {
			List<PageData> projectList = projectService.listAll(pd);
			if(projectList == null || projectList.size() == 0){
				return RestResultGenerator.genErrorResult("获取项目失败");
			}
			return RestResultGenerator.genResult(projectList,"获取所有项目成功");
		} catch (Exception e) {
			logger.error("获取所有项目失败", e);
			return RestResultGenerator.genErrorResult("获取所有项目失败");
		}
	}

}
