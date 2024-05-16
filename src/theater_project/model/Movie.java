package theater_project.model;

import java.time.LocalDateTime;

import javax.swing.ImageIcon;

class Session{
    LocalDateTime[] dateTimes;
    Seat[] seats=new Seat[110];
}

public class Movie {
    static int id;
    String name;
    String details;
    ImageIcon poster;
}

