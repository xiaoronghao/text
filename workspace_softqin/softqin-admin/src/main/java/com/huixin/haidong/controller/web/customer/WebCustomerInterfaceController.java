package com.huixin.haidong.controller.web.customer;

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
import com.huixin.haidong.service.customer.CustomerService;
import com.huixin.haidong.service.picture.PictureService;
import com.huixin.haidong.service.project.ProjectService;



@Controller
@RequestMapping(value = "/webCustomerInterface")
public class WebCustomerInterfaceController extends BaseController {
	@Autowired
	private CustomerService customerService;
	/**
	 * 根据类型获取图片
	 * 
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET, produces = ContentType.APPLICATION_JSON_UTF8)
	@ResponseBody
	public  ResponseResult<String> addCustomer() {
		logBefore(logger, "API新增客户信息");
		PageData pd = this.getPageData();
		try {
			 customerService.save(pd);
			return RestResultGenerator.genResult("客户信息新增成功");
		} catch (Exception e) {
			logger.error("客户信息新增失败", e);
			return RestResultGenerator.genErrorResult("客户信息新增失败");
		}
	}


}
