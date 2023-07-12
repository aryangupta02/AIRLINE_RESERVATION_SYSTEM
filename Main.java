import java.util.Scanner;

class AirlineReservationSystem {
    private boolean[] seats;

    public AirlineReservationSystem() {
        seats = new boolean[10]; // 10 seats in the airplane
    }

    public synchronized int reserveSeat() {
        for (int i = 0; i < seats.length; i++) {
            if (!seats[i]) {
                seats[i] = true; // Mark the seat as reserved
                return i; // Return the seat number
            }
        }
        return -1; // Return -1 if no available seats
    }

    public synchronized void printAvailableSeats() {
        System.out.println("Available seats:");
        for (int i = 0; i < seats.length; i++) {
            if (!seats[i]) {
                System.out.println("Seat " + i);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        AirlineReservationSystem reservationSystem = new AirlineReservationSystem();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            System.out.println("Airline Reservation System");
            System.out.println("1. Reserve a seat");
            System.out.println("2. Print available seats");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    int seatNumber = reservationSystem.reserveSeat();
                    if (seatNumber == -1) {
                        System.out.println("Sorry, no available seats.");
                    } else {
                        System.out.println("Seat " + seatNumber + " reserved.");
                    }
                    break;

                case 2:
                    reservationSystem.printAvailableSeats();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
}
