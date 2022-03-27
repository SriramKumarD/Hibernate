package com.srird.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srird.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//Create a session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();

		//Create a session
		Session session = factory.getCurrentSession();
		
		try {
		
			//Start a transaction
			session.beginTransaction();
			
			int studentId = 2;
			//Deleting the student
			/*
			 * Student student = session.get(Student.class, studentId);
			 * session.delete(student);
			 */
			
			//Another way of deleting 
			session.createQuery("delete from Student s where s.id = 1").executeUpdate();
			
			//Commit the transaction
			System.out.println("Commit the transaction....Done!!!!");
			session.getTransaction().commit();
			

			}
		
		finally {
			factory.close();
		}
	}

}
