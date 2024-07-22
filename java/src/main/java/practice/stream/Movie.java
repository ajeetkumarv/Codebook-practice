package practice.stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Duration;
import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {

	public enum Genre {
		ACTION, COMEDY, ROMANCE, HORROR, THRILLER, DRAMA
	} // notice no semicolon here

	int likes;
	final String title;
	Genre genre;
	@NonNull
	String primaryLanguage;

	List<String> actors;
	List<String> dubLanguages;

	Duration duration;
}
