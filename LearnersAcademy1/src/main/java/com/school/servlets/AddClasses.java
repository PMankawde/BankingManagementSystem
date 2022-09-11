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

import com.school.beans.Standard;
import com.school.beans.Subject;
import com.school.beans.Teacher;
import com.school.util.HibernateSessionUtil;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddClass")
public class AddClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddClasses() {
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
			String sub_name = request.getParameter("sub_name");
			String t_name = request.getParameter("t_name");

			Standard cl = new Standard(classes, sub_name, t_name);
			Subject sub = new Subject(sub_name);
			Teacher tchr = new Teacher(t_name);

			session.save(cl);
			session.save(sub);
			session.save(tchr);

			Transaction tx = session.getTransaction();
			if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
				tx.commit();
			}

			if (session != null) {
				out.print("<h3 style='color:green'> Class Details is Added sucessfully ! </h3>");
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
