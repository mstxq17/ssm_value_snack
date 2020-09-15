package com.xq17.snack.controller;

import java.io.File;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;
import com.jspsmart.upload.Request;
import com.xq17.snack.bean.GoodsInfo;
import com.xq17.snack.service.IGoodsInfoService;
import com.xq17.snack.utils.ParameterUtil;
import com.xq17.snack.utils.StringUtil;
import com.xq17.snack.vo.ResultVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.xq17.snack.service.IGoodsInfoService;


@RestController
@RequestMapping("/goods")
public class GoodsInfoController{
	
	@Autowired
	private IGoodsInfoService goodsInfoService;
	
	@PostMapping("/findByPage")
	public List<GoodsInfo> findByPage(@RequestParam Map<String, Object> map, HttpServletRequest request){
		return goodsInfoService.findByPage(ParameterUtil.changeFindByPageParam(map, request));
	}

	@GetMapping("/findByFirst")
	public Map<String, Object> findByFirst(@RequestParam Map<String, Object> map, HttpServletRequest request){
		return goodsInfoService.findByFirst(ParameterUtil.changeFindByPageParam(map, request));
	}
	
	@PostMapping("/finds")
	public Map<String, Object> finds(@RequestParam Map<String, Object> map, HttpServletRequest request){
		return goodsInfoService.finds(ParameterUtil.changeFindByPageParam(map, request));
	}
	
	
	/**
	 * 
	    * @Title: upload  
	    * @Description: 处理富文本编辑器中的文件上传
	    * @param @param pic
	    * @param @param request
	    * @param @return    参数  
	    * @return Map<String,Object>    返回类型  
	    * @throws
	 */
	@PostMapping("/upload")
	public Map<String, Object>  upload(@RequestParam("upload") MultipartFile pic, HttpServletRequest request){
		if(pic.isEmpty()) {
			return Collections.emptyMap();
		}
		
		
		Map<String, Object> map;
		try {
			String savePath;
			File dest;
			map = new HashMap<String, Object>();
			
			String path = request.getServletContext().getRealPath("/"); //获取Tocmat在服务器中的绝对路径
			System.out.println(path);
			savePath = request.getServletContext().getInitParameter("uploadPath");
			
			if(StringUtil.checkStringNull(savePath)) {
				savePath = "../snacknet_pics";
			}
			
			savePath += "/" + new Date().getTime() + "_" + pic.getOriginalFilename();
			dest = new File(path, savePath);
			//System.out.println(dest);
			pic.transferTo(dest);
			map.put("fileName",pic.getOriginalFilename());
			map.put("uploaded", 1);
			map.put("url", "../../" + savePath);
			return map;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Collections.emptyMap();
	}
	
	
	/**
	 * 
	    * @Title: add  
	    * @Description: 商品的添加
	    * @param @param pics
	    * @param @param gf
	    * @param @param request
	    * @param @return    参数  
	    * @return ResultVo    返回类型  
	    * @throws
	 */
	@PostMapping("/add")
	public ResultVo add(@RequestParam("goodspics") MultipartFile[] pics, GoodsInfo gf, HttpServletRequest request) {
		
		if(pics != null && pics.length>0  && !pics[0].isEmpty()) {
			try {
				String savePath;
				String path = request.getServletContext().getRealPath("/"); //获取Tocmat在服务器中的绝对路径
				savePath = request.getServletContext().getInitParameter("uploadPath");
				
				if(StringUtil.checkStringNull(savePath)) {
					savePath = "../snacknet_pics";
				}
				
				String picStr = "";
				File  dest = null;
				String temp = null;
				
				for(MultipartFile pic:pics) {
					temp = savePath + "/" + new Date().getTime() + "_" + pic.getOriginalFilename();
					dest = new File(path, temp);
					pic.transferTo(dest);
					picStr += temp + ",";
				}
				
				if(!"".equals(picStr)) {
					picStr = picStr.substring(0, picStr.lastIndexOf(","));
				}
				gf.setPics(picStr);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(goodsInfoService.add(gf) >0) {
				 return new ResultVo(200, "成功", null);
			}

		}
		return new ResultVo(500, "失败", null);
	}
	
}
