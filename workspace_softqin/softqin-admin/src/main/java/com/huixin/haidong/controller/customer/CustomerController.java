package com.huixin.haidong.controller.customer;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.huixin.framework.utils.Const;
import com.huixin.framework.utils.PageData;
import com.huixin.haidong.controller.base.BaseController;
import com.huixin.haidong.service.customer.CustomerService;
import com.huixin.system.entity.Page;

/** 
 * 类名称：AndorraController
 * 创建人：FH 
 * 创建时间：2014年12月1日
 * @version
 */
@Controller
@RequestMapping(value="/customer")
public class CustomerController extends BaseController{
	
	@Resource(name="customerService")
	private CustomerService customerService;
	
	/**
	 * 列表
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page, HttpServletRequest request) throws Exception{
		logBefore(logger, "客户列表");
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			
			//检索条件================================
			String name = pd.getString("name");
			if(null != name && !"".equals(name)){
				name = name.trim();
				pd.put("name", name);
			}
			//检索条件================================
			
			page.setPd(pd);
			List<PageData>	customerList = customerService.list(page);
			
			mv.setViewName("customer/customer_list");
			mv.addObject("customerList", customerList);
			mv.addObject("pd", pd);
			mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		
		return mv;
	}
	
	
	/**
	 * 去新增页面
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd(){
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			mv.setViewName("customer/customer_edit");
			mv.addObject("msg", "save");
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}
	
	/**
	 * 去修改页面
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit(){
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			
			pd = customerService.findById(pd);
			
			mv.setViewName("customer/customer_edit");
			mv.addObject("msg", "edit");
			mv.addObject("pd", pd);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}						
		return mv;
	}
	
	/**
	 * 修改
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(
			HttpServletRequest request,
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="sex",required=false) String sex,
			@RequestParam(value="phone",required=false) String phone,
			@RequestParam(value="mail",required=false) String mail,
			@RequestParam(value="content",required=false) String content,
			@RequestParam(value="register_date",required=false) String register_date
			) throws Exception{
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("content", content);
		pd.put("id", id);
		pd.put("name", name);
		pd.put("register_date", register_date);
		pd.put("mail", mail);
		pd.put("sex", sex);
		pd.put("phone", phone);
	//	pd.put("uptime", DateUtil.getTime());				//修改时间
        customerService.edit(pd);
		
		
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(
			HttpServletRequest request,
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="sex",required=false) String sex,
			@RequestParam(value="phone",required=false) String phone,
			@RequestParam(value="mail",required=false) String mail,
			@RequestParam(value="content",required=false) String content,
			@RequestParam(value="register_date",required=false) String register_date
			) throws Exception{
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		pd.put("name", name);
		pd.put("sex", sex);
		pd.put("phone", phone);
		pd.put("mail", mail);
		pd.put("content", content);
		pd.put("register_date", register_date);

	    customerService.save(pd);
		
		
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out)throws Exception{
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			//pd = customerService.findById(pd);						  							 	//通过ID获取数据
			customerService.delete(pd);
			out.write("success");
			out.close();
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		
	}
	
	/* ===============================权限================================== */
	public Map<String, String> getHC(){
		Subject currentUser = SecurityUtils.getSubject();  //shiro管理的session
		Session session = currentUser.getSession();
		return (Map<String, String>)session.getAttribute(Const.SESSION_QX);
	}
	/* ===============================权限================================== */
}
