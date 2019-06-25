package KnightsTour;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SimpleKnightServlet")
public class SimpleKnightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleKnightServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int numOfRuns = Integer.parseInt(request.getParameter("numberOfRuns"));
		int rowStart = Integer.parseInt(request.getParameter("row"));
		int colStart = Integer.parseInt(request.getParameter("column"));
		
		pw.println("Starting Simple Knight.");
		playSimpleKnight(numOfRuns, rowStart, colStart, pw);
		
		pw.close();
	}
	
	public void playSimpleKnight(int numOfRuns, int rowStart, int colStart, PrintWriter pw)
	{
        pw.println("<html><head>"
        		+ "<style>"
        		+ "td{"
        		+ "	padding: 15px"
        		+ "}"
        		+ "</style>"
        		+ "</head><body>");
        pw.println("<br>Starting Position: <br>");
        for(int counter = 1; counter <= numOfRuns; counter++)
        {
            SimpleKnight s1 = new SimpleKnight(rowStart, colStart); 
            s1.startSimpleKnight();
            
            s1.print2dArrWebPage(pw);
            
            for(int i = 0; i < 200; i++)
            {
                s1.moveKnight();
            }
            
            s1.print2dArrToFile(counter);
            pw.println("<br>Ending Position: <br>");
            s1.print2dArrWebPage(pw);
            pw.println("Trial: " + counter + ") The Knight was able to touch " + s1.getSequence() + " squares.<br>");
            s1 = null;
        }
        pw.println("</body></html>");
	}
	
	


}
