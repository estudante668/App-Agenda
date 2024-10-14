package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import model.DAO;

import model.JavaBeans;


@WebServlet(urlPatterns = {"/Controller","/main", "/enviarDados"})
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	DAO dao = new DAO();
    JavaBeans jb = new JavaBeans();
    
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Url capturada: ").append(request.getServletPath()); 
		
	    String action = request.getServletPath();
	    if(action.equals("/main")) {
	    	contatos(request, response);
	    } else if(action.equals("/enviarDados")) {
	    	novoContato(request, response);
	    } else {
	    	response.sendRedirect("index.html");
	    }
	}
	
	//listar contato
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("agenda.jsp");
	}
	
	//Inserir contato
	protected void novoContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			jb.setNome(request.getParameter("nome"));
			jb.setFone(request.getParameter("fone"));
			jb.setEmail(request.getParameter("email"));
			
			System.out.println("Nome insrido foi: " + jb.getNome());
			System.out.println("Fone insrido foi: " + jb.getFone());
			System.out.println("Email insrido foi: " + jb.getNome());
			
			dao.inseriContato(jb);
			
			//redirecionar a pagina.jsp
			response.sendRedirect("main");
		}
}
