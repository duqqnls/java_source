package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserDto;
import kr.mvc.model.UserManager;

public class ViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, 
			HttpServletResponse resp) throws Exception {
		// 상세보기 처리
		req.setCharacterEncoding("utf-8");
		String userid = req.getParameter("userid");
		
		// 모델과 통신
		UserDto dto = UserManager.instance().findUser(userid);
		req.setAttribute("user", dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view.jsp");
		modelAndView.setRedirect(false);
		return modelAndView;
	}
}
