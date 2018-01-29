package com.xchen.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xchen.po.UserInfo;
import com.xchen.service.UserInfoService;

/**
 * 
 * User Info Controller
 * 
 */
/**
 * @author Thomas
 *
 */
@Controller
@RequestMapping("/userinfo/")
public class UserInfoController {

	@Resource(name = "userInfoServiceImpl")
	private UserInfoService userInfoService;

	/**
	 * Add
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(UserInfo user, Model model) {

		try {
			userInfoService.add(user);
			model.addAttribute("info", "Success");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("info", "Fail");
		}

		return "jsp/admin/userinfo/userinfo_info";
	}

	/**
	 * Query user List
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(UserInfo user, Model model) {
		List<UserInfo> list = userInfoService.getUserList(user);
		model.addAttribute("list", list);

		return "jsp/admin/userinfo/userinfo_list";
	}
	
	/**
	 * Load the change page
	 * @param userNumber
	 * @param model
	 * @return
	 */
	@RequestMapping("load.do")
	public String load(String userNumber,Model model){
		
		UserInfo user = userInfoService.getUser(userNumber);
		model.addAttribute("user", user);
		
		return "jsp/admin/userinfo/userinfo_update";
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	
	/**
	 * Update user inof
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(UserInfo user, Model model) {
		boolean mark = false;
		try {
			mark = userInfoService.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (mark) {
			model.addAttribute("info", "Success!");
		} else {
			model.addAttribute("info", "Fail");
		}

		return "jsp/admin/userinfo/userinfo_info";
	}
	
	/**
	 * Delete user info
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(String userNumber, Model model) {
		boolean mark = false;
		try {
			mark = userInfoService.delete(userNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (mark) {
			model.addAttribute("info", "Success!");
		} else {
			model.addAttribute("info", "Fail");
		}

		return "jsp/admin/userinfo/userinfo_info";
	}
	
	/**
	 * login
	 * @param userNumber
	 * @param userPw
	 * @param model
	 * @return
	 */
	@RequestMapping("login.do")
	public String login(String userNumber, String userPw, Model model, HttpSession session) {
		
		if (userNumber!=null && !userNumber.equals("")) {
			
			UserInfo user = userInfoService.getUser(userNumber);
			if (user!=null && user.getUserPw().equals(userPw) && "Admin".equals(user.getUserType())) {
				session.setAttribute("userinfo", user);
				return "jsp/admin/index";
			}else {
				model.addAttribute("info", "Incorrect password or account");
			}
			
		} else {
			model.addAttribute("info", "Invaild account or password");
		}
		
		
		return "jsp/admin/login";
	}
}











