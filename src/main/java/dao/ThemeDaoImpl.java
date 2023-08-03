package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Theme;


public class ThemeDaoImpl implements ThemeDao {

	private Connection connection; 


	public ThemeDaoImpl (Connection connection) {
		this.connection=connection; 
	}

	@Override
	public int add(Theme theme) {
		PreparedStatement pst1;
		int nblignesExecutees = 0; 

		try {

			String query1 = "INSERT into theme(nom) VALUES (?)";
			
			pst1 = connection.prepareStatement(query1);

			pst1.setString(1, theme.getNom());
			nblignesExecutees = pst1.executeUpdate();

			pst1.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nblignesExecutees;
	}

	@Override
	public List<Theme> getAll() {
		Statement statement2; 
		List<Theme>listTheme = new ArrayList<>();

		try {
			String query2 = "SELECT * FROM theme";
			
			statement2 = connection.createStatement(); 
			
			ResultSet result2 = statement2.executeQuery(query2);

			while (result2.next()) {
				Integer id = result2.getInt ("id"); 
				String nom = result2.getString("nom");

				listTheme.add(new Theme (id, nom));	
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listTheme;
	}

	@Override
	public Theme get(int id) {
		Theme theme  = null;
		Statement statement3; 

		try {
			String query3 = "SELECT * FROM theme WHERE id = " + id; 
			
			statement3 = connection.createStatement();
			
			ResultSet result3 = statement3.executeQuery(query3);

			while (result3.next()) {
				Integer idTheme = result3.getInt("id");
				String nom = result3.getString("nom");


				theme  = (new Theme (idTheme, nom));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return theme;
	}

	@Override
	public void delete(Theme theme) {
		PreparedStatement pst4; 

		try {
			String query4 = "DELETE from theme where id = ?" ; 
			pst4 = connection.prepareStatement(query4);

			pst4.setInt(1, theme.getId());

			pst4.executeUpdate();
			pst4.close(); 

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Theme theme) {
		PreparedStatement pst5 = null ;

		try {

			String query5 = "UPDATE theme SET nom = ? where id = ?"; 
			
			pst5 = connection.prepareStatement(query5);
			
			pst5.setString(1, theme.getNom());
			pst5.setInt(2, theme.getId());
			

			pst5.executeUpdate(); 
			pst5.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}


}
