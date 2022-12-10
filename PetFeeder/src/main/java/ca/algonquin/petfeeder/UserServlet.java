package ca.algonquin.petfeeder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/register")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	 	    throws ServletException, IOException {
    	String action = request.getServletPath();
    	System.out.println("Got action in post: " + action);
    	doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        	throws ServletException, IOException {
    	
    	String action = request.getParameter("action");
    	try {
       		switch (action) {
       			case "REGISTER":
       				register(request, response);
       				break;
       			case "DOREGISTRATION":
       				doregistration(request, response);
        	        break;
        	    case "LOGIN":
        	    	login(request, response);
        	        break;
        	    case "LOGOUT":
        	        logout(request, response);
        	        break;
        	    default:
        	      	login(request, response);
        	        break;
            }
        } catch (SQLException ex) {
        	throw new ServletException(ex);
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
    	}
    }
    
    private void register(HttpServletRequest request, HttpServletResponse response)
        	throws SQLException, IOException, ServletException, ClassNotFoundException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("userregister.jsp");
	    dispatcher.forward(request, response);
    }
    
    private void doregistration(HttpServletRequest request, HttpServletResponse response)
        	throws SQLException, IOException, ServletException, ClassNotFoundException {
    	String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserBean user = new UserBean(firstName, lastName, email, username, password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        
        try {
            userDao.registerUser(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("login.jsp");
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response)
        	throws SQLException, IOException, ServletException, ClassNotFoundException {
    	String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserBean user = new UserBean(username, password);
        user.setUsername(username);
        user.setPassword(password);

        try {
            if (userDao.validate(user)) {
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                response.sendRedirect("DogServlet?action=list");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("user?action=REGISTER");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
       	
    private void logout(HttpServletRequest request, HttpServletResponse response)
        	throws SQLException, IOException, ServletException, ClassNotFoundException {
    	HttpSession session = request.getSession();
        session.setAttribute("username", null);
        response.sendRedirect("login.jsp");
    }
}