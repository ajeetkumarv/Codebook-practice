package practice.stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class MovieTest {

	private List<Movie> movies = new ArrayList<>();

	@BeforeAll
	public void setup() {
		Movie movie1 = new Movie(10, "Sikandar", Movie.Genre.ACTION, "Hindi",
				List.of("Summy Deol", "Dharmendra paji", "Juhi chawla"),
				List.of("English"),
				Duration.ofMinutes(120));

		Movie movie2 = new Movie(0, "Sikandar", Movie.Genre.ACTION, "Hindi",
				List.of("Summy Deol", "Dharmendra paji", "Juhi chawla"),
				List.of("English"),
				Duration.ofMinutes(120));

	}

	@Test
	public void test1() {
		//if Movie is @NoArgsConstructor(force = true) then final field will be of it's default value
		Movie movie = new Movie("Sikandar", "english");
		System.out.println(movie.genre);
	}

	@Test
	public void testAnyMatch() {}

	@Test
	public void testNoneMatch() {}

	@Test
	public void testAllMatch() {}


	@Test
	public void testGetTotalLikes() {
		//get total likes of all movies
	}

	@Test
	public void testSummarizingInt() {
		//get summary of likes like min max avg
	}

	@Test
	public void testJoiningTitle() {
		//comma separated list of titles
	}

	@Test
	public void testGenreAndListOfMovies() {
	}

	@Test
	public void testGenreAndLinkedListOfMovies() {
	}

	@Test
	public void testGenreAndSetOfMovies() {
	}

	@Test
	public void testGenreAndCountOfMovies() {
	}

	@Test
	public void testGenreAndCommaSeparatedTitles() {
	}
}