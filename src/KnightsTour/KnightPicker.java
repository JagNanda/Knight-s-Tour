package KnightsTour;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class KnightPicker
 */
@WebServlet("/KnightPicker")
public class KnightPicker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public KnightPicker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String knightVersion = request.getParameter("version");
		
		if(knightVersion.equals("simpleVersion"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("SimpleKnightServlet");
			rd.forward(request,response);
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("numberOfRuns",request.getParameter("numberOfRuns"));
			session.setAttribute("row", request.getParameter("row"));
			session.setAttribute("column",request.getParameter("column"));
			response.sendRedirect("HeuristicsKnightServlet");
//			RequestDispatcher rd = request.getRequestDispatcher("HeuristicsKnightServlet");
//			rd.forward(request,response);
		}
		
	}



}
