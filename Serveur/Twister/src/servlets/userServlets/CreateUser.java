package servlets.userServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CreateUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Récupérer les paramètres
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		String admin = request.getParameter("admin");
	
		
		//Appeller le service  
		JSONObject jsonObject=services.UserServices.createUser(login,password,nom,prenom,admin);
		
		//Afficher la réponse sous forme JSON
		response.setContentType("application/json");      
		PrintWriter out = response.getWriter();  
		out.print(jsonObject.toString());
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
