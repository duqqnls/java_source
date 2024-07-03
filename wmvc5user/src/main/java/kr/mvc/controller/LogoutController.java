package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller{
	
	@Override
	public ModelAndView execute(HttpServletRequest req, 
			HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession(false);
		session.removeAttribute("userid");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.html");
		modelAndView.setRedirect(true);
		return modelAndView;
	}

}
