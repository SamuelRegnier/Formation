package entity;

public class Evaluation {

	private Integer id;
	private Integer note;
	private String commentaires;
	
	
	public Evaluation(Integer id, Integer note, String commentaires) {
		super();
		this.id = id;
		this.note = note;
		this.commentaires = commentaires;
	}

	public Evaluation() {
	}
	
	//GETTERS-SETTERS:
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNote() {
		return note;
	}


	public void setNote(Integer note) {
		this.note = note;
	}


	public String getCommentaires() {
		return commentaires;
	}


	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	
	
	
}
