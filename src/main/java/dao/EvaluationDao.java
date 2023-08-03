package dao;

import java.util.List;

import entity.Evaluation;

public interface EvaluationDao {
	
	public int add(Evaluation evaluation);
	public List<Evaluation> getAll();
	public Evaluation get(int id);
	public void update(Evaluation evaluation);
	public void delete(Evaluation evaluation);
}
