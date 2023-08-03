package dao;

import java.util.List;

import entity.Session;

public interface SessionDao {
	
	public int add (Session session); 
	public List<Session> getAll();
	public Session get(int id);
	public void delete(Session session);
	public void update (Session session);
	
	
}
