package main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.ConnectionDatabase;
import entity.User;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserMain {

	public static void main(String[] args) {
		Connection connection = ConnectionDatabase.getConnection();
		UserDao userDao = new UserDaoImpl(connection);
		
		User user = new User("REGNIER", "Samuel", new Date("16/08/1989"), "Rue toto", "sam@gmail.fr", "0303030303", "etudiant");
		User use = new User("DESSALES", "Samuel", new Date("16/08/1989"), "Rue toto", "sam@gmail.fr", "0303030303", "etudiant");
		userDao.add(use);
		userDao.add(user);
		User user3 = new User(1,"DESSALES", "Samuel", new Date("16/08/1989"), "Rue titi", "sam@gmail.fr", "0303030303", "professeur");
		userDao.update(user);
		User user1 = userDao.get(1);
		System.out.println(user1.getNom());
		List<User> users = new ArrayList<>();
		users = userDao.getAll();
		for(User user2 : users) {
			System.out.println(user2.getNom() + " " +user2.getPrenom());
		}
		userDao.delete(user1);
		
	}

}
