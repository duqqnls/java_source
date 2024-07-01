package pack.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.model.GugudanModel;
import pack.model.HobbyModel;

@WebServlet({"/gugudan.do", "/gugudan2.do", "*.kor"})
public class GugudanController  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GugudanModel model;

	public void init(ServletConfig config) throws ServletException {
		model = new GugudanModel();
	}
	
	public void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		String gugudan = req.getParameter("gugudan");
	}
}
