 import org.example.theater.dataHandler.MovieHandler;
 import org.example.theater.dataHandler.UserHandler;
 import org.example.theater.model.*;

 import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.List;

public class Main {
    public static void main(String[] args) {

        MovieHandler moveHandler = new MovieHandler();
        UserHandler userHandler=new UserHandler();

        Session session= moveHandler.getMovieById(1).getSessions()[0];

        ReservationForm[] forms = new ReservationForm[]{new ReservationForm(1, Arrays.asList(session))};
        User currentUser = new User("mohannad", "mosdhannaddfmadi12ad@gmail.com", "2123123", forms);
userHandler.signUp(currentUser);
    }
}