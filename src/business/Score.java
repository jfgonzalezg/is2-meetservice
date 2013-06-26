package business;

public class Score {
	
	private int punctuality;
	private int quality;
	private int attention;
	private int fulfillment;
	private int cost;
	private String comment;
	
	public Score(){
		
	}
	
	public int getPunctuality(){
		return punctuality;
	}
	public void setPunctuality(int punctuality){
		this.punctuality = punctuality;
	}
	public int getQuality(){
		return quality;
	}
	public void setQuality(int quality){
		this.quality = quality;
	}
	public int getAttention(){
		return attention;
	}
	public void setAttention(int attention){
		this.attention = attention;
	}
	public int getFulfillment(){
		return fulfillment;
	}
	public void setFulfillment(int fulfillment){
		this.fulfillment = fulfillment;
	}
	public int getCost(){
		return cost;
	}
	public void setCost(int cost){
		this.cost = cost;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
