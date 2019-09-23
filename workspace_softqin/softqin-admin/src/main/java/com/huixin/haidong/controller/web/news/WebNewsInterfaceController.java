package com.huixin.haidong.controller.web.news;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huixin.framework.base.ResponseResult;
import com.huixin.framework.base.RestResultGenerator;
import com.huixin.framework.enums.ContentType;
import com.huixin.framework.utils.PageData;
import com.huixin.haidong.controller.base.BaseController;
import com.huixin.haidong.service.news.NewsService;



@Controller
@RequestMapping(value = "/webNewsInterface")
public class WebNewsInterfaceController extends BaseController {
	@Autowired
	private NewsService newsService;
	/**
	 * 获取所有新闻
	 * 
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/getAllNews", method = RequestMethod.GET, produces = ContentType.APPLICATION_JSON_UTF8)
	@ResponseBody
	public  ResponseResult<List<PageData>> getAllNews() {
		logBefore(logger, "API获取所有新闻");
		PageData pd = this.getPageData();
		try {
			List<PageData> newsList = newsService.getAll(pd);
			if(newsList == null || newsList.size() == 0){
				return RestResultGenerator.genErrorResult("获取新闻失败");
			}
			return RestResultGenerator.genResult(newsList,"获取新闻成功");
		} catch (Exception e) {
			logger.error("获取所有新闻失败", e);
			return RestResultGenerator.genErrorResult("获取新闻失败");
		}
	}

	/**
	 * 根据id获取新闻
	 * 
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/getNewsById", method = RequestMethod.GET, produces = ContentType.APPLICATION_JSON_UTF8)
	@ResponseBody
	public  ResponseResult<PageData> getNewsById() {
		logBefore(logger, "API根据id获取新闻");
		PageData pd = this.getPageData();
		String newsId = pd.getString("newsId");
		pd.put("id", newsId);
		try {
			PageData news = newsService.findById(pd);
			if(news == null){
				return RestResultGenerator.genErrorResult("获取新闻失败");
			}
			return RestResultGenerator.genResult(news,"获取新闻成功");
		} catch (Exception e) {
			logger.error("获取新闻失败", e);
			return RestResultGenerator.genErrorResult("获取新闻失败");
		}
	}
}
