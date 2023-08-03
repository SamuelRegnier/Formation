package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Evaluation;

public class EvaluationDaoImpl implements EvaluationDao {

	
	private Connection connection;
	
	
	public EvaluationDaoImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public int add(Evaluation evaluation) {
		int nbLignesExecutees = 0;
		
		try {
			String query = "insert into evaluation(id, note, commentaires) VALUES (?, ?, ?)";
	        PreparedStatement ps = connection.prepareStatement(query);
		    ps.setInt(1, evaluation.getId());
		    ps.setInt(2, evaluation.getNote());
		    ps.setString(3, evaluation.getCommentaires());
		    
		    nbLignesExecutees = ps.executeUpdate();
		    ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return nbLignesExecutees;
	}

	@Override
	public List<Evaluation> getAll() {
		List<Evaluation> listEvaluation = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM evaluation";
			
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				Integer id = result.getInt("id");
				Integer note = result.getInt("note");
				String commentaires = result.getString("commentaires");
				
				listEvaluation.add(new Evaluation(id, note, commentaires));
			}
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listEvaluation;
	}

	@Override
	public Evaluation get(int id) {
		Evaluation evaluation = null;

		try {
	        String query = "select * from evaluation where id=" + id;
	        Statement ps = connection.createStatement();
		    
		    ResultSet rs = ps.executeQuery(query);

		    while (rs.next()) {
		        Integer id1 = rs.getInt("id");
		        Integer note = rs.getInt("note");
		        String commentaires = rs.getString("commentaires");
		        evaluation = new Evaluation(id1,note,commentaires);
		    }
		    ps.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return evaluation;
	}

	@Override
	public void update(Evaluation evaluation) {
		try {
	        String query = "update evaluation set note=?, commentaires= ? where id = ?";
		    PreparedStatement ps = connection.prepareStatement(query);
		    
		    ps.setInt(1, evaluation.getNote());
		    ps.setString(2, evaluation.getCommentaires());
		    ps.executeUpdate();
		    ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Evaluation evaluation) {
		try {
	        String query = "delete from evaluation where id =?";
	        PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, evaluation.getId());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
