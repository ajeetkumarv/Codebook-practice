package practice.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MovieTest {

	private List<Movie> movies = new ArrayList<>();

	@BeforeAll
	public void setup() {
		populateMovies();
	}

	@Test
	public void test1() {
		//if Movie is @NoArgsConstructor(force = true) then final field will be of it's default value
		Movie movie = new Movie("Sikandar", "english");
		System.out.println(movie.genre);
	}

	@Test
	public void testAnyMatch() {

	}

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

	private void populateMovies() {
		Movie movie1 = new Movie(10, "Sikandar", Movie.Genre.ACTION, "Hindi",
				List.of("Summy Deol", "Dharmendra paji", "Juhi chawla"),
				List.of("English"),
				Duration.ofMinutes(120));

		Movie movie2 = new Movie(129, "The 400 Blows", Movie.Genre.THRILLER, "English",
				List.of("Jean Pierre", "Albert Remy", "Claire Maurier"),
				List.of("Dutch", "Spanish"),
				Duration.ofMinutes(100));

		Movie movie3 = new Movie(0, "Paradise", Movie.Genre.ACTION, "German",
				List.of("Daniel", "tina"),
				List.of("Dutch", "Spanish"),
				Duration.ofMinutes(135));

		Movie movie4 = new Movie(1, "Godforsaken", Movie.Genre.HORROR, "Dutch",
				List.of("Egbert Jan Weeber", "Tygo", "Angela", "Schijf", "Franken", "Krake"),
				List.of(),
				Duration.ofMinutes(70));

		Movie movie5 = new Movie(55, "The 400 Blows", Movie.Genre.ACTION, "Telugu",
				List.of("NT Rao", "Savitri"),
				List.of("Hindi", "Tamil", "English", "Malayalam", "Kannad", "Odia", "Asammese", "Punjabi"),
				Duration.ofMinutes(90));

		Movie movie6 = new Movie(20, "Drishyam", Movie.Genre.DRAMA, "Hindi",
				List.of("Ajay devgun"),
				List.of(),
				Duration.ofMinutes(110));

		Movie movie7 = new Movie(20, "TBahubali", Movie.Genre.ACTION, "Hindi",
				List.of("Samantha"),
				List.of("Telugu", "Tamil", "Malayalam"),
				Duration.ofMinutes(150));

		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		movies.add(movie5);
		movies.add(movie6);
		movies.add(movie7);
	}
}