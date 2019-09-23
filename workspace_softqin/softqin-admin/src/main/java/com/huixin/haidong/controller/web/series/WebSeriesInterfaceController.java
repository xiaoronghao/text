package com.huixin.haidong.controller.web.series;


import java.util.ArrayList;
import java.util.HashMap;
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
import com.huixin.haidong.service.series.SeriesService;



@Controller
@RequestMapping(value = "/webSeriesInterface")
public class WebSeriesInterfaceController extends BaseController {
	@Autowired
	private SeriesService seriesService;
	/**
	 * 获取所有系列
	 * 
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/getAllSeries", method = RequestMethod.GET, produces = ContentType.APPLICATION_JSON_UTF8)
	@ResponseBody
	public  ResponseResult<List<PageData>> getAllSeries() {
		logBefore(logger, "API获取所有系列");
		PageData pd = this.getPageData();
		try {
			List<PageData> seriesList = seriesService.listAll(pd);
			if(seriesList == null || seriesList.size() == 0){
				return RestResultGenerator.genErrorResult("获取系列失败");
			}
			return RestResultGenerator.genResult(seriesList,"获取所有系列成功");
		} catch (Exception e) {
			logger.error("获取所有系列失败", e);
			return RestResultGenerator.genErrorResult("获取所有系列失败");
		}
	}
	/**
	 * 根据类型获取图片
	 * 
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/getSeriesById", method = RequestMethod.GET, produces = ContentType.APPLICATION_JSON_UTF8)
	@ResponseBody
	public  ResponseResult<List<PageData>> getSeriesById() {
		logBefore(logger, "API根据系列id获取系列");
		PageData pd = this.getPageData();
		try {
			   List<PageData> seriesList = new ArrayList<PageData>();
			   pd.put("id", pd.getString("seriesId"));
			    PageData series = seriesService.findById(pd);
			if(series == null){
				return RestResultGenerator.genErrorResult("获取系列失败");
			}else{
				seriesList.add(series);
			return RestResultGenerator.genResult(seriesList,"获取系列成功");
			}
		} catch (Exception e) {
			logger.error("获取项目失败", e);
			return RestResultGenerator.genErrorResult("获取项目失败");
		}
	}

}
