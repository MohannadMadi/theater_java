package theater_project.model;

import java.time.LocalDateTime;

public class Seat {
    User owner;
    Movie movie;
    boolean available;
    double price;
    LocalDateTime sLocalDateTime;
}
