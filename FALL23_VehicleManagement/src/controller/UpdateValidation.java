/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;
import java.util.regex.Pattern;
import model.Vehicle;

/**
 *
 * @author AD
 */
public class UpdateValidation {
    //string name, string color, double price, String brand, string type, int productYear
    private static Scanner sc = new Scanner(System.in);
    
    public static String checkInputName(Vehicle v){
        String result = "";
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+$");
        do{
            result = sc.nextLine();
            if(result.trim().isEmpty()){
                result = v.getVehicleName();
            }
        }while(!pattern.matcher(result).matches());
        return result;
    }
    
    public static String checkInputColor(Vehicle v){
        String result = "";
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+$");
        do{
            result = sc.nextLine();
            if(result.trim().isEmpty()){
                result = v.getVehicleColor();
            }
        }while(!pattern.matcher(result).matches());
        return result;
    }
    
    public static double checkInputPrice(Vehicle v){
        boolean check = true;
        double result;
        try{
            while (check) {                
                String input = sc.nextLine();
                if(input.trim().isEmpty()){
                    result = v.getVehiclePrice();
                    return result;
                }else{
                    result = Double.parseDouble(input);
                }
                if(result < 0 || result > Double.MAX_VALUE){
                    System.out.println("Number must be 0 " + Double.MAX_VALUE);
                    check = true;
                }else{
                    return result;
                }
            }
        }catch(NumberFormatException e){
            System.err.println("This must be number");
        }
        return 0;
    }
    
    public static String checkInputBrand(Vehicle v){
        String result = "";
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+$");
        do{
            result = sc.nextLine();
            if(result.trim().isEmpty()){
                result = v.getVehicleBrand();
            }
        }while(!pattern.matcher(result).matches());
        return result;
    }
    
    public static String checkInputType(Vehicle v){
        String result = "";
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+$");
        do{
            result = sc.nextLine();
            if(result.trim().isEmpty()){
                result = v.getType();
            }
        }while(!pattern.matcher(result).matches());
        return result;
    }
    
    public static int checkInputProductYear(Vehicle v){
        boolean check = true;
        int result;
        try{
            while(check){
                String input = sc.nextLine();
                if(input.trim().isEmpty()){
                    result = v.getPruductYear();
                    return result;
                }else{
                    result = Integer.parseInt(input);
                }
                if(result < 0 || result > Integer.MAX_VALUE){
                    System.out.println("Must be 0 to " + Integer.MAX_VALUE);
                    check = true;
                }else{
                    return result;
                }
            }
        }catch(NumberFormatException e){
            System.err.println("This must be number");
            check = true;
        }
        return 0;
    }
}
