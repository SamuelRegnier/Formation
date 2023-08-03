package dao;

import java.util.List;

import entity.Matter;

public interface MatterDao {

	public int add (Matter matter); 
	public List<Matter> getAll();
	public Matter get(int id);
	public void delete(Matter matter);
	public void update (Matter matter);
		
}

