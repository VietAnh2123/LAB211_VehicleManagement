/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Vehicle;

/**
 *
 * @author AD
 */
public class Validation {
    
    private static Scanner sc = new Scanner(System.in);
    
   public static int checkInputIntLimit(String msg, int min, int max){
       int result;
       while(true){
           try{
               System.out.print(msg);
               result = Integer.parseInt(sc.nextLine());
               if(min <= result && result <= max){
                   break; 
               }
               throw new NumberFormatException();
           }catch(NumberFormatException e){
               System.err.println("Please enter an integer number in range " + min + " - " + max);
               System.out.print("Enter again ");
           }
       }
       return result;
   }
   
    public static String checkInputString() {
        while (true) {
            String result = sc.nextLine();
            if (result.trim().isEmpty()) {
                System.err.println("Not be empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
   
    public static int checkInputInt() {
        boolean check = true;
        int result;
        try {
            while (check) {
                result = Integer.parseInt(sc.nextLine().trim());
                if (result < 0 || result > Integer.MAX_VALUE) {
                    System.err.println("Number must be 0 to " + Integer.MAX_VALUE);
                    System.out.print("Enter again: ");
                    check = true;
                } else {
                    return result;
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("This must be number");
            check = true;
        }
        return 0;
    }
   
    public static double checkInputDouble() {
        boolean check = true;
        double result;
        try {
            while (check) {
                result = Double.parseDouble(sc.nextLine());
                if (result < 0 || result > Double.MAX_VALUE) {
                    System.err.println("Number must be 0 to " + Double.MAX_VALUE);
                    System.out.print("Enter again: ");
                    check = true;
                } else {
                    return result;
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("This must be number");
            check = true;
        }
        return 0;
    }
   
   public static boolean checkInputYN(){
       System.out.print("Do you to continue Y/y or N/n: ");
       while (true) {           
           String result = checkInputString();
           if(result.equalsIgnoreCase("Y")){
               return true;
           }
           if(result.equalsIgnoreCase("N")){
               return false;
           }
           System.out.println("Please input Y/y or N/n");
           System.out.print("Enter again: ");
       }
   }
   
   public static boolean checkIdExist(ArrayList<Vehicle> vList, String id){
       for (Vehicle vehicle : vList) {
           if(id.equalsIgnoreCase(vehicle.getVehicleID())){
               return false;
           }
       }
       return true;
   }
   
   public static Vehicle getVehicle(String id, List<Vehicle> vList){
       for (Vehicle o : vList) {
           if(o.getVehicleID().equals(id))
               return o;
       }
       return null;
   }

    public static int checkInputLimit(String your_choice_, int i, int length) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}