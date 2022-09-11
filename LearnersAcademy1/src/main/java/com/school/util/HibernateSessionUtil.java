package com.school.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.school.beans.Standard;
import com.school.beans.Student;
import com.school.beans.Subject;
import com.school.beans.Teacher;

public class HibernateSessionUtil {
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

    private static SessionFactory sessionFactory = null;
    static {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Standard.class)
			.addAnnotatedClass(Subject.class).buildSessionFactory();
    }

    public static Session getSession() {

        Session session = null;
        if (threadLocal.get() == null) {
            // Create Session object
            session = sessionFactory.openSession();
            threadLocal.set(session);
            
        } else {
            session = threadLocal.get();
        }
        return session;
    }

    public static void closeSession() {
        Session session = null;
        if (threadLocal.get() != null) {
            session = threadLocal.get();
            session.close();
            threadLocal.remove();
        }
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}