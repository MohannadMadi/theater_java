 import org.example.theater.dataHandler.MovieHandler;
import org.example.theater.model.Movie;
import org.example.theater.model.Session;
import org.example.theater.model.User;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

MovieHandler moveHandler=new MovieHandler();
        Movie movie1 =new Movie();
        Movie movie3 =new Movie("adadada","asf","as",new Session[]{});
        moveHandler.addMovie(movie3);
    }
}
