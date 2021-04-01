package DynamicSolution1;

public class View {
	final String rowDivide = "-------------------------------------------------------"
			+ "---------------------------"
			+ "----------------------------------------------";
	final String rowDivideSmall = "-------------------------------------------------------";
	
	public void startInstructions() {
		System.out.print("\n                          Consumable Ledger                        "
				+ "\n|*******************************************************************|"
				+ "\n|Type 1: to add Consumable type                                     |"
				+ "\n|___________________________________________________________________|"
				+ "\n|Type 2: to edit a consumable                                       |"
				+ "\n|___________________________________________________________________|"
				+ "\n|Type 3: to delete a consumable                                     |"
				+ "\n|___________________________________________________________________|"
				+ "\n|Type 4: to see the list of consumables and individually            |"
				+ "\n|___________________________________________________________________|"
        		+ "\n|Type 5: to see overall informaton                                  |"
				+ "\n|___________________________________________________________________|"
        		+ "\n                                                                    ");
	}
	
	public void printFirstFields() {
		System.out.println(rowDivide);
		System.out.format("|%-7s|%-40s|%-15s|%-15s|%-15s|%-14s|%-14s|%n",
	    		"Type", "Name", "Starting Date", "Ending Date",
	    		"Rating", "Consumed Hours", "Consumed Days");
		System.out.println(rowDivide);
	}
	
	public void printConsumable(String type, String name, String startDate, String endDate,
	    		String rating, int consumedHours, int consumedDays) {
		System.out.format("|%-7s|%-40s|%-15s|%-15s|%-15s|%-14s|%-14s|%n",
	    		type, name, startDate, endDate,
	    		rating, Integer.toString(consumedHours), Integer.toString(consumedDays));
		System.out.println(rowDivide);
	}
	
	public void printOverallHours(int totalHours, int bookHours, int seriesHours, int movieHours) {
		System.out.println(rowDivideSmall);
		System.out.println("The total consumption time in hours across all types: "+ totalHours);
		System.out.println(rowDivideSmall);
		System.out.println("Individual consumption time in hours of each type: ");
		System.out.println("Books: "+ bookHours);
		System.out.println("Series: "+ seriesHours);
		System.out.println("Movies: "+ movieHours);
	}
	
	public void printOverallDays(int totalDays, int bookDays, int seriesDays, int movieDays) {
		System.out.println(rowDivideSmall);
		System.out.println("The total consumption time in Days across all types: "+ totalDays);
		System.out.println(rowDivideSmall);
		System.out.println("Individual consumption time in Days of each type: ");
		System.out.println("Books: "+ bookDays);
		System.out.println("Series: "+ seriesDays);
		System.out.println("Movies: "+ movieDays);
	}
	
	public void printOverallRating(double avgRating, double bookRating, 
			double seriesRating, double movieRating) {
		System.out.println(rowDivideSmall);
		System.out.println("Average Rating across all types: "+ avgRating);
		System.out.println(rowDivideSmall);
		System.out.println("Avarage Rating of each type: ");
		System.out.println("Books: "+ bookRating);
		System.out.println("Series: "+ seriesRating);
		System.out.println("Movies: "+ movieRating);
	}
	
	public void printOverallConsumable(int totalConsumable, int totalBook, int totalSeries, int totalMovies) {
		System.out.println(rowDivideSmall);
		System.out.println("The total numebr of consumables across all types: "+ totalConsumable);
		System.out.println(rowDivideSmall);
		System.out.println("Individual number of consumable of each type: ");
		System.out.println("Books: "+ totalBook);
		System.out.println("Series: "+ totalSeries);
		System.out.println("Movies: "+ totalMovies);
		System.out.println(rowDivideSmall);
	}
	
}
