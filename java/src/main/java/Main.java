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
         MovieHandler movieHandler =new MovieHandler();

         movieHandler.editSessionInMovie(new Session(1,1,"d",new ArrayList<>(110)));
//         Session[] sessions=new Session[]{new Session("2024-8-5",new ArrayList<>())};
//         Movie movie1=new Movie("ghost buster","ghosting","C:\\Users\\mohan\\eclipse-workspace\\theater_project\\java\\src\\main\\java\\org\\example\\theater\\assets\\images\\ghost_busters.jpg",sessions);
//         movieHandler.addMovie(movie1);
        User mainUser=null;
        MoviePosterGrid movieGrid=new MoviePosterGrid(mainUser);

     }
}