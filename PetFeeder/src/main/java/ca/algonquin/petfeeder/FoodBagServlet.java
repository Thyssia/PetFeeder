package ca.algonquin.petfeeder;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/FoodBagServlet")
public class FoodBagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FoodBagDao foodbagDao;
	private final int cupsPerKilo = 9;
    public void init() {
    	foodbagDao = new FoodBagDao();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		
    	String fbBrand = request.getParameter("food_bag_brand");
    	int fbSize = Integer.parseInt(request.getParameter("food_bag_size"));
    //	int sCups = Integer.parseInt(request.getParameter("size_cups"));
    	Date dayOpened = new Date();
		try {
			dayOpened = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("day_opened"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	String Owner = request.getParameter("owner");
       	
    	FoodBagBean foodbag = new FoodBagBean();
        foodbag.setFbBrand(fbBrand);
        foodbag.setFbSize(fbSize);
        foodbag.setSCups((fbSize * cupsPerKilo));
        foodbag.setDayOpened(dayOpened);
        foodbag.setOwner(Owner);
        
        try {
            foodbagDao.foodBag(foodbag);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("DogServlet?action=list");
    }
}