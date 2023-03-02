package cscd212comparators.lab2;

import cscd212classes.lab2.Movie;
import java.util.Comparator;

//"<>" must contain a class name
public class MovieRunningTimeComparator implements Comparator<Movie>
{
	/*
	 * public MovieRunningComparator()
	 * written by Java
	 */
	
	@Override
	public int compare(final Movie m1, final Movie m2)
	{
		if (m1 == null || m2 == null) throw new IllegalArgumentException("Bad Params in MovieRunningTimeComparator");
		
		return m1.getMovieRunningTime() - m2.getMovieRunningTime();
	}
}
