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
import com.school.beans.Student;
import com.school.util.HibernateSessionUtil;

/**
 * Servlet implementation class StudentReport
 */
@WebServlet("/ManageStudent")
public class ManageStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageStudent() {
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
		@SuppressWarnings("unchecked")
		List<Student> students = session.createQuery("Select student from Student student ").list();

		out.print("<style> table,td,th {" + "border:2px solid red;" + "padding: 10px; " + "}</style>");
		out.print("<table >");
		out.print("<tr>");
		out.print("<th>  Class </th>");
		out.print("<th>  Student Names</th>");

		out.print("</tr>");

		Iterator<Student> ir = students.iterator();
		while (ir.hasNext()) {
			Student st = ir.next();
			out.print("<tr>");
			out.print("<td>" + st.getClasses() + "</td>");
			out.print("<td>" + st.getSt_name() + "</td>");
			out.print("<td ><a href='UpdateStudent?id=" + st.getSt_id() + "'><button>update</button></a>"
					+ "<a href='DeleteStudent?id=" + st.getSt_id() + "'><button>delete</button></a></td>");
			out.print("</tr>");
		}
		out.print("</table><br><br>");
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
