package de.hsos.kbse.movielister.jeemovielister.ui;//anpassen 


import de.hsos.kbse.movie.impl.Movie;
import de.hsos.kbse.movie.impl.MovieLister;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Uimodel implements Serializable {

    private String director;
    @Inject
    MovieLister movieLister;
    Movie[] movies;

    public Uimodel() {
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public MovieLister getMovieLister() {
        return movieLister;
    }

    public void setMovieLister(MovieLister movieLister) {
        this.movieLister = movieLister;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }

    public void directorChange() {
        movies = movieLister.moviesDirectedBy(director);
    }
}
