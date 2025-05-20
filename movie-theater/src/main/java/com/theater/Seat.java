package com.theater;

public class Seat {
    private char row;
    private int number;
    private boolean reserved;

    public Seat(char row, int number) {
        this.row = row;
        this.number = number;
        this.reserved = false;
    }

    public char getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void reserve() {
        this.reserved = true;
    }

    public void cancelReservation() {
        this.reserved = false;
    }

    public String toString() {
        return reserved ?"[X]" : "[ ]";
    }

    public String getSeatLabel() {
        return "" + row + number;
    }
}
