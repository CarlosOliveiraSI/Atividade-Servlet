package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.sun.net.httpserver.Request;

/**
 * Servlet implementation class requestServlet
 */
@WebServlet("/request-body")
public class requestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public requestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String mensagem = request.getParameter("mensagem");
		
		out.println("<html>");
		out.println("<body");;
		out.println("<h2>Dados Enviados</h2>");
		out.println("<ul>");
		out.println("<li> <strong>Nome</strong>" + nome + "</li>");
		out.println("<li><strong>Email<strong>" + email + "</li>");
		out.println("<li><strong>mensagem<strong>" + mensagem + "</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

}
