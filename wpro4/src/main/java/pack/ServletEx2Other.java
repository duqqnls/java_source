package pack;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/ServletEx2Other")
public class ServletEx2Other extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String irum;

	    public ServletEx2Other(String irum) {
	        this.irum = irum;
	    }

	    public String getIrum() {
	        return irum; 
	}
}
 