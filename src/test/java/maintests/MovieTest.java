package maintests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nnc.moviediary.service.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/META-INF/spring/applicationContext-bootstrap.xml")
public class MovieTest {

	@Autowired
	private MovieService movieService;

	
	
	
	@Test
	public void listMovies() {

	}

}
