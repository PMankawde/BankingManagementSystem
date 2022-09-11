package com.school.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.school.beans.Standard;
import com.school.util.HibernateSessionUtil;

/**
 * Servlet implementation class StudentReport
 */
@WebServlet("/ClassReport")
public class ClassReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassReport() {
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
		Session session = HibernateSessionUtil.getSession();
		PrintWriter out = response.getWriter();

		try {
			int cla = Integer.parseInt(request.getParameter("classes"));
			session.beginTransaction();
			String hql = "from Standard where classes = :classes";

			@SuppressWarnings("unchecked")
			Query<Standard> query = session.createQuery(hql);
			query.setParameter("classes", cla);

			List<Standard> std = (List<Standard>) query.getResultList();

			out.print("<h1 style='align-center' color='green'> Classess List :- </h1>");

			out.print("<style> table,td,th {" + "border:2px solid red;" + "padding: 10px; " + "}</style>");
			out.print("<table >");
			out.print("<tr>");
			out.print("<th>  Class </th>");
			out.print("<th> Subject </th>");
			out.print("<th>  Teacher Names</th>");

			out.print("</tr>");

			Iterator<Standard> ir = std.iterator();
			while (ir.hasNext()) {
				Standard cl = ir.next();
				out.print("<tr>");
				out.print("<td>" + cl.getClasses() + "</td>");
				out.print("<td>" + cl.getSub_name() + "</td>");
				out.print("<td>" + cl.getT_name() + "</td>");
				out.print("</tr>");
			}
			out.print("</table><br><br>");
			out.print("<h3><a href='home.html'>Back </a></h3>");

		} catch (Exception e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
				out.print("Error occur" + e);
			}
		} finally {
			session.close();
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
