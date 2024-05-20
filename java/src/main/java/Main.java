 import org.example.theater.dataHandler.MovieHandler;
 import org.example.theater.dataHandler.UserHandler;
 import org.example.theater.model.*;
 import org.example.theater.view.MoviesPage.MoviePosterGrid;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
     //     MovieHandler movieHandler =new MovieHandler();
     //     List<Session> sessions=new ArrayList<>(){};
     //      sessions.add(  new Session(1,5,"2024-9-2",new ArrayList<>(110)));
     //      sessions.add(  new Session(2,5,"2024-9-6",new ArrayList<>(110)));

     //      //     movieHandler.editSessionInMovie(sessions[0]);
     //    Movie movie1=new Movie("The first omen","omen","C:\\Users\\mohan\\eclipse-workspace\\theater_project\\java\\src\\main\\java\\org\\example\\theater\\assets\\images\\The_first_omen.jpg",sessions);
     //    movieHandler.addMovie(movie1);
        User mainUser=null;
     new MoviePosterGrid(mainUser);

     }
}