package com.srird.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srird.hibernate.entity.Student;

public class UpdateStudentDemo {

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
			
			int id = 1;
			//Update the student
			Student student = session.get(Student.class, id);
			student.setEmail("SriramKumar@gmail.com");
			
			//Updating all the rows
			session.createQuery("update Student set email='srird49@gmail.com'").executeUpdate();
			
			//Commit the transaction
			System.out.println("Commit the transaction....Done!!!!");
			session.getTransaction().commit();
			

			}
		
		finally {
			factory.close();
		}
	}

}
