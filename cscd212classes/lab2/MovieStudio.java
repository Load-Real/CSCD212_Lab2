package cscd212classes.lab2;

public class MovieStudio 
{
	private String movieStudioName;
	private String movieStudioOwner;
	private String majorStudioUnit;
	
	public MovieStudio(final String movieStudioName, final String movieStudioOwner, final String majorStudioUnit)
	{
		if (movieStudioName == null || movieStudioName.isEmpty()) throw new IllegalArgumentException("Bad Parameter Movie Studio Constructor");
		if (movieStudioOwner == null || movieStudioOwner.isEmpty()) throw new IllegalArgumentException("Bad Parameter Movie Studio Constructor");
		if (majorStudioUnit == null || majorStudioUnit.isEmpty()) throw new IllegalArgumentException("Bad Parameter Movie Studio Constructor");
		
		
		this.movieStudioName = movieStudioName;
		this.movieStudioOwner = movieStudioOwner;
		this.majorStudioUnit = majorStudioUnit;
		
	}
	
	public MovieStudio(final MovieStudio movieStudio)
	{
		if (movieStudio == null) throw new IllegalArgumentException("Bad Parameter Movie Studio Constructor");
		//create a new object (using "new" keyword, rather than blindly assigning)
		this.movieStudioName = movieStudio.movieStudioName;
		
	}
	
	public String getMovieStudioName()
	{
		return this.movieStudioName;
	}
	
	public String getMovieStudioOwner()
	{
		return this.movieStudioOwner;
	}
	
	public String getMajorStudioUnit()
	{
		return this.majorStudioUnit;
	}
	
	public void setMovieStudioOwner(final String movieStudioOwner)
	{
		if (movieStudioOwner == null || movieStudioOwner.isEmpty()) throw new IllegalArgumentException("Bad Param setMovieStudioOwner");
		
		this.movieStudioOwner = movieStudioOwner;
	}
	
	@Override
	public boolean equals(final Object obj)
	{
		if (obj == null) return false;
		if (obj == this) return true;
		if (!(obj instanceof MovieStudio)) return false;
		
		//cast from Object to MovieStudio object and check all class level vars for equality
		MovieStudio movieStudio = (MovieStudio) obj;
		if(this.movieStudioName.equals(movieStudio.movieStudioName))
			if(this.movieStudioOwner.equals(movieStudio.movieStudioOwner))
				if(this.majorStudioUnit.equals(movieStudio.majorStudioUnit))
					return true;
		return false;
			
	}
	
	@Override
	public int hashCode()
	{
		return this.movieStudioName.hashCode() + this.movieStudioOwner.hashCode() + this.majorStudioUnit.hashCode();
	}
	
	@Override
	public String toString()
	{
		return this.majorStudioUnit;
	}
}
