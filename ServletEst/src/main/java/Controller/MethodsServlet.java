package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MethodsServlet
 */
@WebServlet("/MethodsServlet")
public class MethodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MethodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        response.setHeader("Allow", "GET, POST, OPTIONS");
        
        
        response.setStatus(HttpServletResponse.SC_OK);
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>Este endpoint suporta GET, POST e OPTIONS.</h1>");
        response.getWriter().println("<p>Use uma ferramenta como Postman ou cURL para fazer uma requisição OPTIONS e ver o cabeçalho 'Allow'.</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
