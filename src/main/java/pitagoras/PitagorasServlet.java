package pitagoras;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PitagorasServlet
 */
public class PitagorasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PitagorasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c1Param = request.getParameter("c1");
		String c2Param = request.getParameter("c2");
		String hypotenuseParam = request.getParameter("hypotenuse");
		Double c1 = c1Param != null && !c1Param.isEmpty() ? Float.parseFloat(c1Param) : 0d;
		Double c2 = c2Param != null && !c2Param.isEmpty() ? Float.parseFloat(c2Param) : 0d;
		Double hypo = hypotenuseParam != null && !hypotenuseParam.isEmpty() ? Float.parseFloat(hypotenuseParam) : 0d;
		boolean error = false;
		
		if (((c1Param == null || c1Param.isEmpty()) && (c2Param == null || c2Param.isEmpty())) ||
				((c1Param == null || c1Param.isEmpty()) && (hypotenuseParam == null || hypotenuseParam.isEmpty())) ||
				((hypotenuseParam == null || hypotenuseParam.isEmpty()) && (c2Param == null || c2Param.isEmpty()))) {
			response.getWriter().append("Faltan datos para poder hacer el cálculo");
			return;
		}
		
		if (c1Param != null && !c1Param.isEmpty() && c2Param != null && !c2Param.isEmpty()) {
			hypo = Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));
		}
		
		if (c1Param != null && !c1Param.isEmpty() && hypotenuseParam != null && !hypotenuseParam.isEmpty()) {
			error = sendError(request, c1, hypo);
			c2 = Math.sqrt(Math.pow(hypo, 2) - Math.pow(c1, 2));
		}
		
		error = sendError(request, c2, hypo);
		c1 = Math.sqrt(Math.pow(hypo, 2) - Math.pow(c2, 2));
		
		if (!error) {
			request.setAttribute("c1", c1);
			request.setAttribute("c2", c2);
			request.setAttribute("hypo", hypo);
		}
		
		request.getRequestDispatcher("pitagoras.jsp").forward(request, response);
	}

	private boolean sendError(HttpServletRequest request, Double c, Double hypo) {
		if (c >= hypo) {
			request.setAttribute("error", true);
			return true;
		}
		
		return false;
	}
}
