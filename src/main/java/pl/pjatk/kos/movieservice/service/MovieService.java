package pl.pjatk.kos.movieservice.service;

import org.springframework.stereotype.Service;
import pl.pjatk.kos.movieservice.model.Movie;
import pl.pjatk.kos.movieservice.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(int id) {
        return movieRepository.findById(id);
    }

    public Movie setNewMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> updateMovie(Movie movie, int id) {
        Optional<Movie> movieById = getMovieById(id);

        return movieById.map(m -> movieRepository.save(new Movie(id, movie.getTitle(), movie.getGenre(), movie.getYear(), movie.getDirector())));
    }

    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }
}
