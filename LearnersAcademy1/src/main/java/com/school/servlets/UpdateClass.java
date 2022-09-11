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
@WebServlet("/UpdateClass")
public class UpdateClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClass() {
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
			 int cid= Integer.parseInt(request.getParameter("id"));
			 			 
            out.print("<form action=\"UpdateClass1\" method=\"post\">");
            out.print("<br><br>Id: <br><input  name='Cl_id' id='Cl_id' type='text' value="+cid+"> <br><br>");
            out.print("<br><br>Class: <br><input  name='classes' id='classes' type='text'> <br><br>");
            out.print("Subject : <br> <input name='sub_name' id='sub_name' type='text' > <br><br>");
            out.print("Teacher Name : <br> <input name='t_name' id='t_name' type='text' > <br><br> ");
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
