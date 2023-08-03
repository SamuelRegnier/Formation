package entity;

public class Classroom {
	private Integer id;
	private String nom;
	private Integer nbPlaces;
	private String statut;
	
	public Classroom(Integer id, String nom, Integer nbPlaces, String statut) {
		this.id = id;
		this.nom = nom;
		this.nbPlaces = nbPlaces;
		this.statut = statut;
	}
	
	public Classroom(String nom, Integer nbPlaces, String statut) {
		this.nom = nom;
		this.nbPlaces = nbPlaces;
		this.statut = statut;
	}

	public Classroom() {
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

	public Integer getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(Integer nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	
}
