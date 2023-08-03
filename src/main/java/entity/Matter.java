package entity;

public class Matter {
	private Integer id; 
	private String nom;
	
	
	public Matter(Integer id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	public Matter() { 
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

