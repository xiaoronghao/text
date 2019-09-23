package com.huixin.haidong.controller.series;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.huixin.framework.utils.Const;
import com.huixin.framework.utils.PageData;
import com.huixin.framework.utils.UuidUtil;
import com.huixin.haidong.controller.base.BaseController;
import com.huixin.haidong.service.series.SeriesService;
import com.huixin.system.entity.Page;

/**
 * 素材
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/series")
public class SeriesController extends BaseController {

	@Autowired
	private SeriesService seriesService;

	/*
	 * 列表
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(Page page, HttpServletRequest request) {
		logBefore(logger, "列表series");
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try {
			pd = this.getPageData();
			page.setPd(pd);
			List<PageData> seriesList = seriesService.list(page);
			mv.setViewName("series/series_list");
			mv.addObject("seriesList", seriesList);
			mv.addObject("pd", pd);
		} catch (Exception e) {
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
			mv.setViewName("series/series_edit");
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
			
			pd = seriesService.findById(pd);
			
			mv.setViewName("series/series_edit");
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
			/*@RequestParam(value="tp",required=false) MultipartFile tp,
			@RequestParam(value="tpz",required=false) String tpz,*/
			@RequestParam(value="id",required=false) String id,
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="content",required=false) String content
			) throws Exception{
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("content", content);
		pd.put("id", id);
		pd.put("name", name);
	/*	if(null == tpz){
			tpz = "";
		}
		*/
		//图片上传
			/*	String pictureSaveFilePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))+"../../";
				pictureSaveFilePath = pictureSaveFilePath.substring(6);		//去掉 'file:/'
				
				if (null != tp && !tp.isEmpty()) {
					try {
						String tpid = UuidUtil.get32UUID();
						
						// 扩展名格式：
						String extName = "";
						if (tp.getOriginalFilename().lastIndexOf(".") >= 0) {
							extName = tp.getOriginalFilename().substring(tp.getOriginalFilename().lastIndexOf("."));
						}
						
						this.copyFile(tp.getInputStream(), pictureSaveFilePath+"TP",tpid+extName).replaceAll("-", "");
						pd.put("pic", tpid+extName);
					} catch (IOException e) {
						logger.error(e.getMessage(), e);
					}
				}else{pd.put("pic", tpz);}*/
		
		
		
		seriesService.edit(pd);
		
		
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
		/*	@RequestParam(value="tp",required=false) MultipartFile tp,*/
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="content",required=false) String content
			) throws Exception{
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		pd.put("name", name);
		pd.put("content", content);
		
		/*//图片上传
				String pictureSaveFilePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))+"../../";
				pictureSaveFilePath = pictureSaveFilePath.substring(6);		//去掉 'file:/'
				
				if (null != tp && !tp.isEmpty()) {
					try {
						String id = UuidUtil.get32UUID();
						
						// 扩展名格式：
						String extName = "";
						if (tp.getOriginalFilename().lastIndexOf(".") >= 0) {
							extName = tp.getOriginalFilename().substring(tp.getOriginalFilename().lastIndexOf("."));
						}
						
						this.copyFile(tp.getInputStream(), pictureSaveFilePath+"TP",id+extName).replaceAll("-", "");
						pd.put("pic", id+extName);
					} catch (IOException e) {
						logger.error(e.getMessage(), e);
					}
				}else{pd.put("pic", "");}
		*/
		
		
		seriesService.save(pd);
		
		
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
			
			pd = seriesService.findById(pd);						  							 	//通过ID获取数据
			/*String pic = pd.getString("pic");*/
			
			//删除硬盘上的文件 start
			/*String xmpath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))+"../../";	//项目路径
			
			if(pic != null && !pic.equals("")){
				pic = (xmpath.trim() + "TP/" + pic.trim()).substring(6).trim();
				File f1 = new File(pic.trim());
				if(f1.exists()){
					f1.delete();
				}else{
					System.out.println("===="+pic+"不存在");
				}
			}*/
			
			seriesService.delete(pd);
			out.write("success");
			out.close();
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		
	}
	//删除图片
		@RequestMapping(value="/deltp")
		public void deltp(PrintWriter out) {
			logBefore(logger, "删除图片");
			try{
				PageData pd = new PageData();
				pd = this.getPageData();
				
				String pic = pd.getString("tpurl");													//图片路径
				if(pic != null){
					//删除硬盘上的文件 start
					String xmpath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))+"../../";	//项目路径
					pic = xmpath.trim() + "TP/" + pic.trim();
					pic = pic.substring(6);															//去掉 'file:/'
					File f = new File(pic.trim()); 
					if(f.exists()){
						f.delete();
					}else{
						System.out.println("===="+pic+"不存在");
					}
					//删除硬盘上的文件 end
					seriesService.deleteTp(pd);														//删除数据中图片数据
				}	
					
					out.write("success");
					out.close();
			}catch(Exception e){
				logger.error(e.toString(), e);
			}
		}
	
	/**
	 * 写文件到当前目录的upload目录中
	 * 
	 * @param in
	 * @param fileName
	 * @throws IOException
	 */
/*	private String copyFile(InputStream in, String dir, String realName)
			throws IOException {
		File file = new File(dir, realName);
		if (!file.exists()) {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
		}
		FileUtils.copyInputStreamToFile(in, file);
		return realName;
	}*/
	
	
	/* ===============================权限================================== */
	public Map<String, String> getHC(){
		Subject currentUser = SecurityUtils.getSubject();  //shiro管理的session
		Session session = currentUser.getSession();
		return (Map<String, String>)session.getAttribute(Const.SESSION_QX);
	}
	/* ===============================权限================================== */
}
