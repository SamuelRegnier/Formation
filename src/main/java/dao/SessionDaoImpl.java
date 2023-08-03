package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Session;
import utils.UtilDate;

public class SessionDaoImpl implements SessionDao {

	private Connection connection; 


	public SessionDaoImpl (Connection connection) {
		this.connection=connection; 
	}


	@Override
	public int add(Session session) {
		PreparedStatement pst1;
		int nblignesExecutees = 0; 

		try {

			String query1 = "Insert into session (date_debut , date_fin , nb_participants) values (? , ? , ?)";
			pst1 = connection.prepareStatement(query1);
			
			pst1.setDate(1, UtilDate.changeDate(session.getDateDebut()));
			pst1.setDate(2, UtilDate.changeDate(session.getDateFin()));
			pst1.setInt(3, session.getNbParticipant());

			nblignesExecutees = pst1.executeUpdate();

			pst1.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nblignesExecutees;
	}


	@Override
	public List<Session> getAll() {
		Statement statement2; 
		List<Session>listSession = new ArrayList<>();

		try {
			String query2 = "Select * from session";
			
			statement2 = connection.createStatement(); 
			
			ResultSet result2 = statement2.executeQuery(query2);

			while (result2.next()) {
				Integer id = result2.getInt("id");
				Date dateDebut = result2.getDate("date_debut");
				Date dateFin = result2.getDate("date_fin");
				Integer nbParticipant = result2.getInt("nb_participants");

				listSession.add(new Session (id, dateDebut, dateFin,nbParticipant));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listSession;
	}


	@Override
	public Session get(int id) {

		Session session = null;
		Statement statement3; 

		try {
			String query3 = "Select * from session where id = " + id; 
			
			statement3 = connection.createStatement();

			ResultSet result3 = statement3.executeQuery(query3);

			while (result3.next()) {
				Integer idSession = result3.getInt("id");
				Date dateDebut = result3.getDate("date_debut");
				Date dateFin = result3.getDate("date_fin");
				Integer nbParticipant = result3.getInt("nb_participants");


				session  = (new Session (idSession, dateDebut, dateFin, nbParticipant));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}

	@Override
	public void delete(Session session) {
		PreparedStatement pst4; 

		try {
			String query4 = "Delete from session where id = ?" ; 
			pst4 = connection.prepareStatement(query4);

			pst4.setInt(1, session.getId());

			pst4.executeUpdate();
			pst4.close(); 

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@Override
	public void update(Session session) {
		PreparedStatement pst5 = null ;

		try {

			String query5 = "Update session Set date_debut= ? , date_fin = ?, nb_participants= ? where id= ?"; 
			
			pst5 = connection.prepareStatement(query5);

			pst5.setDate(1, UtilDate.changeDate(session.getDateDebut()));
			pst5.setDate(2, UtilDate.changeDate(session.getDateFin()));
			pst5.setInt(3, session.getNbParticipant());
			pst5.setInt(4, session.getId());

			pst5.executeUpdate(); 
			pst5.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
