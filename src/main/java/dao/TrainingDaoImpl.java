package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import entity.Training;

public class TrainingDaoImpl implements TrainingDao {

	private Connection connection;
	
	
	public TrainingDaoImpl(Connection connection) {
		this.connection = connection;
	}

	
	
	@Override
	public int add(Training training) {
		int nbLignesExecutees = 0;
		
		try {
			String query = "insert into training(nom, duree, nb_Participants, certifiante, prerequis, prix, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement ps = connection.prepareStatement(query);
		    
		    ps.setString(1, training.getNom());
		    ps.setInt(2, training.getDuree());
		    ps.setInt(3, training.getNbParticipants());
		    ps.setBoolean(4, training.getCertifiante());
		    ps.setBoolean(5, training.getPrerequis());
		    ps.setInt(6, training.getPrix());
		    ps.setString(7, training.getDescription());
		    
		    nbLignesExecutees = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return nbLignesExecutees;
	}

	@Override
	public List<Training> getAll() {
		List<Training> listTraining = new ArrayList<>();
		
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM training";
			
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				Integer id = result.getInt("id");
				String nom = result.getString("nom");
				Integer duree = result.getInt("duree");
				Integer nbParticipants = result.getInt("nb_Participants");
				Boolean certifiante = result.getBoolean("certifiante");
				Boolean prerequis = result.getBoolean("prerequis");
				Integer prix = result.getInt("prix");
				String description = result.getString("description");
				listTraining.add(new Training(id, nom, duree, nbParticipants, certifiante, prerequis, prix, description));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listTraining;
	}
	

	@Override
	public Training get(int id) {
		Training training = null;

		try {
	        String query = "select * from training where id= ?";
	        PreparedStatement ps = connection.prepareStatement(query);

		    ps.setInt(1, id);
		    training = new Training();
		    ResultSet rs = ps.executeQuery();

		    while (rs.next()) {
		        training.setId(rs.getInt("id"));
		        training.setNom(rs.getString("nom"));
		        training.setDuree(rs.getInt("duree"));
		        training.setNbParticipants(rs.getInt("nb_participants"));
		        training.setCertifiante(rs.getBoolean("certifiante"));
		        training.setPrerequis(rs.getBoolean("prerequis"));
		        training.setPrix(rs.getInt("prix"));
		        training.setDescription(rs.getString("description"));
		    }
		    return training;

		} catch (Exception e){
			e.printStackTrace();
		}
		
		return training;
	}

	
	@Override
	public void update(Training training) {
		try {
	        String query = "update training set nom=?, "
            		+ " duree= ?, " + " nb_participants=?, " + " certifiante=?, " 
	        		+ " prerequis=?, " + " prix=?, " + " description=? where id = ?";
		    PreparedStatement ps = connection.prepareStatement(query);
		    
		    ps.setString(1, training.getNom());
		    ps.setInt(2, training.getDuree());
		    ps.setInt(3, training.getNbParticipants());
		    ps.setBoolean(4, training.getCertifiante());
		    ps.setBoolean(5, training.getPrerequis());
		    ps.setInt(6, training.getPrix());
		    ps.setString(7, training.getDescription());
		    ps.setInt(8, training.getId());
		    ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Training training) {
		try {
	        String query = "delete from training where id =?";
	        PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, training.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
