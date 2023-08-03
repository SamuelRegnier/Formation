package dao;

import java.util.List;

import entity.Classroom;

public interface ClassroomDao {
	public int add(Classroom classroom);
	public Classroom get(int id);
	public List<Classroom> getAll();
	public void update(Classroom classroom);
	public void delete(Classroom classroom);
}
