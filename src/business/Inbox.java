package business;

public class Inbox {
	
	private int codget;
	private String date;
	private String sender;
	private String message;
	
	public int getCodget() {
		return codget;
	}

	public void setCodget(int codget) {
		this.codget = codget;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Inbox(){
	}

}
