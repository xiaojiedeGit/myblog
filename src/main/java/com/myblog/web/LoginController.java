package com.myblog.web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myblog.model.User;
import com.myblog.util.VerificationCodeUtils;

/**
 * 登录
 * 
 * @author Administrator
 *
 */
@Controller
public class LoginController {
	
	
	/**
	 * 用户登录
	 * @param user
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public void login(User user,String code,HttpServletRequest request) {
		System.out.println(user.toString());
		boolean b= LoginController.verifyCodeJudge(code, request);
		System.out.println(b);
	}
	
	
	/**
	 * 用户注销
	 * @param user
	 */
	public void cancellation(User user) {
		
	}
	
	/**
	 * 用户的注册
	 * @param user
	 */
	public void register(User user) {
		
	}
	
	/**
	 * 忘记密码修改密码
	 */
	public void forgetPassword() {
		
	}
	
	
	/**
	 * 验证码的获取
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getVerifyCode",method=RequestMethod.GET)
	@ResponseBody
	public void getVerifyCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache"); 
		response.setHeader("Pragme", "-1");
		
		Map<String, Object> map=VerificationCodeUtils.createImage();
		
		String verificationCode=(String) map.get("verificationCode");
		
		request.getSession().setAttribute("verificationCode",verificationCode);
		System.out.println(verificationCode);
		// 输出到页面
        ImageIO.write((BufferedImage)map.get("image"), "JPEG", response.getOutputStream());
	}
	
	
	private static boolean verifyCodeJudge(String code,HttpServletRequest request) {
		String verificationCode=(String) request.getSession().getAttribute("verificationCode");
		if(verificationCode!=null && !verificationCode.equals(code)) {
			return false;
		}
		
		return true;
	}

}
