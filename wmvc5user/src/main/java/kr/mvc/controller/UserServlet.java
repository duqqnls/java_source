package kr.mvc.controller;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.m2")
public class UserServlet extends HttpServlet {
	private ModelAndView modelAndView = null;
	private Controller controller = null;
	
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		try {
			// 파일명을 요청명 삼아 사용
			String ss = req.getRequestURI();
						
			// 파일명만 가져오기
			int idx = ss.lastIndexOf('/');
			StringTokenizer st = new StringTokenizer(ss.substring(idx + 1), ".");
			ss = st.nextToken();
			//System.out.println("ss : " + ss); // ss : login
			String command = ss; // login, list, insert, view
			
			controller = getController(command);
			modelAndView = controller.execute(req, resp);
			
			// 파일 호출 방식 선택
			if(modelAndView.isRedirect()) {
				resp.sendRedirect(modelAndView.getViewName());
			} else {
				RequestDispatcher dispatcher = 
						req.getRequestDispatcher("WEB-INF/views/" + modelAndView.getViewName());
				dispatcher.forward(req, resp);
			}
			
		} catch (Exception e) {
			System.out.println("service error : " + e);
		}

	}
	 
	public Controller getController(String command) throws Exception {
		if(command.equals("login")) {
			controller = new LoginController();
		} else if(command.equals("list")) {
			controller = new ListController();
		} else if(command.equals("insert")) {
			controller = new InsertController();
		} else if(command.equals("view")) {
			controller = new ViewController();
		} else if(command.equals("logout")) {
			controller = new LogoutController();
		} else if(command.equals("updateform")) {
			controller = new UpdateFormController();
		} else if(command.equals("update")) {
			controller = new UpdateController();
		} else if(command.equals("delete")) {
			controller = new DeleteController();
		}
		return controller;
	}

}
