package com.theater;

public class SeatingChart {
    int[][] seats = null;

    public SeatingChart(int rows, int cols) {
        this.seats = new int[rows][cols];
    }

    public void reserveSeat(int row, int col) {
        try {
            if(seats[row][col] == 0) {
                seats[row][col] = 1;
                System.out.println("Seat reserved at [" + row + "][" + col + "]");
            } else {
                System.out.println("Seat already reserved.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat position.");
        }
    }

    public void cancelSeat(int row, int col) {
        try {
            if (seats[row][col] == 1) {
                seats[row][col] =0;
                System.out.println("Reservation cancelled at [" + row + "][" + col + "]");
            } else {
                System.out.println("That seat wasn't reserved.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Seat Position.");
        }
    }

    public void viewSeat(int row, int col) {
        try {
            System.out.println("Seat at [" + row + "][" + col + "] is " + (seats[row][col] == 1 ? "RESERVED" : "EMPTY"));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat position.");
        }
    }

    public void displayChart() {
        System.out.println("\nSeating Chart");
        for (int[] seat : seats) {
            for (int col = 0; col < seats[0].length; col++) {
                System.out.print((seat[col] == 1 ? "[X]" : "[ ]") + " ");
            }
            System.out.println();
        }
    }

}
