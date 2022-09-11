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
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.school.beans.Student;
import com.school.util.HibernateSessionUtil;

/**
 * Servlet implementation class UpdateClass1
 */
@WebServlet("/UpdateStudent1")
public class UpdateStudent1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStudent1() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try{
			response.setContentType("text/html");  
		
		PrintWriter out=response.getWriter();
        Session session = HibernateSessionUtil.getSession();
        session.beginTransaction();
        String hql = "from Student where st_id = :st";
        int id= Integer.parseInt(request.getParameter("st_id"));
        
        @SuppressWarnings("unchecked")
		Query<Student> query = session.createQuery(hql);	
        query.setParameter("st", id);
        Student st= query.getSingleResult();
       
        
		st.setClasses(Integer.parseInt(request.getParameter("classes")));
        st.setSt_name(request.getParameter("st_name"));
        
         session.save(st);
         Transaction tx= session.getTransaction();
         if (tx.getStatus().equals(TransactionStatus.ACTIVE)) { 
			    tx.commit();
			}
			
			
			
			if (session != null) {
				out.print("<h3 style='color:green'> Student updated sucessfully ! </h3>");
				RequestDispatcher rd = request.getRequestDispatcher("ManageStudent");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.print("Update failed!"+ e);
			
		}
		
	}

}
