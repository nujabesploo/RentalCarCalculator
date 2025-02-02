package com.pluralsight;
import java.util.*;


public class RentalCarCalculator {

    /**
     * Calculator for rental car costs including optional add-ons and fees
     */
                public static void main(String[] args) {
                    // Define constant prices for all rental options (prices in USD)
                    double carPrice = 29.99;          // Base daily rate for standard car rental
                    double tollTagPrice = 3.95;       // Additional daily rate for electronic toll tag
                    double gpsPrice = 2.95;           // Additional daily rate for GPS navigation
                    double roadsidePrice = 3.95;      // Additional daily rate for roadside assistance coverage

                    // Initialize Scanner object for reading user input throughout the program
                    Scanner userInput = new Scanner(System.in);

                    // Display welcome message and program header
                    System.out.println("Welcome to Car Rental Calculator!");
                    System.out.println("--------------------------------");

                    // Get initial rental information from user
                    // Collect pickup date (format validation not implemented)
                    System.out.print("Please enter pickup date (MM/DD/YYYY): ");
                    String pickupDate = userInput.nextLine();

                    // Get rental duration from user
                    System.out.print("How many days would you like to rent? ");
                    int rentalDays = userInput.nextInt();
                    userInput.nextLine();  // Consume the leftover newline character

                    // Calculate the base cost without any add-ons
                    double carCost = carPrice * rentalDays;
                    // Initialize variable to track cost of additional services
                    double extraCosts = 0;

                    // Menu system for add-on selection
                    // Control variable for the menu loop
                    boolean exitMenu = false;

                    // Continue showing menu until user chooses to exit
                    while (!exitMenu) {
                        // Display the menu of available add-on options
                        System.out.println("\n-----Available Add-ons Menu-----");
                        System.out.println("1. Electronic toll tag ($3.95/day)");
                        System.out.println("2. GPS ($2.95/day)");
                        System.out.println("3. Roadside assistance ($3.95/day)");
                        System.out.println("4. Continue to age verification");

                        // Prompt for user selection
                        System.out.print("\nPlease select an option (1-4): ");

                        // Get user's menu choice
                        int choice = userInput.nextInt();
                        userInput.nextLine();  // Consume the leftover newline character

                        // Process user's selection using switch statement
                        switch (choice) {
                            case 1: // Electronic toll tag option
                                System.out.print("Add electronic toll tag? (yes/no): ");
                                String wantsTollTag = userInput.nextLine();
                                if (wantsTollTag.equalsIgnoreCase("yes")) {
                                    // Calculate and add toll tag cost for entire rental period
                                    extraCosts += tollTagPrice * rentalDays;
                                    System.out.println("Electronic toll tag added!");
                                }
                                break;

                            case 2: // GPS option
                                System.out.print("Add GPS? (yes/no): ");
                                String wantsGPS = userInput.nextLine();
                                if (wantsGPS.equalsIgnoreCase("yes")) {
                                    // Calculate and add GPS cost for entire rental period
                                    extraCosts += gpsPrice * rentalDays;
                                    System.out.println("GPS added!");
                                }
                                break;

                            case 3: // Roadside assistance option
                                System.out.print("Add roadside assistance? (yes/no): ");
                                String wantsRoadside = userInput.nextLine();
                                if (wantsRoadside.equalsIgnoreCase("yes")) {
                                    // Calculate and add roadside assistance cost for entire rental period
                                    extraCosts += roadsidePrice * rentalDays;
                                    System.out.println("Roadside assistance added!");
                                }
                                break;

                            case 4: // Exit menu option
                                exitMenu = true;
                                System.out.println("\nProceeding to age verification...");
                                break;

                            default: // Handle invalid menu selections
                                System.out.println("Invalid option! Please choose 1-4.");
                                break;
                        }
                    }

                    // Age verification and young driver surcharge calculation
                    System.out.print("\nWhat is your age? ");
                    int driverAge = userInput.nextInt();

                    // Initialize young driver surcharge
                    double youngDriverFee = 0;
                    // Apply 30% surcharge if driver is under 25
                    if (driverAge < 25) {
                        youngDriverFee = carCost * 0.30;  // Calculate 30% of base rental cost
                        System.out.println("Young driver surcharge of 30% applied.");
                    }

                    // Calculate final total including all fees and surcharges
                    double totalCost = carCost + extraCosts + youngDriverFee;

                    // Print itemized receipt
                    System.out.println("\nYour Rental Receipt");
                    System.out.println("------------------");
                    // Format all monetary values to 2 decimal places
                    System.out.printf("Car rental: $%.2f%n", carCost);        // Base rental cost
                    System.out.printf("Extra fees: $%.2f%n", extraCosts);     // Cost of all add-ons
                    System.out.printf("Young driver fee: $%.2f%n", youngDriverFee);  // Age-based surcharge
                    System.out.printf("Total cost: $%.2f%n", totalCost);      // Final total

                    // Close Scanner to prevent resource leak
                    userInput.close();
                }
}





