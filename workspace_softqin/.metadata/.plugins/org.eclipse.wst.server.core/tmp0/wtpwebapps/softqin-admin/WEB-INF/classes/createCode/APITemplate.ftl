package com.huixin.haidong.controller.${packageName};

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huixin.haidong.controller.base.BaseController;
import com.huixin.haidong.haidong.framework.utils.PageData;
import com.ihealth.system.entity.Page;

import net.sf.json.JSONObject;
import com.huixin.haidong.service.${packageName}.${objectNameLower}.${objectName}Service;

/** 
 * 类名称：${objectName}Controller
 * 创建人：system
 * 创建时间：${nowDate?string("yyyy-MM-dd")}
 */
@Controller
@RequestMapping(value="/${objectNameLower}")
public class ${objectName}API extends BaseController {
	
	@Resource(name="${objectNameLower}Service")
	private ${objectName}Service ${objectNameLower}Service;
	
	/**
	 * 新增
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Object add() {
		PageData pd = this.getPageData();
		logBefore(logger, "新增${objectName}:" + pd);
		JSONObject jsonObject = new JSONObject();
		try {
			pd.put("id", this.get32UUID());	//主键
			${objectNameLower}Service.save(pd);
			jsonObject.put("message", "新增成功");
			jsonObject.put("code", 200);
		} catch (Exception e) {
			jsonObject.put("message", e.getMessage());
			logger.error(e.toString(), e);
		} 
		return jsonObject;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public @ResponseBody Object delete(@PathVariable("id") String id) {
		logBefore(logger, "删除${objectName}-id="+ id);
		PageData pd = new PageData();
		JSONObject jsonObject = new JSONObject();
		try {
			${objectNameLower}Service.delete(pd);
			jsonObject.put("message", "删除信息成功");
			jsonObject.put("code", 200);
		} catch (Exception e) {
			jsonObject.put("message", e.getMessage());
			logger.error(e.toString(), e);
		} 
		return jsonObject;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public @ResponseBody Object edit(@PathVariable("id") String id) {
		logBefore(logger, "修改${objectName}-id="+ id);
		PageData pd = this.getPageData();
		JSONObject jsonObject = new JSONObject();
		try {
			${objectNameLower}Service.edit(pd);
			jsonObject.put("message", "更新信息成功");
			jsonObject.put("code", 200);
		} catch (Exception e) {
			jsonObject.put("message", e.getMessage());
			logger.error(e.toString(), e);
		} 
		return jsonObject;
	}
	
	/**
	 * 根据ID查询
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody Object get(@PathVariable("id") String id) {
        logBefore(logger, "根据${objectName}-ID查询" + id);
		JSONObject jsonObject = new JSONObject();
		PageData pd = this.getPageData();
		try {
			pd.put("id", id);
			pd = ${objectNameLower}Service.findById(pd); // 根据ID读取
			jsonObject.put("data", pd);
			jsonObject.put("code", 200);
		} catch(Exception e){
			logger.error(e.toString(), e);
			jsonObject.put("message", e);
		}
		return jsonObject;
	}
	
	/**
	 * 查询列表
	 */
	@RequestMapping(method = RequestMethod.PATCH)
	public @ResponseBody Object list(Page page) {
		logBefore(logger, "列表${objectName}");
		PageData pd = new PageData();
		JSONObject jsonObject = new JSONObject();
		pd = this.getPageData();
		page.setPd(pd);
		try {
			List<PageData> list = ${objectNameLower}Service.list(page);
			jsonObject.put("data", list);
			jsonObject.put("code", 200);
		} catch(Exception e){
			logger.error(e.toString(), e);
			jsonObject.put("message", e);
		}
		return jsonObject;
	}
	
	
}
