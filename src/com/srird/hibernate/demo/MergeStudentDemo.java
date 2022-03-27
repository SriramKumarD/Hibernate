package com.srird.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srird.hibernate.entity.Student;

public class MergeStudentDemo {
	
	public static void main(String args[]) {
		
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		//Session one
		Session session1 = sessionFactory.openSession();
		
		Session session2 = sessionFactory.openSession();
		
		try {
			
			Student student = session1.get(Student.class, 3);
			
			session1.close();
			
			student.setEmail("sri@cisco.com");
			
			//Session two
			
			Student student1 = session2.get(Student.class, 3);
			
			session2.beginTransaction();
			
			session2.merge(student);
			
			System.out.println("Displaying >"+student1);
			
			session2.getTransaction().commit();
			
			session2.close();
		}
		finally {
			sessionFactory.close();
		}
		
		
		
		
	}

}