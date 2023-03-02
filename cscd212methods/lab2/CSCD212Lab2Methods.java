package cscd212methods.lab2;

import java.io.*;
import java.util.*;
import cscd212enums.lab2.*;
import cscd212classes.lab2.*;

/**
 * This is the methods class for user interaction.
* <br>All paramaters must be passed as final
* <br>All preconditions will be enforced
* <br>All postconditions will be enforced
*/
public class CSCD212Lab2Methods
{
   /**
    * The fill array list method reads a movie one line at a time from the file and creates a movie object
    * <br>Look at movies.txt file the information about a movie on separate lines
    * @param fin Reprsenting a Scanner object that has wrappered a File object
    * @param theMovies Representing an array list of movie objects
    * @throws IllegalArgumentException if the scanner or arraylist are null with the message Bad Params fillArrayList
    * <br>NOTE: The scanner input buffer is left empty and the array list is trimmed to size
    * <br>Below is the file order (movies.txt)
    * <br>movie name
    * <br>movie genre
    * <br>movie studio name
    * <br>movie studio owner
    * <br>major studio unit
    * <br>movie running time
    */
   public static void fillArrayList(final Scanner fin, final ArrayList<Movie> theMovies)
   {
	   if (fin == null || theMovies == null) throw new IllegalArgumentException("Bad Params fillArrayList");
	   
	   //Ends loop when there isn't anything left to read in the next line
	   while (fin.hasNextLine())
	   {
		   String movieName = new String(fin.nextLine());
		   String movieGenre = new String(fin.nextLine());
		   String movieStudioName = new String(fin.nextLine());
		   String movieStudioOwner = new String(fin.nextLine());
		   String majorStudioUnit = new String(fin.nextLine());
		   String movieRunningTime = new String(fin.nextLine());
		   
		   theMovies.add(new Movie(movieName, movieGenre, movieStudioName, movieStudioOwner, majorStudioUnit, Integer.parseInt(movieRunningTime)));
		   
	   }
   }
   
   /**
    * The build movie method prompts the user to enter movie information, and builds the appropriate movie object
    * You must build a movie studio object before you build a movie object. The movie studio object will be passed to
    * the constructor to build a movie object.
    * @param kb Representing a valid Scanner object
    * @return Movie Representing a fully created movie object
    * @throws IllegalArgumentException if kb is null with the string Bad Param build Movie
    * <br>POSTCONDITION: The input buffer is left empty
    */      
   public static Movie buildMovie(final Scanner kb)
   {
	   if (kb == null) throw new IllegalArgumentException("Bad Param build Movie");
	   
	   String movieStudioName, movieStudioOwner, majorStudioUnit, movieName, movieRunningTime, movieGenre;
	   
	   System.out.println("Please enter the movie studio name ");
	   movieStudioName = kb.nextLine();
	   System.out.println("Please enter the movie studio owner ");
	   movieStudioOwner = kb.nextLine();
	   System.out.println("Please enter the major studio unit name ");
	   majorStudioUnit = kb.nextLine();
	   System.out.println("Please enter the movie name ");
	   movieName = kb.nextLine();
	   System.out.println("Please enter the movie running time ");
	   movieRunningTime = kb.nextLine();
	   System.out.println("Please enter the movie genre (Romantic Comedy/Comedy/Horror/Action) ");
	   movieGenre = kb.nextLine();
	   
	   return new Movie(movieName, findGenre(movieGenre), movieStudioName, movieStudioOwner, majorStudioUnit, Integer.parseInt(movieRunningTime));
   }
   
   /** 
    * This private method receives a string and returns the appropriate matching string of the enumerated type
    * @param genre Representing the string to be converted to an enumerated constant
    * @return String Representing the constant value as a capitalized String. 
    * <br>For example the user enters action the method would return AC.
    * @throws IllegalArgumentException if the string passed in is null or empty
    * @throws NoSuchElementException if the genre string is not found in the array of MovieGenre -- uses values
    */    
   private static String findGenre(final String genre)
   {
	   if (genre == null || genre.isEmpty()) throw new IllegalArgumentException("findGenre Bad Params");
	   
      MovieGenre[] movie = MovieGenre.values();
      
      //for each, iterates through every part. We want to find the genre passed in and return it
      for (MovieGenre object : movie)
      {
    	  if (object.getMovieGenreType().toUpperCase().equals(genre.trim().toUpperCase()));
    	  {
    		  return object.name();
    	  }
      }
      throw new NoSuchElementException("Genre is not found in movieGenre");
   }
   
   /**
    * The menu method written by me you don't have to write anything
    * @param kb Representing a valid scanner object
    * @return int Representing a menu choice in range
    * @throws IllegalArgumentException if kb is null
    * <br>POSTCONDITION: Leaves the input buffer empty
    */
   public static int menu(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("Bad Param menu");
         
      int choice;
         
      do
      {
         System.out.println("Please choose from the following");
         System.out.println("1) Print movies to the screen");
         System.out.println("2) Order the movies based on natural order");
         System.out.println("3) Order the movies based on the total order of running time");
         System.out.println("4) Order the movies based on the total order of major studio unit");
         System.out.println("5) Build a movie and determine if the movie is in the array list");
         System.out.println("6) Build a movie and add it into the array list");
         System.out.println("7) Quit");
      
         System.out.print("Choice --> ");
         choice = Integer.parseInt(kb.nextLine());
      
      }while(choice < 1 || choice > 7);
      
      return choice; 
   
   }// end menu
  
   /** 
    * Print movies is provided by me nothing for you to write
    * @param fout Representing a PrintStream object
    * @param theMovies Representing the array list of movies
    * @throws IllegalArgumentException if fout is null or the movies is null
    */ 
   public static void printMovies(PrintStream fout, ArrayList<Movie> theMovies)
   {
      if(fout == null || theMovies == null)
       throw new IllegalArgumentException("Bad param printMovies in Methods class");
  
      for(int x = 0; x < theMovies.size(); x++)
         fout.println(theMovies.get(x) + "\n");
   }// end printMovies
   
   /**
    * Provided by me and Java for free
    */
   public CSCD212Lab2Methods(){} 


}// end class