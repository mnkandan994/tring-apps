package com.example.demo.MainApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.demo.entity.Privilege;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;

public class ReadEntityData {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("dbConfig.cfg.xml")
				.addAnnotatedClass(User.class).addAnnotatedClass(Role.class)
				.addAnnotatedClass(Privilege.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			User user = session.find(User.class, 1L);

			System.out.println("Read Processing");

			System.out.println(user);
			System.out.println(user.getEmail());

			System.out.println("Read Completed");
			session.getTransaction().commit();

		}catch(NullPointerException e){
			System.err.println("correct the value of primary key");
		}finally {
			session.close();
			factory.close();
		}
	}
}
