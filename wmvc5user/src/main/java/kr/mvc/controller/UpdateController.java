package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserManager;

public class UpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest req, 
			HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");

		UserForm userForm = new UserForm();
		userForm.setUserid(req.getParameter("userid"));
		userForm.setPassword(req.getParameter("password"));
		userForm.setName(req.getParameter("name"));
		userForm.setEmail(req.getParameter("email"));

		// 모델과 통신
		int result = UserManager.instance().update(userForm);

		ModelAndView modelAndView = new ModelAndView();

		if (result > 0) {
			// update 후 목록 보기
			modelAndView.setViewName("list.m2");
		} else {
			modelAndView.setViewName("fail.html");
		}
		modelAndView.setRedirect(true);
		return modelAndView;
	}

}
