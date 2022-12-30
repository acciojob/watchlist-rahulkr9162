package com.driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.RemoteRef;
import java.security.DigestException;
import java.util.List;

@RestController
public class MovieController {

@Autowired
MovieService movieService;

@PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
    String response = movieService.addMovie(movie);
    return new ResponseEntity<>("Movie added successfully", HttpStatus.CREATED);
}

@PostMapping("/add_director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        String response = movieService.addDirector(director);
        return new ResponseEntity<>("Director added successfully", HttpStatus.CREATED);
    }


    @PutMapping("/addMovieDirectorPair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("moviename") String movie, @RequestParam("directorname") String director){
    String response = movieService.addMovieDirectorPair(movie, director);
    return new ResponseEntity<>("Pair added successfully", HttpStatus.ACCEPTED);
    }

@GetMapping("/getMovieByName")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("name") String moviename){
    Movie movie = movieService.getMovieByName(moviename);
    return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/getDirectorByName")
    public ResponseEntity<Director> getDirectorByName(@RequestParam("name") String directorname){
        Director director = movieService.getDirectorByName(directorname);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @GetMapping("/getMoviesByDirectorName")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@RequestParam("directorname") String name){
    return new ResponseEntity<>(movieService.getMoviesByDirectorName(name), HttpStatus.OK);
    }

    @GetMapping("/findAllMovies")
    public ResponseEntity<List<String>> findAllMovies(){
    return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteDirectorByName")
    public  ResponseEntity<String> deleteDirectorByName(@RequestParam("directorname") String name){
    return new ResponseEntity<>(movieService.deleteDirectorByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllDirectors")
    public ResponseEntity<String> deleteAllDirectors(){
    return new ResponseEntity<>(movieService.deleteAllDirectors(), HttpStatus.OK);
    }

}
