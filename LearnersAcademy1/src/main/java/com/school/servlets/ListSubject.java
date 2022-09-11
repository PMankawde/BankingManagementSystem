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

import com.school.beans.Subject;
import com.school.util.HibernateSessionUtil;

/**
 * Servlet implementation class ListTeacher
 */
@WebServlet("/ListSubject")
public class ListSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListSubject() {
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

			session.beginTransaction();
			String hql = " from Subject th";
			
			@SuppressWarnings("unchecked")
			Query<Subject> query = session.createQuery(hql);

			List<Subject> tcr = (List<Subject>)query.getResultList();

			out.print("<h1 style='align-center' color='green'> Subject List :- </h1>");

			out.print("<style> table,td,th {" + "border:2px solid red;" + "padding: 10px; " + "}</style>");
			out.print("<table >");
			out.print("<tr>");
			out.print("<th>  Subject Names</th>");
			out.print("</tr>");
			
			Iterator<Subject> ir = tcr.iterator();
			while(ir.hasNext()) {
				Subject th = ir.next();
				out.print("<tr>");
				out.print("<td>" + th.getSub_name() + "</td>");
				out.print("</tr>");
			}
			out.print("</table><br><br>");
			out.print("<h3><a href='admin.jsp'>Back </a></h3>");

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
