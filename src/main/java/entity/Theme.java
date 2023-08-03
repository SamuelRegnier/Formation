package entity;

public class Theme {

	private Integer id; 
	private String nom;
	
	
	public Theme(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public Theme() { 
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
	
	
}

