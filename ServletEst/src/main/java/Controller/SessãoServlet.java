package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SessãoServlet
 */
@WebServlet("/session")
public class SessãoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessãoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String nome = request.getParameter("nome");
        boolean encontrado = false;

        Cookie[] cookies = request.getCookies();
        
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("usuario")) {
                    nome = c.getValue(); 
                    encontrado = true;
                    break;
                }
            }
        }

        if (encontrado) {
            out.println("<h1>Bem-vindo de volta, " + nome + "!</h1>");
        } else {
            if (nome != null && !nome.isEmpty()) {
                Cookie novo = new Cookie("usuario", nome);
                novo.setMaxAge(60 * 60 * 24);
                response.addCookie(novo);
                out.println("<h1>Cookie criado para o usuário: " + nome + "</h1>");
            } else {
                out.println("<h1>Nome não informado!</h1>");
            }
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
