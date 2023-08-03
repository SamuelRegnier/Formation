package entity;

import java.util.Date;

public class Session {

	private Integer id; 
	private Date dateDebut;
	private Date dateFin;
	private Integer nbParticipant;
	
	
	public Session(Integer id, Date dateDebut, Date dateFin, Integer nbParticipant) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbParticipant = nbParticipant;
	}
	
	public Session () {
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public Integer getNbParticipant() {
		return nbParticipant;
	}


	public void setNbParticipant(Integer nbParticipant) {
		this.nbParticipant = nbParticipant;
	}
	
	
	
	
	
}
