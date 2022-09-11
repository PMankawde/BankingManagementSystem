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

import com.school.beans.Student;
import com.school.util.HibernateSessionUtil;

/**
 * Servlet implementation class StudentReport
 */
@WebServlet("/StudentReport")
public class StudentReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentReport() {
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
		Session session = HibernateSessionUtil.getSession();
		  PrintWriter out = response.getWriter();

		    try {
		    		int cl= Integer.parseInt(request.getParameter("classes"));
		            session.beginTransaction();
		            String hql = "from Student st where st.classes = :classes";
		            
		            System.out.println(hql);
					@SuppressWarnings("unchecked")
					Query<Student> query = session.createQuery(hql);
		            query.setParameter("classes", cl);
		            List<Student> st= (List<Student>)query.getResultList();
	           
					out.print("<h1 style='align-center' color='green'> Classess List :- </h1>");
					
					out.print("<style> table,td,th {"
							+ "border:2px solid red;"
							+ "padding: 10px; "
							+ "}</style>");
					out.print("<table >");
					out.print("<tr>");
						out.print("<th>  Class </th>");
						out.print("<th>  Student Names</th>");
						
					out.print("</tr>");
					
					Iterator<Student> ir = st.iterator();
					while(ir.hasNext()) {
						Student sts = ir.next();
						out.print("<tr>");
						out.print("<td>"+ sts.getClasses()+"</td>");
						out.print("<td>"+sts.getSt_name() +"</td>");
						out.print("</tr>");
					}
					out.print("</table><br><br>");
					out.print("<h3><a href='login.jsp'>Back </a></h3>");			           

		     
		    } catch (Exception e) {
		    	out.print(e);
		        if (session.getTransaction() != null) {
		            session.getTransaction().rollback();
		        	out.print("Error occur" + e);
		        }
		    } finally {
		        session.close();
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
