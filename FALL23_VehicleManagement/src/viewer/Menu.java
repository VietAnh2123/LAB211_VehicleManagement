/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewer;

import controller.Validation;
import controller.VehicleManagement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Vehicle;

/**
 *
 * @author AD
 */
public class Menu {

    private static String[] ops = {
        "Add new Vehicle",
        "Check exist Vehicle",
        "Update Vehicle",
        "Delete Vehicle",
        "Search Vehicle",
        "Display Vehicle list",
        "Save to file",
        "Load from file",
        "Quit"
    };

    private static int getChoice() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ops.length; i++) {
            System.out.println("\t" + (i + 1) + ". " + ops[i]);
        }
        return Validation.checkInputIntLimit("Your choice: ", 1, ops.length);
    }

    public static void display() throws IOException{
        VehicleManagement vm = new VehicleManagement();
        ArrayList<Vehicle> vList = new ArrayList<>();
        int choice;
        String fileName = "src\\database\\vehicle.txt";
        vm.loadData(fileName);
        do {
            System.out.println("|========================================|");
            System.out.println("|           VEHICLE MANAGEMENT           |");
            System.out.println("|========================================|");
            choice = getChoice();
            switch (choice) {
                case 1:
                    vm.addVehicle();
                    break;
                case 2:
                    vm.checkExist();
                    break;
                case 3:
                    vm.updateVehicle();
                    break;
                case 4:
                    vm.deleteVehicle();
                    break;
                case 5:
                    System.out.println("    5.1. Search by ID");
                    System.out.println("    5.2. Search by Name");
                    System.out.println("    #. Return to main Menu");
                    System.out.print("  Choose 1 or 2: ");
                    int searchChoice;

                    searchChoice = Validation.checkInputInt();
                    switch (searchChoice) {
                        case 1:
                            System.out.print("  - Enter ID: ");
                            String id = Validation.checkInputString();
                            System.out.println("ID        NAME             COLOR            PRICE            BRAND         TYPE         PRODUCT YEAR    ");
                            System.out.println(vm.search(id) + "\n\n");
                            break;
                        case 2:
                            System.out.print("  - Enter Name: ");
                            String name = Validation.checkInputString();
                            System.out.println("ID        NAME             COLOR            PRICE            BRAND         TYPE         PRODUCT YEAR    ");
                            System.out.println(vm.searchByName(name) + "\n\n");
                            break;
                    }
                    break;
                case 6:
                    System.out.println("    6.1. Display all");
                    System.out.println("    6.2. Display descending by price");
                    System.out.println("    #. Return to main Menu");
                    System.out.print("  Choose 1 or 2: ");
                    int displayChoice;
                    
                    displayChoice = Validation.checkInputInt();
                    switch (displayChoice) {
                        case 1:
                            vm.displayAll();
                            break;
                        case 2:
                            vm.displayByPrice();
                            break;
                    }
                    break;
                case 7:
                    //save to file
                    vm.save(fileName);
                    break;
                case 8:
                    //read file
                    vm.displayAll();
                    break;
            }
        } while (choice != ops.length);
    }
}
