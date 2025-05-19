package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import com.sun.net.httpserver.Request;

/**
 * Servlet implementation class HeadersServlet
 */
@WebServlet("/headers")
public class HeadersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeadersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Análise de Cabeçalhos</h2>");
		out.println("ul");
		
		Enumeration<String> headesNames = request.getHeaderNames();
		
		while (headesNames.hasMoreElements()) {
			String name = headesNames.nextElement();
			String valor = request.getHeader(name);
			out.println("<li><strong>"+ name +"</strong>: " + valor + "</li>");
			
			String ip = request.getRemoteAddr();
			out.println("<li><strong> IP do usuário</strong>:" + ip + "</li>");
			
			String protocolo = request.getProtocol();
			out.println("<li><strong>Versão do HTTP</strong>:" + protocolo +"</li>");
		}
			
		
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
	}


}
