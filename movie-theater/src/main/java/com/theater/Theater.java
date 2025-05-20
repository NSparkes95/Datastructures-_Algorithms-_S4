package com.theater;

public class Theater {
    private final SeatingChart seatingChart;

    public Theater(int rows, int cols) {
        this.seatingChart = new SeatingChart(rows, cols);
    }

    public void showSeatingChart() {
        seatingChart.displayChart();
    }

    public boolean reserveSeat(char row, int number) {
        Seat seat = seatingChart.getSeat(row,number);
        if(seat == null) {
            System.out.println("That seat does not exist.");
            return false;
        }

        if (seat.isReserved()) {
            System.out.println("Seat" + seat.getSeatLabel() + " is already reserved.");
            Seat suggestion = seatingChart.findFirstAvailableSeat();
            if (suggestion !=null) {
                System.out.println("Suggested available seat:" + suggestion.getSeatLabel());
            } else {
                System.out.println("No available seats left.");
            }
            return false;
        }

        seat.reserve();
        System.out.println("Seat" + seat.getSeatLabel() + "reserved successfully.");
        return true;
    }

    public boolean cancelReservation(char row, int number) {
        Seat seat = seatingChart.getSeat(row, number);
        if (seat == null) {
            System.out.println("That seat does not exist.");
            return false;
        }

        if (!seat.isReserved()) {
            System.out.println("Seat" + seat.getSeatLabel() + "is not reserved.");
            return false;
        }

        seat.cancelReservation();
        System.out.println("Reservation for seat" + seat.getSeatLabel() + "cancelled.");
        return true;
    }
}
