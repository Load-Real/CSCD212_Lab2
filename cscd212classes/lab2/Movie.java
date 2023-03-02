package cscd212classes.lab2;

import cscd212enums.lab2.MovieGenre;


public class Movie implements Comparable<Movie>
{
	//Variables
	private String movieName;
	private int movieRunningTime;
	private MovieGenre movieGenre;
	private MovieStudio movieStudio;
	
	//Constructors
	public Movie(final String movieName, final String movieGenre, final String movieStudioName, final String movieStudioOwner, final String majorStudioUnit, final int movieRunningTime)
	{
		if (movieName == null || movieName.isEmpty()) throw new IllegalArgumentException("Bad Param Movie Constructor");
		if (movieGenre == null || movieGenre.isEmpty()) throw new IllegalArgumentException("Bad Param Movie Constructor");
		if (movieStudioName == null || movieStudioName.isEmpty()) throw new IllegalArgumentException("Bad Param Movie Constructor");
		if (movieStudioOwner == null || movieStudioOwner.isEmpty()) throw new IllegalArgumentException("Bad Param Movie Constructor");
		if (majorStudioUnit == null || majorStudioUnit.isEmpty()) throw new IllegalArgumentException("Bad Param Movie Constructor");
		// Figure out what I should check for here, since movieRunningTime isn't a string
		if (Integer.toString(movieRunningTime) == null || Integer.toString(movieRunningTime).isEmpty()) throw new IllegalArgumentException("Bad Param Movie Constructor");
		
		this.movieName = movieName;
		this.movieGenre = MovieGenre.valueOf(movieGenre);
		
		//this.movieStudioName = movieStudioName;
		//this.movieStudioOwner = movieStudioOwner;
		//this.majorStudioUnit = majorStudioUnit;
		
		this.movieRunningTime = movieRunningTime;
		this.movieStudio = new MovieStudio(movieStudioName, movieStudioOwner, majorStudioUnit);
	}
	
	public Movie(final String movieName, final String movieGenre, final String movieRunningTime, final MovieStudio movieStudio)
	{
		if (movieName == null || movieName.isEmpty()) throw new IllegalArgumentException("Bad Param Movie Constructor");
		if (movieGenre == null || movieGenre.isEmpty()) throw new IllegalArgumentException("Bad Param Movie Constructor");
		if (movieRunningTime == null || movieRunningTime.isEmpty()) throw new IllegalArgumentException("Bad Param Movie Constructor");
		if (movieStudio == null) throw new IllegalArgumentException("Bad Param Movie Constructor");
		
		this.movieName = movieName;
		this.movieGenre = MovieGenre.valueOf(movieGenre);
		this.movieRunningTime = Integer.parseInt(movieRunningTime);
		/* This will result in 0 points, find another way to set
		 * this.movieStudio = movieStudio;
		 */
		this.movieStudio = new MovieStudio(movieStudio);
	}
	
	//Methods
	public MovieStudio getMovieStudio()
	{
		//return MovieStudio object
		return this.movieStudio;
	}
	
	public int getMovieRunningTime()
	{
		return this.movieRunningTime;
	}
	
	@Override
	public boolean equals(final Object obj)
	{
		//RTTI - Three checks to make sure obj is of Movie type
		if (obj == null) return false;
		if (obj == this) return true;
		if (!(obj instanceof Movie)) return false;
		
		Movie movie = (Movie) obj;
		if(this.movieRunningTime == movie.movieRunningTime)
			if(this.movieName.equals(movie.movieName))
				if(this.movieStudio.equals(movie.movieStudio))
					if(this.movieGenre.equals(movie.movieGenre))
						return true;
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return movieName.hashCode() + Integer.toString(movieRunningTime).hashCode() + movieStudio.hashCode();
	}
	
	@Override
	public String toString()
	{
		//"Movie Studio: Universal Pictures\n" + "Movie Name: Running Man\n" + "Running Time: 101\n"
		return "Movie Studio: " + movieStudio + "\nMovie Name: " + movieName + "\nRunning Time: " + movieRunningTime;
	}
	
	@Override
	public int compareTo(final Movie another)
	{
		if (another == null) throw new IllegalArgumentException("Bad Param compareTo Movie");
		
		if (this.movieStudio.getMovieStudioOwner().equals(another.getMovieStudio().getMovieStudioOwner())) {
					if (this.movieName.equals(another.movieName)) {
						if (this.movieRunningTime == another.movieRunningTime) {
							return 0;
						} else {
							return this.movieRunningTime - another.movieRunningTime;
						}
					} else {
						return this.movieName.compareTo(another.movieName);
					}
		} else {
			return this.movieStudio.getMovieStudioOwner().compareTo(another.getMovieStudio().getMovieStudioOwner());
		}
	}
}
