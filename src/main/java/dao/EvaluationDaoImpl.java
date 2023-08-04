package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Evaluation;
import entity.Training;

public class EvaluationDaoImpl implements EvaluationDao {

	
	private Connection connection;
	protected TrainingDao trainingDao = new TrainingDaoImpl(connection);
	
	public EvaluationDaoImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public int add(Evaluation evaluation) {
		int nbLignesExecutees = 0;
		
		try {
			
			String query = "insert into evaluation(note, commentaires, id_training) VALUES (?, ?, ?)";
	        PreparedStatement ps = connection.prepareStatement(query);
		    
		    ps.setInt(1, evaluation.getNote());
		    ps.setString(2, evaluation.getCommentaires());
		    ps.setInt(3, evaluation.getIdTraining().getId());
		    
		    
		    nbLignesExecutees = ps.executeUpdate();
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
				Integer note = result.getInt("note");
				String commentaires = result.getString("commentaires");
				Training idTraining = trainingDao.get(result.getInt("id_training"));
				
				listEvaluation.add(new Evaluation(note, commentaires, idTraining));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listEvaluation;
	}

	@Override
	public Evaluation get(int id) {
		Evaluation evaluation = null;

		try {
	        String query = "select * from evaluation where id= ?";
	        PreparedStatement ps = connection.prepareStatement(query);

		    ps.setInt(1, id);
		    
		    ResultSet rs = ps.executeQuery();

		    while (rs.next()) {
		        
		        Integer note = rs.getInt("note");
		        String commentaires = rs.getString("commentaires");
		        Training idTraining = trainingDao.get(rs.getInt("id_training"));
		        evaluation = new Evaluation(note,commentaires,idTraining);
		    }
		    
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
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
