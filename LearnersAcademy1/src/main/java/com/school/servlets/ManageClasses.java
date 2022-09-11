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
import com.school.beans.Standard;
import com.school.util.HibernateSessionUtil;

/**
 * Servlet implementation class StudentReport
 */
@WebServlet("/ManageClasses")
public class ManageClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageClasses() {
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
			@SuppressWarnings("unchecked")
			List<Standard> classes = (List<Standard>) session.createQuery("select cl from Standard cl").getResultList();

			// List<Classes> classes= session.createQuery("select myclass from class myclass
			// ").list();

			out.print("<style> table,td,th {" + "border:2px solid red;" + "padding: 10px; " + "}</style>");
			out.print("<table >");
			out.print("<tr>");
			out.print("<th>  Class </th>");
			out.print("<th>  Subject</th>");
			out.print("<th>  Teacher</th>");

			out.print("</tr>");

			Iterator<Standard> ir = classes.iterator();
			while (ir.hasNext()) {
				Standard cl = ir.next();
				out.print("<tr>");
				out.print("<td>" + cl.getClasses() + "</td>");
				out.print("<td>" + cl.getSub_name() + "</td>");
				out.print("<td>" + cl.getT_name() + "</td>");
				out.print("<td ><a href='UpdateClass?id=" + cl.getCl_id() + "'><button>update</button></a>"
						+ "<a href='DeleteClass?id=" + cl.getCl_id() + "'><button>delete</button></a></td>");
				out.print("</tr>");

			}
			out.print("</table><br><br>");
		} catch (Exception e) {
			out.print("Class details can't be shown as: " + e);
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
