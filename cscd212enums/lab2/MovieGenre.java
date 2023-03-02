package cscd212enums.lab2;

public enum MovieGenre
{
	RC("Romantic Comedy"), CO("Comedy"), HR("Horror"), AC("Action");
	
	private String movieGenreType;
	
	private MovieGenre(final String movieGenreType)
	{
		if (movieGenreType == null || movieGenreType.isEmpty()) throw new IllegalArgumentException("Bad String Movie Genre");
		
		this.movieGenreType = movieGenreType;
	}
	
	public String getMovieGenreType()
	{
		return this.movieGenreType;
	}
	
	@Override
	public String toString()
	{
		return movieGenreType.toString();
	}
}
