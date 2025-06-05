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
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Single Seat");
            System.out.println("0.Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    theater.showChart();
                    break;

                case"2":
                    System.out.print("Enter row: ");
                    int r1 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter column: ");
                    int c1 = Integer.parseInt(scanner.nextLine());
                    theater.reserve(r1, c1);
                    break;

                case "3":
                    System.out.print("Enter row: ");
                    int r2 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter column: ");
                    int c2 = Integer.parseInt(scanner.nextLine());
                    theater.cancel(r2, c2);
                    break;

                case "4":
                    System.out.print("Enter row number: ");
                    int r3 = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter column number: ");
                    int c3 = Integer.parseInt(scanner.nextLine());
                    theater.view(r3, c3);

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
}
