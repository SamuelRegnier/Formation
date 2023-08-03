package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.User;
import utils.UtilDate;

public class UserDaoImpl implements UserDao {
	private Connection connection;
	
	public UserDaoImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public int add(User use) {
		int nbLigneCreees = 0;
		try {
			String query = "INSERT INTO user (nom, prenom, date_naissance, adresse, mail, telephone, statut) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement stm = connection.prepareStatement(query);
			
			stm.setString(1, use.getNom());
			stm.setString(2, use.getPrenom());
			stm.setDate(3, UtilDate.changeDate(use.getDateNaissance()));
			stm.setString(4, use.getAdresse());
			stm.setString(5, use.getMail());
			stm.setString(6, use.getTelephone());
			stm.setString(7, use.getStatut());
			
			nbLigneCreees = stm.executeUpdate();;
			stm.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nbLigneCreees;
	}

	@Override
	public User get(int id) {
		User use = null;
		try {
			Statement stm = connection.createStatement();
			String query = "SELECT * FROM user WHERE id = " + id;
			
			ResultSet result = stm.executeQuery(query);
			
			while(result.next()) {
				Integer id2 = result.getInt("id");
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				Date date = result.getDate("date_naissance");
				String adresse = result.getString("adresse");
				String mail = result.getString("mail");
				String tel = result.getString("telephone");
				String statut = result.getNString("statut");
				use = (new User (id2, nom, prenom, date, adresse, mail, tel, statut)); 
			}
			
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return use;
	}

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		try {
			Statement stm = connection.createStatement();
			String query = "SELECT * FROM user";
			
			ResultSet result = stm.executeQuery(query);
			
			while(result.next()) {
				Integer id2 = result.getInt("id");
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				Date date = result.getDate("date_naissance");
				String adresse = result.getString("adresse");
				String mail = result.getString("mail");
				String tel = result.getString("telephone");
				String statut = result.getNString("statut");
				users.add(new User(id2, nom, prenom, date, adresse, mail, tel, statut));
			}
			
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void update(User use) {
		try {
			String query = "UPDATE user set nom=?, prenom=?, date_naissance=?, adresse=?, mail=?, telephone=?, statut=? WHERE id=?";
			PreparedStatement stm = connection.prepareStatement(query);
			
			stm.setString(1, use.getNom());
			stm.setString(2, use.getPrenom());
			stm.setDate(3, UtilDate.changeDate(use.getDateNaissance()));
			stm.setString(4, use.getAdresse());
			stm.setString(5, use.getMail());
			stm.setString(6, use.getTelephone());
			stm.setString(7, use.getStatut());
			stm.setInt(8, use.getId());
			
			stm.executeUpdate();
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User use) {
		try {
			String query = "DELETE FROM user WHERE id = ?";
			PreparedStatement stm = connection.prepareStatement(query);
			
			stm.setInt(1, use.getId());
			
			stm.executeUpdate();
			stm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
}
