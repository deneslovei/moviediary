package maintests;

import java.util.List;

import org.junit.Test;
import org.nnc.moviediary.domain.entities.Movie;
import org.nnc.moviediary.service.implementations.ServiceUtil;

public class SmallTests {

	@Test
	public void listMovies() {
		String[] ids = new String[5];
		for (int i = 0; i < 5; ++i) {
			ids[i] = i + "";
		}
		List<Movie> movies = ServiceUtil.convertIdsToEntitiesToSave(ids, Movie.class);
		System.out.println(movies.size());
	}
}
