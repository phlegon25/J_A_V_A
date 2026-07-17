import java.util.Scanner;

public class TripPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // ===== TASK 1: Welcome Message and Get User's Name =====
        System.out.println("========================================");
        System.out.println("     WELCOME TO TRIP PLANNER 3000!");
        System.out.println("========================================");
        System.out.print("\nWhat is your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "! Let's plan your road trip.\n");
        
        // ===== TASK 2: Get Trip Data =====
        System.out.println("========================================");
        System.out.println("     PLEASE ENTER TRIP INFORMATION");
        System.out.println("========================================");
        
        // Distance in kilometers
        System.out.print("Enter the total distance in kilometres (km): ");
        int distanceKm = scanner.nextInt();
        
        // Convert km to miles (1 km = 0.621371 miles)
        final double KM_TO_MILES = 0.621371;
        double distanceMiles = distanceKm * KM_TO_MILES;
        
        // Car speed in mph
        System.out.print("Enter the car's speed in miles per hour (mph): ");
        double carSpeed = scanner.nextDouble();
        
        // Fuel efficiency in MPG
        System.out.print("Enter the car's fuel efficiency in miles per gallon (MPG): ");
        double fuelEfficiency = scanner.nextDouble();
        
        // Gas price per gallon
        System.out.print("Enter the current gas price per gallon: $");
        double gasPrice = scanner.nextDouble();
        
        // ===== TASK 3: Perform Calculations =====
        
        // Total Fuel Needed: Distance (in miles) / Fuel Efficiency
        double totalFuelNeeded = distanceMiles / fuelEfficiency;
        
        // Total Trip Cost: Total Fuel Needed * Gas Price
        double totalTripCost = totalFuelNeeded * gasPrice;
        
        // Estimated Driving Time (using 60 mph average as per instructions)
        double timeInHours = distanceMiles / carSpeed ;  // Time = Distance / Speed
        
        // Convert decimal hours to Hours and Minutes
        int hours = (int) timeInHours;  // Cast to int to get whole hours
        int minutes = (int) ((timeInHours - hours) * 60);  // Use remainder for minutes
        
        
        // ===== TASK 4: Format and Print Summary =====
        System.out.println("\n========================================");
        System.out.println("          TRIP SUMMARY FOR " + userName.toUpperCase());
        System.out.println("========================================");
        System.out.println("\nTrip Details:");
        System.out.println("Distance: " + distanceKm + " km (" + String.format("%.2f", distanceMiles) + " miles)");
        System.out.println("Car Speed: " + carSpeed + " mph");
        System.out.println("Fuel Efficiency: " + fuelEfficiency + " MPG");
        System.out.println("Gas Price: $" + String.format("%.2f", gasPrice) + " per gallon");
        
        System.out.println("\nCalculated Results:");
        System.out.println("Total Fuel Needed: " + String.format("%.2f", totalFuelNeeded) + " gallons");
        System.out.println("Total Trip Cost: $" + String.format("%.2f", totalTripCost));
        System.out.println("Estimated Driving Time: " + hours + " hour(s) and " + minutes + " minute(s)");
        
        System.out.println("\n========================================");
        System.out.println("     Safe travels, " + userName + "!");
        System.out.println("========================================\n");
        
        scanner.close();
    }
}
