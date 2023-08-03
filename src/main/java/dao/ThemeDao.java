package dao;

import java.util.List;

import entity.Theme;



public interface ThemeDao {

	public int add (Theme theme); 
	public List<Theme> getAll();
	public Theme get(int id);
	public void delete(Theme theme);
	public void update (Theme theme);
		
}

