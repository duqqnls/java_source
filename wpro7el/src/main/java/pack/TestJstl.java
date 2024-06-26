package pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestJstl")
public class TestJstl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String irum = "duqqnls";
		request.setAttribute("irum", irum);
		
		Person person = new Person();
		person.setName("한국인");
		request.setAttribute("person", person);
		
		Student student = new Student();
		student.setAge(22);
		request.setAttribute("student", student);

		String[] ani = {"코코씨", "땅콩씨", "엽냐옹씨"};
		request.setAttribute("animal", ani);

		String[] foods = {"당근", "시금치", "호박"};
		List<Object> list = new ArrayList<Object>();
		list.add(ani);
		list.add(foods);
		request.setAttribute("list", list);

		// request.sendRedirect("testjstl.jsp?irum=irum&person=person&list=list");
		request.getRequestDispatcher("testjstl.jsp").forward(request, response);
	}
}