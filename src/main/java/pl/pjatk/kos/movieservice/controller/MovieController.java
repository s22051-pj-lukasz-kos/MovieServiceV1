package pl.pjatk.kos.movieservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.kos.movieservice.model.Movie;
import pl.pjatk.kos.movieservice.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/home")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        return ResponseEntity.of(movieService.getMovieById(id));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> setNewMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.setNewMovie(movie));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable int id) {
        return ResponseEntity.of(movieService.updateMovie(movie, id));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/exception")
    public ResponseEntity<String> exception() {
        throw new RuntimeException("Testing RestControllerAdvice");
    }

}
