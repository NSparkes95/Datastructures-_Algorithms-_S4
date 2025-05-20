package com.theater;

public class SeatingChart {
    private final int rows;
    private final int cols;
    private final Seat [][] seats;

    public SeatingChart(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.seats = new Seat[rows][cols];
        initializeSeats();
    }

    private void initializeSeats() {
        for (int i = 0; i < rows; i++) {
            char rowLetter = (char) ('A' + i);
            for (int j = 0; j < cols; j++) {
                seats[i][j] = new Seat(rowLetter, j + 1);
            }
        }
    }

    public void displayChart() {
        System.out.print("\nSeating Chart");
        for (int i = 0; i < rows; i++) {
            char rowLetter = (char) ('A' + i);
            System.out.print(rowLetter + " ");
            for (int j = 0; j <cols; j++) {
                System.out.print(seats[i][j].toString());
            }
            System.out.println();
        }

        // Column headers
        System.out.print(" ");
        for (int j = 1; j <= cols; j++) {
            System.out.print(j < 10 ? " " + j : j);
        }
        System.out.print("\n");
    }

    public Seat getSeat(char row, int number) {
        int rowIndex = row - 'A';
        int colIndex = number - 1;

        if (rowIndex >= 0 && rowIndex < rows && colIndex >= 0 && colIndex < cols) {
            return seats[rowIndex][colIndex];
        }
        return null;
    }

    public Seat findFirstAvailableSeat() {
        for(Seat[] row : seats) {
            for (Seat seat : row) {
                if (!seat.isReserved()){
                    return seat;
                }
            }
        }
        return null;
    }
}
