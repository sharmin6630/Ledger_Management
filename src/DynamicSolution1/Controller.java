package DynamicSolution1;

import java.util.HashMap;

public class Controller {
	private Consumable obj;
	View view = new View();
	static int days = 0, hours = 0;
	
	private HashMap <String, Consumable> consumableList = new HashMap <String, Consumable > ();
	
	public void addConsumable(String type, String name, String startDate, String endDate,
			double rating,int consumedHours, int consumedDays, boolean hasEnded) {
		if(searchConsumable(name) == true) {
			System.out.println("\n**Consumable already exists.");
		}
		consumableList.put(name, new Consumable(type, name, startDate, endDate, rating,
	    		consumedHours, consumedDays, hasEnded));
		System.out.println("\n**Consumable Added.");
		
	}
	
	public boolean searchConsumable(String name) {
		if(consumableList.containsKey(name)) {
			return true;
		}
		else {
			return false;
		}
	} 
	
	public boolean checkEndDate(String name) {
		obj = consumableList.get(name);
		return obj.getHasEnded();
	}
	
	public void updateConsumable(String name, int consumedHours, int consumedDays, 
			double rating, String endDate, boolean hasEnded) {
		obj = consumableList.get(name);
		obj.consumedHours = obj.getConsumedHours() + consumedHours;
		obj.consumedDays = obj.getConsumedDays() + consumedDays;
		obj.hasEnded = hasEnded;
		obj.endDate = endDate;
		consumableList.replace(name, obj);
		System.out.println("\n**Successfully Updated " + name);
	}
	
	public void removeConsumable(String name) {
		obj = consumableList.get(name);
		days += obj.getConsumedDays();
		hours += obj.getConsumedHours();
		consumableList.remove(name);
		System.out.println("\n**Successfully Deleted "+ name);
	}
	
	public void showIndividual(String name) {
		obj = consumableList.get(name);
		view.printFirstFields();
		view.printConsumable(obj.getType(), obj.getName(), obj.getStartDate(), obj.getEndDate(), 
				obj.getRating(), obj.getConsumedHours(), obj.getConsumedDays());
	}
	
	public void showType(String type) {
		view.printFirstFields();
		for(Consumable x: consumableList.values()) {
			if(x.getType() == type) {
				view.printConsumable(x.getType(), x.getName(), x.getStartDate(), 
						x.getEndDate(), x.getRating(), x.getConsumedHours(), 
						x.getConsumedDays());
			}
		}
	}
	
	public void showAll() {
		view.printFirstFields();
		for(Consumable x: consumableList.values()){
			view.printConsumable(x.getType(), x.getName(), x.getStartDate(), x.getEndDate(), 
					x.getRating(), x.getConsumedHours(), x.getConsumedDays());
		}
	}
	
	public void getTotalHours() {
		int totalHours = 0, bookHours = 0, seriesHours = 0, movieHours = 0;
		for(Consumable x: consumableList.values()) {
			if(x.getType() == "Book")
				bookHours += x.getConsumedHours();
			else if(x.getType() == "Series")
				seriesHours += x.getConsumedHours();
			else 
				movieHours += x.getConsumedHours();
		}
		totalHours = hours + bookHours + seriesHours + movieHours;
		view.printOverallHours(totalHours, bookHours, seriesHours, movieHours);
	}
	
	public void getTotalDays() {
		int bookDays  = 0, totalDays = 0, seriesDays = 0, movieDays = 0;
		for(Consumable x: consumableList.values()) {
			if(x.getType() == "Book")
				bookDays += x.getConsumedDays();
			else if(x.getType() == "Series")
				seriesDays += x.getConsumedDays();
			else 
				movieDays += x.getConsumedDays();
		}
		totalDays = days + bookDays + seriesDays + movieDays;
		view.printOverallDays(totalDays, bookDays, seriesDays, movieDays);
	}
	
	public void getTotalRatingCnt() {
		double avgRating = 0, bookRating = 0, seriesRating = 0, movieRating = 0;
		int totalConsumable = 0, totalBook = 0, totalSeries = 0, totalMovies = 0;
		for(Consumable x: consumableList.values()) {
			if(x.getType() == "Book") {
				bookRating += x.getRating();
				totalBook += 1;
			}
			else if(x.getType() == "Series") {
				seriesRating += x.getRating();
				totalSeries += 1;
			}
			else {
				movieRating += x.getRating();
				totalMovies += 1;
			}
			totalConsumable += 1;
		}
		
		avgRating = ((bookRating + seriesRating + movieRating) * 1.0) / totalConsumable;
		bookRating = bookRating / totalBook;
		movieRating = movieRating / totalMovies;
		seriesRating = seriesRating / totalSeries;
		
		view.printOverallRating(avgRating, bookRating, seriesRating, movieRating);
		view.printOverallConsumable(totalConsumable, totalBook, totalSeries, totalMovies);
	}
	
	public void showOverall() {
		
		getTotalHours();
		getTotalDays();
		getTotalRatingCnt();
		
	}
	
	public void addTenConsumable() {
		addConsumable("Series", "Stranger Things", "2018-02-04", "2020-06-08", 8.5, 24, 2, true);
		addConsumable("Series", "West World", "2018-02-04", "2020-06-08", 8.5, 24, 2, true);
		addConsumable("Series", "Friends", "2018-02-04", "2020-06-08", 8.5, 24, 2, true);
		addConsumable("Series", "Attack on titan", "2018-02-04", "2020-06-08", 8.5, 24, 2, true);
		addConsumable("Book", "The Alchemist", "2018-02-04", "", 8.5, 5, 1, false);
		addConsumable("Book", "Gone Girl", "2018-02-04", "2018-02-04", 8.5, 5, 1, true);
		addConsumable("Book", "Lord of the Rings", "2018-02-04", "2018-03-04", 9, 5, 1, true);
		updateConsumable("The Alchemist", 5, 1, 8.5, "2018-02-0", true);
		addConsumable("Movie", "Fight Club", "2012-02-04", "2012-02-05", 9, 3, 0, true);
		addConsumable("Movie", "Parasite", "2019-02-04", "2019-02-04", 9, 3, 1, true);
		addConsumable("Movie", "Your Name", "2019-02-04", "2019-02-04", 9, 3, 1, true);
	}
	
	
}
