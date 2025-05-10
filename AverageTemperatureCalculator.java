import java.util.Scanner;
import java.util.ArrayList;

public class AverageTemperatureCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Create an ArrayList to store temperatures
        ArrayList<Double> temperatures = new ArrayList<>(); 
        double totalTemperature = 0;
        int count = 0;

        // 2. Prompt the user to enter temperatures for a week
        System.out.println("Enter temperatures for the week (type 'done' to finish):");

        // 3. Use a loop to read temperatures until the user types 'done'
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                double temperature = Double.parseDouble(input);
                temperatures.add(temperature); // Add the temperature to the list
                totalTemperature += temperature;
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid temperature or 'done' to finish.");
            }
        }

        // 4. Calculate the average temperature
        if (count > 0) {
            double averageTemperature = totalTemperature / count;
            System.out.printf("The average temperature for the week is: %.2f%n", averageTemperature);

            // 5. Print temperatures above average
            System.out.println("Temperatures above average:");
            boolean foundAboveAverage = false;
            for (double temp : temperatures) {
                if (temp > averageTemperature) {
                    System.out.printf("%.2f%n", temp);
                    foundAboveAverage = true;
                }
            }
            if (!foundAboveAverage) {
                System.out.println("No temperatures were above average.");
            }
            
        } else {
            System.out.println("No temperatures were entered.");
        }

        scanner.close();
    }
}