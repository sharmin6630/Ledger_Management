package DynamicSolution1;

public class Consumable {
    protected String type;
    protected String name = "";
    protected String startDate = "";
    protected String endDate = "";
    protected double rating = 0.0;
    protected int consumedHours = 0;
    protected int consumedDays = 0;
    protected boolean hasEnded = false;

    public Consumable (String type, String name, String startDate, String endDate, double rating,
    		int consumedHours, int consumedDays, boolean hasEnded) {
        this.type = type;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
        this.consumedHours = consumedHours;
        this.consumedDays = consumedDays;
        this.hasEnded = hasEnded;
    }
    
    public String getType() {
    	return type;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setStartDate(String startDate) {
    	this.startDate = startDate;
    }
    
    public String getStartDate() {
    	return startDate;
    }
    
    public void setEndDate(String endDate) {
    	this.endDate = endDate;
    }
    
    public String getEndDate() {
    	return endDate;
    }
    
    public void setRating(double rating) {
    	this.rating = rating;
    }
    
    public double getRating() {
    	return rating;
    }
    
    public void setConsumedHours(int consumedHours) {
    	this.consumedHours = consumedHours;
    }
    
    public int getConsumedHours() {
    	return consumedHours;
    }
    
    public void setConsumedDays(int consumedDays) {
    	this.consumedDays = consumedDays;
    }
    
    public int getConsumedDays() {
    	return consumedDays;
    }
    
    public void setHasEnded(boolean hasEnded) {
    	this.hasEnded = hasEnded;
    }
    
    public boolean getHasEnded() {
    	return hasEnded;
    }
    
}
