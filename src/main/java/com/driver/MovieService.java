package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        String result = movieRepository.addtoMovieDb(movie);
        return result;
    }

    public String addDirector(Director director){
        String result = movieRepository.addtoDirectorDb(director);
        return result;
    }

    public String addMovieDirectorPair(String movie, String director){
        String result = movieRepository.addMovieDirectorPairtoDb(movie, director);
        return result;
    }

    public Movie getMovieByName(String name){
        Movie movie = movieRepository.getMovieByNameDb(name);
        return movie;

    }
    public Director getDirectorByName(String name){
        Director director = movieRepository.getDirectorByNameDb(name);
        return director;
    }

    public String deleteDirectorByName(String name){
        return movieRepository.deleteDirectorByName(name);
    }

    public List<String> getMoviesByDirectorName(String name){
        return movieRepository.getMoviesByDirectorName(name);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public String deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();
    }
}
