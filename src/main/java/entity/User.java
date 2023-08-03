package entity;

import java.util.Date;

public class User {
	private Integer id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String adresse;
	private String mail;
	private String telephone;
	private String statut;
	
	public User(Integer id, String nom, String prenom, Date dateNaissance, String adresse, String mail,
			String telephone, String statut) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.mail = mail;
		this.telephone = telephone;
		this.statut = statut;
	}
	
	public User(String nom, String prenom, Date dateNaissance, String adresse, String mail,
			String telephone, String statut) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.mail = mail;
		this.telephone = telephone;
		this.statut = statut;
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	
}
