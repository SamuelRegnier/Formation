package entity;

public class Training {
	private Integer id;
	private String nom;
	private Integer duree;
	private Integer nbParticipants;
	private Boolean certifiante;
	private Boolean prerequis;
	private Integer prix;
	private String description;
	
	public Training() {
		
	}
	
	public Training(String nom, Integer duree, Integer nbParticipants, Boolean certifiante,
			Boolean prerequis, Integer prix, String description) {
		super();
		this.nom = nom;
		this.duree = duree;
		this.nbParticipants = nbParticipants;
		this.certifiante = certifiante;
		this.prerequis = prerequis;
		this.prix = prix;
		this.description = description;
	}
	
	public Training(Integer id, String nom, Integer duree, Integer nbParticipants, Boolean certifiante,
			Boolean prerequis, Integer prix, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.duree = duree;
		this.nbParticipants = nbParticipants;
		this.certifiante = certifiante;
		this.prerequis = prerequis;
		this.prix = prix;
		this.description = description;
	}
	
	
	//GETTERS-SETTERS:
	
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
	
	
	public Integer getDuree() {
		return duree;
	}
	
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	
	
	public Integer getNbParticipants() {
		return nbParticipants;
	}
	
	public void setNbParticipants(Integer nbParticipants) {
		this.nbParticipants = nbParticipants;
	}
	
	
	public Boolean getCertifiante() {
		return certifiante;
	}
	
	public void setCertifiante(Boolean certifiante) {
		this.certifiante = certifiante;
	}
	
	
	public Boolean getPrerequis() {
		return prerequis;
	}
	
	public void setPrerequis(Boolean prerequis) {
		this.prerequis = prerequis;
	}
	
	
	public Integer getPrix() {
		return prix;
	}
	
	public void setPrix(Integer prix) {
		this.prix = prix;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
