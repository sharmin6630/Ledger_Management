package DynamicSolution1;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class StartProgram{
	
	Scanner sc = new Scanner(System.in);
	Controller obj = new Controller();
	View view = new View();
	int choice;
	String type;
    String name = "";
    String startDate = "";
    String endDate = "";
    double rating = 0.0;
    int consumedHours = 0;
    int consumedDays = 0;
    boolean hasEnded = false;
    boolean initialized = false;
	
	void start() {
		if(!initialized) {
			obj.addTenConsumable();
			initialized = true;
		}
		view.startInstructions();
		
		System.out.print("\nEnter an option type: ");
		choice  = checkOption(sc.nextInt());
		
		switch(choice) {
			case 1:
				System.out.print("\nEnter 1 to add a Book, 2 for Series or 3 for Movie: ");
				type = checkType(sc.nextInt());
				
				System.out.print("\nEnter "+ type + "Name: ");
				sc.nextLine();
				name = sc.nextLine();
				//System.out.println(name);
				
				System.out.print("\nEnter Starting Date (YYYY-MM-DD) / 0 to ignore: ");
				startDate = checkDate(sc.nextLine());
				//System.out.println(startDate);
				
				System.out.print("\nEnter Ending Date (YYYY-MM-DD) / 0 to ignore: ");
				endDate = checkDate(sc.nextLine());
				
				if(endDate != "0") {
					hasEnded = true;
				}
				
				System.out.print("\nEnter Rating (0 - 10) / 0 to Ignore: ");
				rating = checkRating(sc.nextDouble());
				
				System.out.print("\nEnter Consumption time in hours / 0 to Ignore: ");
				consumedHours = sc.nextInt();
				
				System.out.print("\nEnter Consumption time in days / 0 to Ignore: ");
				consumedDays = sc.nextInt();
				
				obj.addConsumable(type, name, startDate, endDate, rating,
			    		consumedHours, consumedDays, hasEnded);
				break;
				
			case 2:
				System.out.print("\nEnter name of the consumable to edit: ");
				sc.nextLine();
				name = sc.nextLine();
				if(obj.searchConsumable(name) == false) {
					System.out.println("\nConsumable does not exist.");
					System.exit(0);
				}
				else if(obj.checkEndDate(name) == true) {
					System.out.print("\nYou can not modify a consumable with exiting Ending Date.");
					break;
				}
				
				System.out.print("\nAdd Consumption time of "+ name + " in hours / 0 to Ignore: ");
				consumedHours = sc.nextInt();
				
				System.out.print("\nAdd Consumption time of "+ name + " in days / 0 to Ignore: ");
				consumedDays = sc.nextInt();
				
				System.out.print("\nEdit Rating of "+ name + "(0 - 10) / 0 to Ignore: ");
				rating = sc.nextDouble();
				
				System.out.print("\nAdd Ending date of "+ name + " (YYYY-MM-DD) / 0 to Ignore: ");
				sc.nextLine();
				endDate = checkDate(sc.nextLine());
				if(endDate != "0") {
					hasEnded = true;
				}
				obj.updateConsumable(name, consumedHours, consumedDays, rating, endDate, hasEnded);
				break;
			
			case 3:
				System.out.print("\nEnter name of the consumable to delete: ");
				sc.nextLine();
				name = sc.nextLine();
				if(obj.searchConsumable(name) == false) {
					System.out.println("\nConsumable does not exist.");
					break;
				}
				obj.removeConsumable(name);
				break;
				
			case 4: 
				System.out.print("\nEnter 1 to details of a all Consumable or 2 to see an specific type Consumable: ");
				choice = sc.nextInt();
				if(choice == 1) {
					obj.showAll();
					break;
				}
				if(choice == 2) {
					System.out.print("\nEnter 1 for details of Book, 2 for details of Series or 3 for details of Movies: ");
					choice = sc.nextInt();
					if(choice == 1) {
						obj.showType("Book");
					}
					
					else if(choice == 2) {
						obj.showType("Series");
					}
					else {
						obj.showType("Movie");
					}
					System.out.print("\nEnter the name of the consumable to see individually: ");
					sc.nextLine();
					name = sc.nextLine();
					if(obj.searchConsumable(name) == false) {
						System.out.println("\nConsumable does not exist.");
						break;
					}
					obj.showIndividual(name);
				}
				break;
			
			case 5:
				obj.showOverall();
				break;
			default:
				break;
		}
	}
	
	private int checkOption(int option) {
		if(option >= 1 && option <= 5)
            return option;
        else {
            System.out.println("**Input is invalid. By default option 1 is selcted for adding a Consumable.");
            return 1;
        }
		
	}
	
	private String checkType(int option) {
		if(option == 1) {
			return "Book";
		}
		else if(option == 2) {
			return "Series";
		}
		else if(option == 3) {
			return "Movie";
		}
        else {
            System.out.println("**Input is invalid. By default Book is selcted.");
            return "Book";
        }
		
	}
	
	private String checkDate(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return "0";
        }
        return dateStr;
    }
	
	private double checkRating(double rating) {
		if(rating >= 0.0 && rating <= 10.0) {
			return rating;
		}
		else {
			System.out.println("**Rating is not valid. By default 0.0 is set.");
			return 0.0;
		}
	}
	
	
}
