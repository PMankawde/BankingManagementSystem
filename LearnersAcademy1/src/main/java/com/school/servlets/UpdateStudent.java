package com.school.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateClass
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		
		try{
			
			int sid= Integer.parseInt(request.getParameter("id"));
												
            out.print("<form action=\"UpdateStudent1\" method=\"post\">");
            out.print("<br><br>Id: <br><input  name='st_id' id='st_id' type='text' value="+sid+"> <br><br>");
            out.print("<br><br>Class: <br><input  name='classes' id='classes' type='text'> <br><br>");
            out.print("Student Name : <br> <input name='st_name' id='st_name' type='text' > <br><br>");
            out.print("<button type='submit'>Submit</button></form>");
            

		}catch(Exception e) {
			out.print("Update failed!! as: "+ e);
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
