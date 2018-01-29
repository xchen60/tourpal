package com.xchen.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xchen.po.UserInfo;
import com.xchen.po.ViewInfo;
import com.xchen.service.ViewInfoService;

@Controller
@RequestMapping("/viewinfo/")
public class ViewInfoController {

	
	@Resource(name = "viewInfoServiceImpl")
	private ViewInfoService service;
	
	/**
	 * @param file
	 * @param viewinfo
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(@RequestParam(value = "file", required = false) MultipartFile file, ViewInfo viewinfo,
			Model model, HttpSession session) {

		// 上传地址
		String path = session.getServletContext().getRealPath("upload");
		System.out.println(path);

		String filename = UUID.randomUUID() + file.getOriginalFilename();
		System.out.println(filename);
		File targetFile = new File(path, filename);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		UserInfo user = (UserInfo) session.getAttribute("userinfo");

		if (viewinfo != null) {
			viewinfo.setUserNumber(user.getUserNumber());
			viewinfo.setViewTime(new Date());
			viewinfo.setViewPhoto(filename);
		}

		try {
			file.transferTo(targetFile);
			boolean mark = service.add(viewinfo);
			if (mark) {
				model.addAttribute("info", "Success!");
			} else {
				model.addAttribute("info", "Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("info", "Failed");
		}

		System.out.println(viewinfo);

		return "jsp/admin/viewinfo/viewinfo_info";
	}
	
	/**
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(ViewInfo info, Model model) {

		List<ViewInfo> list = service.getList(info);
		model.addAttribute("list", list);

		return "jsp/admin/viewinfo/viewinfo_list";
	}

	public ViewInfoService getService() {
		return service;
	}

	public void setService(ViewInfoService service) {
		this.service = service;
	}

}
