package org.example.theater.dataHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.theater.model.Movie;
import org.example.theater.model.Session;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieHandler {
    private static final String JSON_FILE = "C:\\Users\\mohan\\eclipse-workspace\\theater_project\\java\\src\\main\\java\\org\\example\\theater\\movies.json";

    public List<Movie> getMovies() {
        return movies;
    }

    private List<Movie> movies;
    private int nextMovieId;

    public MovieHandler() {
        loadMovies();

    }

    private void loadMovies() {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        File file = new File(JSON_FILE);
        if (file.exists()) {
            try {
                movies = mapper.readValue(file, new TypeReference<List<Movie>>() {});
                // Set nextMovieId to the value of the last movie's ID + 1
            if (movies.size()>0){
                nextMovieId = movies.getLast().getId()+1;

            }else{
                nextMovieId=1;
            }
            } catch (IOException e) {
                e.printStackTrace();
                movies = new ArrayList<>();
            }
            // Assign unique IDs to movies

        } else {
            movies = new ArrayList<>();
            nextMovieId = 1; // Start from ID 1 if no movies exist
        }
    }


    public void addMovie(Movie movie) {
        movie.setId(nextMovieId); // Assign unique ID to the movie
        movies.add(movie);
        saveMovies();
    }
    public void saveMovies() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(JSON_FILE), movies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Movie getMovieById(int id) {
        return movies.stream()
                .filter(movie -> movie.getId() == id)
                .findFirst()
                .orElse(null);
    }



    // Other methods for manipulating movie data
}
