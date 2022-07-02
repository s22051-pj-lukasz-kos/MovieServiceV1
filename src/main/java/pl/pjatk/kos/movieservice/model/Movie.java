package pl.pjatk.kos.movieservice.model;

import javax.persistence.*;
import java.time.Year;
import java.util.Date;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre", columnDefinition = "enum")
    private Genre genre;

    @Column(name = "premiere_date")
    @Temporal(TemporalType.DATE)
    private Date year;

    private String director;

    public Movie() {
    }

    public Movie(int id, String title, Genre genre, Date year, String director) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.director = director;
    }

    public Movie(String title, Genre genre, Date year, String director) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
