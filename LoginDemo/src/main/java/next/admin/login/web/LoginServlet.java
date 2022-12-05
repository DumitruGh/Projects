package next.admin.login.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import next.admin.login.bean.LoginBean;
import next.admin.login.database.LoginDao;

import java.io.IOException;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// noi avem nevoie de Bean ca sa stocam acolo datele introduse de la tastatura in campurile username si password
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		LoginDao loginDao = new LoginDao();
		
		if(loginDao.validate(loginBean)) {
			response.sendRedirect("loginSuccess.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}

}
