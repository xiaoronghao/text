package com.huixin.haidong.controller.web.picture;


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
import com.huixin.haidong.service.picture.PictureService;



@Controller
@RequestMapping(value = "/webPictureInterface")
public class WebPictureInterfaceController extends BaseController {
	@Autowired
	private PictureService pictureService;
	/**
	 * 根据类型获取图片
	 * 
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/getPictureByType", method = RequestMethod.GET, produces = ContentType.APPLICATION_JSON_UTF8)
	@ResponseBody
	public  ResponseResult<List<PageData>> getPictureByType() {
		logBefore(logger, "API根据type获取lunbo图或about图");
		PageData pd = this.getPageData();
		try {
			String types = pd.getString("type");
			if("0".equals(types)){
				pd.put("type", "lunbo");
			}
			if("1".equals(types)){
				pd.put("type", "about");
			}
			List<PageData> lunboList = pictureService.getPictureByType(pd);
			if(lunboList == null || lunboList.size() == 0){
				return RestResultGenerator.genErrorResult("获取轮播失败");
			}
			return RestResultGenerator.genResult(lunboList,"获取轮播成功");
		} catch (Exception e) {
			logger.error("获取轮播失败", e);
			return RestResultGenerator.genErrorResult("获取轮播失败");
		}
	}
	/**
	 * 根据typeId获取图片
	 * 
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/getPictureByTypeId", method = RequestMethod.GET, produces = ContentType.APPLICATION_JSON_UTF8)
	@ResponseBody
	public  ResponseResult<List<PageData>> getPictureByTypeId() {
		logBefore(logger, "API根据typeId获取图片");
		PageData pd = this.getPageData();
		try {
			List<PageData> pictureList = pictureService.getPictureByTypeId(pd);
			if(pictureList == null || pictureList.size() == 0){
				return RestResultGenerator.genErrorResult("获取图片失败");
			}
			return RestResultGenerator.genResult(pictureList,"获取图片成功");
		} catch (Exception e) {
			logger.error("获取图片失败", e);
			return RestResultGenerator.genErrorResult("获取图片失败");
		}
	}

}
