package com.driver;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String , Movie> MovieDb;
    HashMap<String, Director> DirectorDb;
    HashMap<String, List<String>> PairDb;

    public MovieRepository() {
        this.MovieDb = new HashMap<String, Movie>();
        this.DirectorDb = new HashMap<String, Director>();
        this.PairDb = new HashMap<String, List<String>>();
    }

    public String addtoMovieDb(Movie movie){
        String name = movie.name;
        MovieDb.put(name, movie);
        return "movie added successfully";
    }

    public String addtoDirectorDb(Director director){
        String name = director.name;
        DirectorDb.put(name, director);
        return "Director added successfully";
    }

    public String addMovieDirectorPairtoDb(String movie, String director){
       if(MovieDb.containsKey(movie) && DirectorDb.containsKey(director)){
           List<String> currmovies = new ArrayList<>();
           if(PairDb.containsKey(director))
           currmovies = PairDb.get(director);

           currmovies.add(movie);
           PairDb.put(director, currmovies);
       }
       return "Pair added successfully";
    }

    public Movie getMovieByNameDb(String name){
       Movie movie = MovieDb.get(name);
       return movie;
    }

    public Director getDirectorByNameDb(String name){
       Director director = DirectorDb.get(name);
       return director;
    }

    public List<String> getMoviesByDirectorName(String name){
        return PairDb.get(name);
    }

    public List<String> findAllMovies(){
        List<String> movielist = new ArrayList<>();
        for(String str : MovieDb.keySet()){
            movielist.add(str);
        }
        return movielist;
    }

    public String deleteDirectorByName(String name){
        List<String> moviestobedeleted = new ArrayList<>();
        if(PairDb.containsKey(name)) {
            moviestobedeleted = PairDb.get(name);
        }
        PairDb.remove(name);
        DirectorDb.remove(name);
        for(String movie : moviestobedeleted){
            if(MovieDb.containsKey(movie)){
                MovieDb.remove(movie);
            }
        }
        return "Successfully removed";
    }

    public String deleteAllDirectors(){
        List<String> list = new ArrayList<>();
        DirectorDb = new HashMap<>();
        for(String directorname : PairDb.keySet()){
            for(String moviename : PairDb.get(directorname)){
                list.add(moviename);
            }
        }
        for(String movie : list){
            if(MovieDb.containsKey(movie)){
                MovieDb.remove(movie);
            }
        }
        return "Successful";
    }
}
