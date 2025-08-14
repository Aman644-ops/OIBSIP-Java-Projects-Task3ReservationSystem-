// Author: Aman Kumar
// OIBSIP Task 4 - Online Reservation System

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private String adminId;
    private String password;
    private List<String> seats;

    public Admin(String adminId, String password) {
        this.adminId = adminId;
        this.password = password;
        this.seats = new ArrayList<>();
    }

    public boolean login(String id, String pass) {
        return this.adminId.equals(id) && this.password.equals(pass);
    }

    public void addSeat(String seatName) {
        seats.add(seatName);
        System.out.println("Seat added: " + seatName);
    }

    public void removeSeat(String seatName) {
        if (seats.remove(seatName)) {
            System.out.println("Seat removed: " + seatName);
        } else {
            System.out.println("Seat not found!");
        }
    }

    public void viewSeats() {
        if (seats.isEmpty()) {
            System.out.println("No seats available.");
            return;
        }
        System.out.println("Available Seats:");
        for (String seat : seats) {
            System.out.println("- " + seat);
        }
    }

    public List<String> getSeats() {
        return seats;
    }
}

