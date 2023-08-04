package entity;

public class Evaluation {

	private Integer id;
	private Integer note;
	private String commentaires;
	private Training idTraining;
	
	

	public Evaluation(Integer note, String commentaires,Training idTraining) {
		super();
		this.note = note;
		this.commentaires = commentaires;
		this.idTraining = idTraining;
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
	
	public Training getIdTraining() {
		return idTraining;
	}

	public void setIdTraining(Training idTraining) {
		this.idTraining = idTraining;
	}
	
	
}
