import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<String> bookedSeats;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.bookedSeats = new ArrayList<>();
    }

    public boolean login(String uname, String pass) {
        return this.username.equals(uname) && this.password.equals(pass);
    }

    public void bookSeat(String seat, List<String> availableSeats) {
        if (availableSeats.contains(seat)) {
            bookedSeats.add(seat);
            availableSeats.remove(seat);
            System.out.println("Seat booked successfully: " + seat);
        } else {
            System.out.println("Seat not available.");
        }
    }

    public void cancelBooking(String seat, List<String> availableSeats) {
        if (bookedSeats.remove(seat)) {
            availableSeats.add(seat);
            System.out.println("Booking cancelled: " + seat);
        } else {
            System.out.println("You don't have this seat booked.");
        }
    }

    public void viewBookings() {
        if (bookedSeats.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            System.out.println("Your Bookings:");
            for (String s : bookedSeats) {
                System.out.println("- " + s);
            }
        }
    }
}

