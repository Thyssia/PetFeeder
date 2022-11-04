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

@WebServlet("/DogServlet")
public class DogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DogDao dogDao;

    public void init() {
        dogDao = new DogDao();
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
    		System.out.println("Got action in get: " + action);
   	        try {
   	        	switch (action) {
   	        		case "new":
   	        			showNewForm(request, response);
    	                break;
    	            case "insert":
    	            	insertDog(request, response);
    	                break;
    	            case "delete":
    	                deleteDog(request, response);
    	                break;
    	            case "edit":
    	                showEditForm(request, response);
    	                break;
    	            case "update":
    	                updateDog(request, response);
    	                break;
    	            case "list":
    	                listDog(request, response);
    	                break;
    	            default:
    	            	listDog(request, response);
    	                break;
    	        }
    	    } catch (SQLException ex) {
    	          throw new ServletException(ex);
    	    }
     }

    private void listDog(HttpServletRequest request, HttpServletResponse response)
    	throws SQLException, IOException, ServletException {
    		System.out.println("getting: "+ request.getSession().getAttribute("username").toString());
    		List < DogBean > listDog = dogDao.selectAllDogs(request.getSession().getAttribute("username").toString());
    	    request.setAttribute("listDog", listDog);
    	    RequestDispatcher dispatcher = request.getRequestDispatcher("PetFeederMain.jsp");
    	    dispatcher.forward(request, response);
    	}

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("NewDog.jsp");
    	    dispatcher.forward(request, response);
    	}

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            DogBean existingDog = dogDao.selectDog(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("EditDog.jsp");
            request.setAttribute("dog", existingDog);
            dispatcher.forward(request, response);

        }

    private void insertDog(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException {
            String DogName = request.getParameter("dogName");
            String DogType = request.getParameter("dogType");
            String DogOwner = request.getParameter("owner");
            DogBean newDog = new DogBean(DogName, DogType, DogOwner);
            dogDao.insertDog(newDog);
            response.sendRedirect("DogServlet?action=list");
        }

    private void updateDog(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            String DogName = request.getParameter("dogName");
            String DogType = request.getParameter("dogType");
            String DogOwner = request.getParameter("owner");

            DogBean book = new DogBean(id, DogName, DogType, DogOwner);
            dogDao.updateDog(book);
            response.sendRedirect("DogServlet?action=list");
        }

    private void deleteDog(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            dogDao.deleteDog(id);
            response.sendRedirect("DogServlet?action=list");

    	}
}
 