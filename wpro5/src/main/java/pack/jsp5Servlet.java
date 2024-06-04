package pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp5Servlet")
public class jsp5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String data = request.getParameter("data");
		System.out.println("수신 data : " + data);
		
		// 서버가 다른 파일 호출 방법 1 : redirect 방식 - client에게 파일 요청 
		// response.sendRedirect("aaa.html"); // html파일을 요청할 경우 값을 넘길 수 없다. <파일 요청 0> 
		// response.sendRedirect("aaa.html?data=" + data); // html파일을 요청할 경우 값을 넘길 수 없다. <파일 요청 1>
		// response.sendRedirect("jsp5called.jsp?data=" + data); // jsp를 호출한 경우 값을 넘길 수 있다. <파일 요청 2> 
		// jsp를 호출한 경우 값을 넘길 수 있다. 값은 String만 가능 
		
		
		// 서버가 다른 파일 호출 방법 2 : forward 방식 - server가 직접 server에 있는 파일 호출 
		request.setAttribute("datas", data);
		// request.setAttribute("datas2", data2);
		// request.setAttribute("jikwons", jiklist);
		// request에 이름, 값의 형태로 String 또는 자바의 어떤 객체이든 전달이 가능
		/*
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp5called.jsp"); <같은 의미 1>
		dispatcher.forward(request, response);
		*/
		request.getRequestDispatcher("jsp5called.jsp").forward(request, response);  // <같은 의미 2>
		
	}

}
