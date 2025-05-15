package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    private void init() {
        //TODO: Load dealership details from a file
        dealership= DealershipFileManager.getDealership();

    }

    public UserInterface() {
        init();

    }

    public void display() {
        //TODO: Create your main menu (do-while)
        System.out.println("---welcome to Sukie's Dealership!---");
        int mainMenuCommand;

        do {

            System.out.println("1. Get by price");
            System.out.println("2. Get by make/model");
            System.out.println("3. Get by year");
            System.out.println("4. Get by color");
            System.out.println("5. Get by mileage");
            System.out.println("6. Get by type");
            System.out.println("7. Get all");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("0. Exit");

            System.out.println("Command: ");
            mainMenuCommand = scanner.nextInt();

            switch (mainMenuCommand) {
                case 1:
                    processGetByPriceRequest();
                    // TODO: ask the user for a starting price and ending price
                    // ArrayList<Vehicle> filteredVehicles = dealership.getVehicleByPrice(startingPrice, endingPrice);
                    //Display vehicle with loop

                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Command not found. Try again.");
            }

        } while (mainMenuCommand != 0);

    }

    private void processGetByPriceRequest() {
        System.out.println("---Display vehicle by price---");

        System.out.println("Enter Price Min: ");
        double min = scanner.nextDouble();

        System.out.println("Enter Price Max: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByPrice(min, max);
        displayVehicles(filteredVehicles);

    }
    private void processGetByMakeModelRequest() {
        System.out.println("---Display vehicles make and model---");

        System.out.println("Enter Make: ");
        String make = scanner.nextLine();
        System.out.println("Enter Model: ");
        String model = scanner.nextLine();

        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByMakeModel(make, model);
        displayVehicles(filteredVehicles);

    }
    private void processGetByYearRequest() {
        System.out.println("---Display Vehicles by year---");

        System.out.println("Enter Year Min: ");
        int minYear = scanner.nextInt();
        System.out.println("Enter Year Max: ");
        int maxYear = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByYear(minYear, maxYear);
        displayVehicles(filteredVehicles);

    }
    private void processGetByColorRequest() {
        System.out.println("---Dispay venicles by color---");

        System.out.println("Enter Color: ");
        String color = scanner.nextLine();

        ArrayList<Vehicle> filteredVehicles = dealership.vehiclesByColor(color);
        displayVehicles(filteredVehicles);

    }
    private void processGetByMileageRequest() {
        System.out.println("---Display vehicles by milegae---");

        System.out.println("Enter Mileage Min: ");
        int minMileage = scanner.nextInt();
        System.out.println("Enter Mileage Max: ");
        int maxMileage = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vehicle> filteredVehicles = dealership.vehcileMileage(minMileage, maxMileage);
        displayVehicles(filteredVehicles);
    }
    private void processGetByVehicleTypeRequest() {
        System.out.println("---Display vehicles by type---");

        System.out.println("Enter Type (Ex: car, Truck, SUV, etc...): ");
        String type = scanner.nextLine();

        ArrayList<Vehicle> filteredVehicles = dealership.vehicleByType(type);
        displayVehicles(filteredVehicles);

    }
    private void processGetAllVehiclesRequest() {
        System.out.println("---Display All Vehicles---");

    }
    private void processAddVehicleRequest() {
        System.out.println("---Add Vehicles");

        System.out.println("Enter Vin: ");
        int vin = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Make: ");
        String make = scanner.nextLine();

        System.out.println("Enter Model: ");
        String model = scanner.nextLine();

        System.out.println("Enter Type: ");
        String type = scanner.nextLine();

        System.out.println("Enter Color: ");
        String color = scanner.nextLine();

        System.out.println("Enter Odometer: ");
        int odometer = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle vehicleToAdd = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicleToAdd);
        DealershipFileManager.saveDealership(dealership);

        System.out.println("Vehicle added successfully!");


    }
    private void processRemoveVehicleRequest() {


    }
    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

}
