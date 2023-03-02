package cscd212tests.lab2;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cscd212classes.lab2.Movie;
import cscd212classes.lab2.MovieStudio;
import cscd212comparators.lab2.MajorStudioUnitComparator;
import cscd212comparators.lab2.MovieRunningTimeComparator;
import cscd212methods.lab2.CSCD212Lab2Methods;
import cscd212utils.fileutils.FileUtils;

class MainTest {
	private ByteArrayOutputStream bos;
	private PrintStream originalOut;
	private ArrayList<Movie> theMovies;

	@BeforeEach
	public void init() throws FileNotFoundException {

		Scanner fin = null;

		File inputFile = FileUtils.openInputFile("movies.txt");
		fin = new Scanner(inputFile);

		theMovies = new ArrayList<Movie>();
		CSCD212Lab2Methods.fillArrayList(fin, theMovies);
		originalOut = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

	}

	@AfterEach
	public void teardown() {
		System.setOut(originalOut);
		theMovies = null;

	}

	/**
	 * Main method tests
	 * 
	 * These tests verify that main prints the correct output.
	 */

	@Test
	public void testNaturalOrder() {
		Collections.sort(theMovies);
		for (int x = 0; x < theMovies.size(); x++)
			System.out.print(theMovies.get(x) + "\n");
		assertEquals("Movie Studio: Universal Pictures\n" + "Movie Name: Running Man\n" + "Running Time: 101\n"
				+ "Movie Studio: Paramount Pictures\n" + "Movie Name: Universal Soldier\n" + "Running Time: 91\n",
				bos.toString());
	}

	@Test
	public void testTotalOrderRunningTime() {
		Collections.sort(theMovies, new MovieRunningTimeComparator());
		for (int x = 0; x < theMovies.size(); x++)
			System.out.print(theMovies.get(x) + "\n");
		assertEquals(
				"Movie Studio: Paramount Pictures\n" + "Movie Name: Universal Soldier\n" + "Running Time: 91\n"
						+ "Movie Studio: Universal Pictures\n" + "Movie Name: Running Man\n" + "Running Time: 101\n",
				bos.toString());
	}

	@Test
	public void testTotalOrderMajorStudio() {
		Collections.sort(theMovies, new MajorStudioUnitComparator());
		for (int x = 0; x < theMovies.size(); x++)
			System.out.print(theMovies.get(x) + "\n");
		assertEquals(
				"Movie Studio: Paramount Pictures\n" + "Movie Name: Universal Soldier\n" + "Running Time: 91\n"
						+ "Movie Studio: Universal Pictures\n" + "Movie Name: Running Man\n" + "Running Time: 101\n",
				bos.toString());
	}

	@Test
	public void testBuildStudio() {
		MovieStudio test = new MovieStudio("Test Studio", "Test Owner", "Test Unit");
		assertEquals("Test Unit",test.toString());

	}
	
	@Test
	public void testBuildStudioNullUnit() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			new MovieStudio("Test Studio", "Test Owner", null);
		});
		
		assertEquals(exception.getMessage(), "Bad Parameter Movie Studio Constructor");
	}
	
	@Test
	public void testBuildStudioEmptyUnit() {
		String we = new String(""); // will fail we == "" and pass  we.isEmpty()
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			new MovieStudio("Test Studio", "Test Owner", we);
		});
		
		assertEquals(exception.getMessage(), "Bad Parameter Movie Studio Constructor");
	}
}
