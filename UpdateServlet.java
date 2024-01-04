package com.sathya;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UpdateServlet
 */
@MultipartConfig
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodId = request.getParameter("prodId");
        String proName= request.getParameter("proName");
        
        double proPrice = Double.parseDouble(request.getParameter("proPrice"));
        String proBrand = request.getParameter("proBrand");
        
        String proMadeIn = request.getParameter("proMadeIn");
        Date proMfgDate = Date.valueOf(request.getParameter("proMfgDate"));
        
        Date proExpDate = Date.valueOf(request.getParameter("proExpDate"));
        Part newImagePart = request.getPart("proImage");
	    
        
        Product product = new Product();
	     product.setProdId(prodId);
	     product.setProName(proName);
	     product.setProPrice(proPrice);
	     product.setProBrand(proBrand);
	     product.setProMadeIn(proMadeIn);
	     product.setProMfgDate(proMfgDate);
	     product.setProExpDate(proExpDate);
	     
	     ProductDao dao = new ProductDao();
	
	     // Check the image present or not if presnet set the data 
	     if (newImagePart != null && newImagePart.getSize() > 0) {
	            product.setProImage(newImagePart.getInputStream());
	     }
	     int result = dao.updateProduct(product);
	     
	     if(result == 1)
	     {  	request.setAttribute("updateResult", true);
	    	 	RequestDispatcher dispatcher = request.getRequestDispatcher("listprod.jsp");
	        	dispatcher.forward(request, response);
	     }    
	}

}
