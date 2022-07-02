package pl.pjatk.kos.movieservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.kos.movieservice.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
