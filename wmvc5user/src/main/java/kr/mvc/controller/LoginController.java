package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.mvc.model.UserManager;

public class LoginController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest req, 
			HttpServletResponse resp) throws Exception {
		String id = req.getParameter("userid");
		String pwd = req.getParameter("password");
		
		// 모델과 통신
		UserManager manager = UserManager.instance();
		boolean b = manager.login(id, pwd);
		
		ModelAndView modelAndView = new ModelAndView();
		if(b) {
			// 로그인 성공 자격을 갖춤
			HttpSession session = req.getSession(true);
			session.setAttribute("userid", id);
			modelAndView.setViewName("list.m2");
		} else {
			modelAndView.setViewName("fail.html");
		}
		
		modelAndView.setRedirect(true);		
		return modelAndView;
	}

}
