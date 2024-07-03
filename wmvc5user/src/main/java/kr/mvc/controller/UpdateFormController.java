package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserDto;
import kr.mvc.model.UserManager;

public class UpdateFormController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, 
			HttpServletResponse resp) throws Exception {
		// 수정 화면 띄우기
		req.setCharacterEncoding("utf-8");
		String userid = req.getParameter("userid");
		
		UserDto dto = UserManager.instance().findUser(userid);
		req.setAttribute("user", dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("update.jsp");
		modelAndView.setRedirect(false);
		return modelAndView;
	}
}
