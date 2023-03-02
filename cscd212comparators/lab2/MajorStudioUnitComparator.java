package cscd212comparators.lab2;
import java.util.Comparator;

import cscd212classes.lab2.Movie;

public class MajorStudioUnitComparator implements Comparator<Movie>
{
	/*
	 * Public MajorStudioUnitComparator()
	 * is provided by Java
	 */
	
	@Override
	public int compare(final Movie m1, final Movie m2)
	{
		if (m1 == null || m2 == null) throw new IllegalArgumentException("Bad Params in MajorStudioUnitComparator");
		
		return m1.getMovieStudio().getMajorStudioUnit().compareTo(m2.getMovieStudio().getMajorStudioUnit());
	}
}
