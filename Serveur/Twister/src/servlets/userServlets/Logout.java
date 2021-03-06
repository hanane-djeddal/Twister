package servlets.userServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupérer les paramètres
		String clef=request.getParameter("clef");
		
		//Appeller le service  
		JSONObject jsonObject=services.UserServices.logout(clef);
		
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
