package business;

public class UserService {
	private int cod;
	private int servicecode;
	private String username;
	private int closed;
	private int qualified;
	private int acepted;
	
	private String dateini;
	private String datefin;
	
	public UserService() {

	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public int getServicecode() {
		return servicecode;
	}
	public void setServicecode(int servicecode) {
		this.servicecode = servicecode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getClosed() {
		return closed;
	}
	public void setClosed(int closed) {
		this.closed = closed;
	}
	public int getQualified() {
		return qualified;
	}
	public void setQualified(int qualified) {
		this.qualified = qualified;
	}
	public int getAcepted() {
		return acepted;
	}
	public void setAcepted(int acepted) {
		this.acepted = acepted;
	}
	public String getDateini() {
		return dateini;
	}
	public void setDateini(String dateini) {
		this.dateini = dateini;
	}
	public String getDatefin() {
		return datefin;
	}
	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}
	

}
