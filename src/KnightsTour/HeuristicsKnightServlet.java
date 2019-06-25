package KnightsTour;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HeuristicsKnightServlet
 */
@WebServlet("/HeuristicsKnightServlet")
public class HeuristicsKnightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeuristicsKnightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		
		
		PrintWriter pw = response.getWriter();
		int numOfRuns = Integer.parseInt((String)session.getAttribute("numberOfRuns"));
		int rowStart = Integer.parseInt((String)session.getAttribute("row"));
		int colStart = Integer.parseInt((String)session.getAttribute("column"));
		
		pw.println("Starting Heuristics Knight.");
		playHeuristicsKnight(numOfRuns, rowStart, colStart, pw);
		
		pw.close();
		
		
		
	}
	
	public void playHeuristicsKnight(int numOfRuns, int rowStart, int colStart, PrintWriter pw)
	{
		
        pw.println("<html><head>"
        		+ "<style>"
        		+ "td{"
        		+ "	padding: 15px"
        		+ "}"
        		+ "</style>"
        		+ "</head><body>");
        
        for(int counter = 1; counter <= numOfRuns; counter++)
        {
            HeuristicsKnight h1 = new HeuristicsKnight(rowStart, colStart); 
            h1.startHeuristicsKnight();
            pw.println("<br>Starting Position: <br>");
            
            h1.print2dArrToWebPage(pw);
            
            for(int i = 0; i < 200; i++)
            {
                h1.moveKnight();
            }
            
            h1.print2dArrToFile(counter);
            pw.println("<br>Ending Position: <br>");
            h1.print2dArrToWebPage(pw);
            pw.println("Trial: " + counter + ") The Knight was able to touch " + h1.getSequence() + " squares.<br>");
            h1 = null;
        }
        
        pw.println("</body></html>");
	}

}
