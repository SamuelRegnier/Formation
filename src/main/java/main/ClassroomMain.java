package main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.ClassroomDao;
import dao.ClassroomDaoImpl;
import database.ConnectionDatabase;
import entity.Classroom;

public class ClassroomMain {

	public static void main(String[] args) {
		Connection connection = ConnectionDatabase.getConnection();
		ClassroomDao classroomDao = new ClassroomDaoImpl(connection);
		
		Classroom classe = new Classroom("Pelican", 25, "Disponible");
		Classroom class1 = new Classroom("Perroquet", 30, "Réservé");
		classroomDao.add(classe);
		classroomDao.add(class1);
		Classroom class3 = new Classroom(3,"Magellan", 10, "Disponible");
		classroomDao.update(class3);
		Classroom class2 = classroomDao.get(3);
		System.out.println(class2.getNom());
		List<Classroom> classrooms = new ArrayList<>();
		classrooms = classroomDao.getAll();
		for(Classroom c : classrooms) {
			System.out.println(c.getNom() + " " + c.getNbPlaces() + " " + c.getStatut());
		}
		//classroomDao.delete(class2);

	}

}
