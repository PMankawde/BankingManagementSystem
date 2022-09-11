package com.school.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.school.beans.Student;
import com.school.util.HibernateSessionUtil;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudent() {
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
		Session session = HibernateSessionUtil.getSession();

		PrintWriter out = response.getWriter();

		try {

			int classes = Integer.parseInt(request.getParameter("classes"));
			String student = request.getParameter("name");

			Student st = new Student(student, classes);

			session.save(st);

			Transaction tx = session.getTransaction();
			if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
				tx.commit();
			}

			if (session != null) {
				out.print("<h3 style='color:green'> Student is Added sucessfully ! </h3>");
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.include(request, response);
			}

		} catch (Exception e) {
			out.print("<h3 style='color:red'> Hibernate session is failed ! </h3>" + e);
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.include(request, response);
		} finally {
			session.close();
		}
	}

}
