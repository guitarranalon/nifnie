package nie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class NieServlet
 */
public class NieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'};
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nie = request.getParameter("nie").toUpperCase();
		
		response.getWriter().append("<html><head><title>Letra NIE</title></head><body>");
		
		try {
			if (nie.charAt(0)!= 'X' && nie.charAt(0)!= 'Y' && nie.charAt(0)!='Z') {
				throw new Exception("Formato incorrecto");
			}
			
			if (nie.length()<5 || nie.length()>8) {
				throw new Exception("Longitud incorrecta");
			}
			
			String transformedNie = nie.replace('X', '0').replace('Y', '1').replace('Z', '2');
			int nif = Integer.parseInt(transformedNie);
			response.getWriter().append(request.getParameter("nie")).append(letras[nif%23]);
		}
		catch(Exception ex) {
			response.getWriter().append("Error: NIE incorrecto");	
		}
		
		response.getWriter().append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
