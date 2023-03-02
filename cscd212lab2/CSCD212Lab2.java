package cscd212lab2;

import java.io.*;
import java.util.*;
import cscd212classes.lab2.*;
import cscd212methods.lab2.*;
import cscd212comparators.lab2.*;
import cscd212utils.fileutils.FileUtils;


/**
 * CSCD212Lab1 is the provided testing file that contains main. There will also be a JUnit testing file you can uese.
 *  You will not change this file in any fashion.
 * <br>You will not write any other methods then those specified in the API
 * <br>NOTE: All parameters passed to methods will be final. You must enforce all preconditions
 * <br>NOTE: I provided a jar file with the file methods. Don't unzip the jar just add it to the 
 * buildpath. The only thing in the jar file is .class files.
 */
public class CSCD212Lab2
{
   /**
    * The main method used for testing your code and program
    * @param args Representing the array of Strings being passed in
    * @throws Exception on the method header to quiet the compiler for the file handling
    */
   public static void main(final String [] args)throws Exception
   {     
      int choice = 0;  
      Scanner kb = new Scanner(System.in), fin = null;
      
      File inputFile = FileUtils.openInputFile(kb);     
 
      fin = new Scanner(inputFile);
      
      ArrayList<Movie> theMovies = new ArrayList<Movie>();
      CSCD212Lab2Methods.fillArrayList(fin, theMovies); 
      fin.close();
      
      do
      {
         
         choice = CSCD212Lab2Methods.menu(kb);
         
         if(choice == 1)
            CSCD212Lab2Methods.printMovies(System.out, theMovies);
            
         else if(choice == 2)
            Collections.sort(theMovies);
            
         else if(choice == 3)
            Collections.sort(theMovies, new MovieRunningTimeComparator());
         
         else if(choice == 4)
             Collections.sort(theMovies, new MajorStudioUnitComparator());
            
         else if(choice == 5)
         {
            Movie toAdd = CSCD212Lab2Methods.buildMovie(kb);
            int res = theMovies.indexOf(toAdd);
            if(res > -1)
               System.out.println("Movie found at index " + res);
            else
               System.out.println("That movie was not found");
            
         }    
         
         else if(choice == 6)
         {
            Movie toAdd = CSCD212Lab2Methods.buildMovie(kb);
            theMovies.add(toAdd);
            theMovies.trimToSize();
         }      
            
         else
            System.out.println("Good Bye");
      
      }while(choice != 7);
      
      kb.close();
   
   }// end main


}// end class