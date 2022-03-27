package com.srird.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srird.hibernate.entity.Student;

public class QueryStudentDemo {

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
			
			//query the student
			//List<Student> studentList = session.createQuery("from Student s where s.firstName='Sriram5'").getResultList();
			
			List<Student> studentList = session.createQuery("from Student").getResultList();
			
			//Display the student list
			studentList.stream().forEach((c) -> System.out.println(c));
			
			
			//Commit the transaction
			System.out.println("Commit the transaction....Done!!!!");
			session.getTransaction().commit();
			

			}
		
		finally {
			factory.close();
		}
	}

}
