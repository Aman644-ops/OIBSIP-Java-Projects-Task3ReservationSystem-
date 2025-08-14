import java.util.Scanner;

public class ReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Admin admin = new Admin("admin", "admin123");
        User user = new User("Aman", "1234");

        System.out.println("===== Online Reservation System =====");

        int roleChoice;
        do {
            System.out.println("\n1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid option!");
                sc.next();
            }
            roleChoice = sc.nextInt();
            sc.nextLine();

            switch (roleChoice) {
                case 1:
                    System.out.print("Enter Admin ID: ");
                    String aid = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String apass = sc.nextLine();
                    if (admin.login(aid, apass)) {
                        adminMenu(sc, admin);
                    } else {
                        System.out.println("Invalid admin credentials!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Username: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String upass = sc.nextLine();
                    if (user.login(uname, upass)) {
                        userMenu(sc, user, admin);
                    } else {
                        System.out.println("Invalid user credentials!");
                    }
                    break;

                case 3:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (roleChoice != 3);

        sc.close();
    }

    public static void adminMenu(Scanner sc, Admin admin) {
        int choice;
        do {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Add Seat");
            System.out.println("2. Remove Seat");
            System.out.println("3. View Seats");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter seat name: ");
                    String seatName = sc.nextLine();
                    admin.addSeat(seatName);
                    break;
                case 2:
                    System.out.print("Enter seat name to remove: ");
                    String removeSeat = sc.nextLine();
                    admin.removeSeat(removeSeat);
                    break;
                case 3:
                    admin.viewSeats();
                    break;
                case 4:
                    System.out.println("Admin logged out.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 4);
    }

    public static void userMenu(Scanner sc, User user, Admin admin) {
        int choice;
        do {
            System.out.println("\n===== User Menu =====");
            System.out.println("1. View Available Seats");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View My Bookings");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    admin.viewSeats();
                    break;
                case 2:
                    System.out.print("Enter seat to book: ");
                    String bookSeat = sc.nextLine();
                    user.bookSeat(bookSeat, admin.getSeats());
                    break;
                case 3:
                    System.out.print("Enter seat to cancel: ");
                    String cancelSeat = sc.nextLine();
                    user.cancelBooking(cancelSeat, admin.getSeats());
                    break;
                case 4:
                    user.viewBookings();
                    break;
                case 5:
                    System.out.println("User logged out.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 5);
    }
}

