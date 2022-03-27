package com.srird.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srird.hibernate.entity.Student;

public class StudentDemo {

	public static void main(String[] args) {
		
		//Create a session factory
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();

		//Create a session
		Session session = factory.getCurrentSession();
		
		try {
		
			//Create a student Object
			System.out.println("Create a student Object....");
			Student student = new Student("Sriram5", "Kumar", "srird5@cisco.com");
			Student student1 = new Student("Sriram2", "Kumar", "srird2@cisco.com");
			Student student2 = new Student("Sriram3", "Kumar", "srird3@cisco.com");
			Student student3 = new Student("Sriram4", "Kumar", "srird4@cisco.com");
			
			List<Student> studentList = new ArrayList<Student>();
			
			studentList.add(student);
			studentList.add(student1);
			studentList.add(student2);
			studentList.add(student3);
			
			//Start a transaction
			session.beginTransaction();
			
			//Save the student object
			System.out.println("Saving a student Object....");
			session.save(student);
			session.save(student1);
			session.save(student2);
			session.save(student3);
	
			
			//Commit the transaction
			System.out.println("Commit the transaction....Done!!!!");
			session.getTransaction().commit();
			
			
			//Getting the value using Primary key
			
			//Get and start session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Get the student object
			System.out.println("Student Id :"+student.getId());
			Student tmpStudent = session.get(Student.class, student.getId());
			
			System.out.println("Result!!!!="+tmpStudent);
			
			//Committing the transaction
			
			session.getTransaction().commit();
		}
		
		finally {
			factory.close();
		}
	}

}
