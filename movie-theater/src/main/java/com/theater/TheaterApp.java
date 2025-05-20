package com.theater;

import java.util.Scanner;

public class TheaterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Theater theater = new Theater(5,10);

        boolean running = true;

        System.out.println("Welcome to the Movie Theater Reservation System");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. View Seating Chart");
            System.out.println("2. Reserved a Seat");
            System.out.println("3.Cancel Reservation");
            System.out.println("0.Exit");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    theater.showSeatingChart();
                    break;

                case"2":
                    System.out.print("Enter seat to reserve(ex:A5): ");
                    String seatToReserve = scanner.nextLine().toUpperCase().trim();
                    if (isValidInput(seatToReserve)) {
                        char row = seatToReserve.charAt(0);
                        int number = Integer.parseInt(seatToReserve.substring(1));
                        theater.reserveSeat(row, number);
                    } else {
                        System.out.println("Invalid seat format. Try again.");
                    }
                    break;

                case "3":
                    System.out.print("Enter seat to cancel (ex:A5): ");
                    String seatToCancel = scanner.nextLine().toUpperCase().trim();
                    if (isValidInput(seatToCancel)) {
                        char row = seatToCancel.charAt(0);
                        int number = Integer.parseInt(seatToCancel.substring(1));
                        theater.cancelReservation(row, number);
                    } else {
                        System.out.println("Invalid seat. Try again.");
                    }
                    break;

                case "0":
                    running = false;
                    System.out.println("Exiting. Enjoy the movie!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static boolean isValidInput(String input) {
        return input.matches("^[A-Z][0-9]{1,2}$");
    }
}
