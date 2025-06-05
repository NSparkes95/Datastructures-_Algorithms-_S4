package com.theater;

public class Theater {
    SeatingChart chart;

    public Theater(int rows, int cols) {
        chart = new SeatingChart(rows, cols);
    }

    public void showChart() {
        chart.displayChart();
    }

    public void reserve(int row, int col) {
        chart.reserveSeat(row, col);
    }

    public void cancel(int row, int col) {
        chart.cancelSeat(row, col);
    }

    public void view(int row, int col) {
        chart.viewSeat(row, col);
    }
}
