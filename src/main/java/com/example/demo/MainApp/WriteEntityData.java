package com.example.demo.MainApp;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.demo.entity.Privilege;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;

public class WriteEntityData {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("dbConfig.cfg.xml")
				.addAnnotatedClass(User.class).addAnnotatedClass(Role.class)
				.addAnnotatedClass(Privilege.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			Set<Role> role = new HashSet();
			Set<Privilege> privilege = new HashSet();

			User userEntity = new User (3L, "Arun","arun@gmail.com","Arun@1234");

			Role roleEntity = new Role(3L, "Arun");

			Privilege privilegeEntity = new Privilege(3L, "Arun");

			role.add(roleEntity);
			privilege.add(privilegeEntity);

			privilegeEntity.setRoles(role);

			roleEntity.setPrivileges(privilege);

			userEntity.setRoles(role);


			session.beginTransaction();

			System.out.println("Save Processing");
			session.saveOrUpdate(privilegeEntity);
			session.saveOrUpdate(roleEntity);
			session.saveOrUpdate(userEntity);

			System.out.println("Save Completed");
			session.getTransaction().commit();
		}finally {
			session.close();
		}
	}
}
