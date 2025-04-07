package org.example;

import java.util.List;
import java.util.Scanner;


public class App 
{
    public static void main(String[] args) {
        TruckService truckService = new TruckService();
        //given the data in truck
        Truck truck1=new Truck("TATA", "2021", 1000, "Ratan dada");
        Truck truck2=new Truck("volvo", "2022", 1000, "Geely dada");
        Truck truck3=new Truck("eicher", "2020", 800, "Mukesh bhau");
        Truck truck4=new Truck("TATA", "2024", 1500, "Vijay dada");
        Truck truck5=new Truck("Mahindra", "2024", 1200, "Rameshbabu");

        System.out.println("-----------------------------tRUCK mANAG sYSTEM--------------------------");
        System.out.println("You have 5 trucks available to add:");
        System.out.println("1. " + truck1);
        System.out.println("2. " + truck2);
        System.out.println("3. " + truck3);
        System.out.println("4. " + truck4);
        System.out.println("5. " + truck5);


        int option = -1;
        Scanner sc=new Scanner(System.in);

        while (option != 0) {
            System.out.println("\nChoose an option: ");
            System.out.println("1. Add truck");
            System.out.println("2. Delete truck");
            System.out.println("3. Update truck");
            System.out.println("4. Fetch truck by ID");
            System.out.println("5. Show all trucks");
            System.out.println("0. Exit");
            System.out.print("Enter your option: ");
            option = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (option) {
                case 1: {
                    System.out.println("Which truck do you want to add? (1-5): ");
                    int truckno = sc.nextInt();
                    if (truckno == 1) {
                        truckService.addTruck(truck1);
                    } else if (truckno == 2) {
                        truckService.addTruck(truck2);
                    } else if (truckno == 3) {
                        truckService.addTruck(truck3);
                    } else if (truckno == 4) {
                        truckService.addTruck(truck4);
                    } else if (truckno == 5) {
                        truckService.addTruck(truck5);
                    } else {
                        System.out.println("Not present");
                    }
                    break;
                }

                case 2: {
                    System.out.print("Enter truck ID to delete: ");
                    int truckId = sc.nextInt();
                    truckService.deleteTruck(truckId);
                    break;
                }

                case 3: {
                    System.out.print("Enter truck ID to update: ");
                    int truckId = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    Truck truck = truckService.getTruckById(truckId);
                    if (truck == null) {
                        System.out.println("Truck not found.");
                        break;
                    }

                    System.out.println("Choose field to update:");
                    System.out.println("1. Name");
                    System.out.println("2. Model");
                    System.out.println("3. Capacity");
                    System.out.println("4. Driver Name");
                    int updateOpt = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    switch (updateOpt) {
                        case 1 : {
                            System.out.print("Enter new name: ");
                            String newName = sc.nextLine();
                            truck.setName(newName);
                            break;
                        }
                        case 2 : {
                            System.out.print("Enter new model: ");
                            String newModel = sc.nextLine();
                            truck.setModel(newModel);
                            break;
                        }
                        case 3 : {
                            System.out.print("Enter new capacity: ");
                            int newCap = sc.nextInt();
                            truck.setCapacity(newCap);
                            break;
                        }
                        case 4: {
                            System.out.print("Enter new driver name: ");
                            String newDriver = sc.nextLine();
                            truck.setDriver_name(newDriver);
                            break;
                        }
                        default :
                            System.out.println("Invalid update option.");
                            break;
                    }

                    truckService.updateTruck(truck);
                    break;
                }

                case 4: {
                    System.out.print("Enter truck ID to fetch: ");
                    int truckId = sc.nextInt();
                    Truck truck = truckService.getTruckById(truckId);
                    if (truck != null) {
                        System.out.println(truck);
                    } else {
                        System.out.println("Truck not found.");
                    }
                    break;
                }

                case 5: {
                    List<Truck> allTrucks = truckService.getAllTruck();
                    System.out.println("All trucks in database:");
                    for (Truck t : allTrucks) {
                        System.out.println(t);
                    }
                    break;
                }

                case 0: {
                    System.out.println("Exiting system. Goodbye!");
                    break;
                }

                default:
                    System.out.println("Invalid option, try again.");
            }
        }

//
//
//        //add the truck
//        truckService.addTruck(truck1);
//        truckService.addTruck(truck2);
//        truckService.addTruck(truck3);
//        truckService.addTruck(truck4);
//
//
//        //get truck by id  -- fetching
//        Truck truck = truckService.getTruckById(2);
//        System.out.println(truck);
//
//        //update the data of existing truck
//        truck.setDriver_name("Mahindra");
//        truckService.updateTruck(truck);
//
//
//        List<Truck> alltrucks = truckService.getAllTruck();
//        System.out.println("All trucks are: ");
//        for(Truck truckno: alltrucks){
//            System.out.println(truckno);
//        }
//
//        truckService.deleteTruck(1);
//
//        alltrucks = truckService.getAllTruck();
//        System.out.println("All trucks are: ");
//        for(Truck truckno: alltrucks){
//            System.out.println(truckno);
//        }

    }
}
