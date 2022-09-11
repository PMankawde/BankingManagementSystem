package com.school.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		try {

			String user = request.getParameter("Username");
			String pwd = request.getParameter("password");
			if (user.equals("") || pwd.equals("")) {
				out.println("<h1 style='color:red '>Login Failed ! ** Required filed is missing </h1>");
			} else if (user.equals("Admin") && pwd.equals("Password")) {
				out.print("<h3 style='color:Green'> Login Success </h3>");
				session.setMaxInactiveInterval(15 * 60);
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.include(request, response);

			}
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Login failed ! </h3>" + e);
		}
	}
}
