package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class StatusServlet
 */
@WebServlet("/StatusServlet")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        String codeParam = request.getParameter("code");
        int statusCode = 200; 
        if (codeParam != null && !codeParam.isEmpty()) {
            try {
                statusCode = Integer.parseInt(codeParam);
            } catch (NumberFormatException e) {
                
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "O parâmetro 'code' deve ser um número.");
                return;
            }
        }
        
        
        response.setStatus(statusCode);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Status Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resposta enviada com o código de status: " + statusCode + "</h1>");
            out.println("<p>Use as ferramentas de desenvolvedor do seu navegador (F12) na aba 'Rede' (Network) para confirmar o status.</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
