package ca.algonquin.petfeeder;

import java.io.IOException;
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

        String dogName = request.getParameter("dogName");
        String dogType = request.getParameter("dogType");
        String dogOwner = request.getParameter("owner");
                
        DogBean dog = new DogBean();
        dog.setDogName(dogName);
        dog.setDogType(dogType);
        dog.setDogOwner(dogOwner);
       
        try {
            dogDao.registerDog(dog);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

      response.sendRedirect("mainuserpage.jsp");
    }
}