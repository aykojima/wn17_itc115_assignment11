package murach.movies;

import java.util.ArrayList;
//import murach.movies.MovieDB;
//import java.util.List;
import java.util.Scanner;

public class MovieApp {
	private static Scanner sc = new Scanner(System.in);
	static MovieDB moviedb = new MovieDB();
	public static void main (String args[]){
		//greet the user
		displayLine("Welcome to the Movie Lister");
		displayLine("There are 100 movies in the list.");
		moviedb.getAllMovies();
		String choice = "y";
		String category = "";
		while(choice.equalsIgnoreCase("y")){
			do{//test to see if the user input is valid
				category = getString("What category are you interested in?");
			}while(!isValid(category));
			//Display movie lists
			displayLine(" ");
			ArrayList<Movie> movies = moviedb.getMovies(category);
			for(Movie m : movies){
				displayLine(m.getTitle());
			}
			
			//ask the user to continue
			displayLine(" ");
			choice = getString("Continue? (y/n): ");
		}//end of while loop
		sc.close();
	}
	
	
	 public static boolean isValid(String userInput){
		 if(userInput.equalsIgnoreCase("animated") || userInput.equalsIgnoreCase("drama") ||
				 userInput.equalsIgnoreCase("horror") || userInput.equalsIgnoreCase("musical") ||
				 userInput.equalsIgnoreCase("scifi") ){
			 return true;
		 }else{
			 displayLine("Please select from animated, drama, horor, musical, and scifi");
			 return false;
		 }
	 }
	 
	 
	 public static void displayLine() {
	        System.out.println("Welcome to the Account Calculator");
	    }

	    public static void displayLine(String s) {
	        System.out.println(s);
	    }

	    public static String getString(String prompt) {
	        System.out.print(prompt);
	        String s = sc.nextLine();
	        return s;
	    }

	  /*  public static int getInt(String prompt) {
	        int i = 0;
	        while (true) {
	            System.out.print(prompt);
	            try {
	                i = Integer.parseInt(sc.nextLine());
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Error! Invalid integer. Try again.");
	            }
	        }
	        return i;
	    }

	    public static double getDouble(String prompt) {
	        double d = 0;
	        while (true) {
	            System.out.print(prompt);
	            try {
	                d = Double.parseDouble(sc.nextLine());
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Error! Invalid decimal. Try again.");
	            }
	        }
	        return d;
	    } */
}
