package dao;

import java.util.List;

import entity.User;

public interface UserDao {
	public int add(User use);
	public User get(int id);
	public List<User> getAll();
	public void update(User use);
	public void delete(User use);
}
