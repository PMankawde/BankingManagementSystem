package com.school.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.school.beans.Standard;
import com.school.util.HibernateSessionUtil;

/**
 * Servlet implementation class DeleteClass
 */
@WebServlet("/DeleteClass")
public class DeleteClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteClass() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Session session = HibernateSessionUtil.getSession();

		try {

			int cid = Integer.parseInt(request.getParameter("id"));

			session.beginTransaction();
			String hql = "delete from Standard where cl_id = :cl";

			System.out.println(hql);
			@SuppressWarnings("unchecked")
			Query<Standard> query = session.createQuery(hql);
			query.setParameter("cl", cid);
			int count = query.executeUpdate();
			System.out.println(count + " Record(s) Deleted.");
			Transaction tx = session.getTransaction();

			if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
				tx.commit();
				// System.out.println(" Record(s) Deleted.");
			}

			if (session != null) {
				out.print("<h3 style='color:green'> Class Details deleted sucessfully ! </h3>");
				RequestDispatcher rd = request.getRequestDispatcher("ManageClasses");
				rd.include(request, response);
				session.clear();
				session.close();
			}

		} catch (Exception e) {
			out.print("Delete failed!! as: " + e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
