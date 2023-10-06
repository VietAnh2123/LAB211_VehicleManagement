/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Vehicle;

/**
 *
 * @author AD
 */
public class VehicleManagement {
    private static List<Vehicle> vList;
    private static String fileName = "src\\database\\vehicle.txt";
    public VehicleManagement() throws IOException {
        vList = new ArrayList<>();
    }
    
    public void addVehicle() throws IOException{
        while (true) {            
            System.out.print(" - Enter Vehicle ID: ");
            String vID = Validation.checkInputString();
            if(!Validation.checkIdExist((ArrayList<Vehicle>) vList, vID)){
                System.err.println("ID existed!");
                return;
            }
            System.out.print(" - Enter Vehicle Name: ");
            String vName = Validation.checkInputString();
            System.out.print(" - Enter Vehicle Color: ");
            String vColor = Validation.checkInputString();
            System.out.print(" - Enter Vehicle Price: ");
            double vPrice = Validation.checkInputDouble();
            System.out.print(" - Enter Vehicle Brand: ");
            String vBrand = Validation.checkInputString();
            System.out.print(" - Enter Vehicle Type: ");
            String vType = Validation.checkInputString();
            System.out.print(" - Enter product year: ");
            int vProductYear = Validation.checkInputInt();
            vList.add(new Vehicle(vID, vName, vColor, vPrice, vBrand, vType, vProductYear));
            saveData(fileName);
            if(!Validation.checkInputYN()){
                System.out.println("~Success ");
                System.out.println("\n");
                System.out.println("\n");
                return;
            }
        }
    }
    
    public void checkExist(){
        System.out.print(" - Enter Vehicle ID to check: ");
        String checkID = Validation.checkInputString();
        if(!Validation.checkIdExist((ArrayList<Vehicle>) vList, checkID)){
            System.out.println("~Exist Vehicle");
            System.out.println("ID        NAME             COLOR            PRICE      BRAND         TYPE         PRODUCT YEAR    ");
            Vehicle v = Validation.getVehicle(checkID, vList);
            System.out.println(v);
            System.out.println("\n\n");
        }else{
            System.out.println("~No Vehicle Found");
            System.out.println("\n\n");
        }
    }
    
    public void updateVehicle() throws IOException{
        System.out.print(" - Enter Vehicle ID to update: ");
        String upID = Validation.checkInputString();
        if(Validation.checkIdExist((ArrayList<Vehicle>) vList, upID)){
            System.out.println("Vehicle does not exist");
            return;
        }
        Vehicle v = Validation.getVehicle(upID, vList);
        System.out.println("ID        NAME             COLOR            PRICE      BRAND         TYPE         PRODUCT YEAR    ");
        System.out.println(v);
        
        System.out.print(" - Enter new name: ");
        String updatedName = UpdateValidation.checkInputName(v);
        v.setVehicleName(updatedName);
        
        System.out.print(" - Enter new color: ");
        String updatedColor = UpdateValidation.checkInputColor(v);
        v.setVehicleColor(updatedColor);
        
        System.out.print(" - Enter new price: ");
        double updatedPrice = UpdateValidation.checkInputPrice(v);
        v.setVehiclePrice(updatedPrice);
        
        System.out.print(" - Enter new brand: ");
        String updatedBrand = UpdateValidation.checkInputBrand(v);
        v.setVehicleBrand(updatedBrand);
        
        System.out.print(" - Enter new type: ");
        String updatedType = UpdateValidation.checkInputType(v);
        v.setType(updatedType);
        
        System.out.print(" - Enter new product year: ");
        int updatedProductYear = UpdateValidation.checkInputProductYear(v);
        v.setPruductYear(updatedProductYear);
        
        saveData(fileName);
        System.out.println(" ~ Update Success\n\n");
    }
    
    public void deleteVehicle() throws IOException {
        if (vList.isEmpty()) {
            System.err.println("Empt List");
        } else {
            System.out.print(" - Enter Vehicle ID to delete: ");
            String rID = Validation.checkInputString();
            Vehicle v = this.search(rID);
            if (v == null) {
                System.out.println("Vehicle " + rID + " not found!\n");
            } else {
                vList.remove(v);
                System.out.println("Vehicle " + rID + " has been deleted\n");
                System.out.println("\n\n");
            }
            saveData(fileName);
        }
    }
    
    public Vehicle search(String id){
        if(vList.isEmpty()){
            System.err.println("Empty List. Please add Vehicle!");
        }
        id = id.trim().toUpperCase();
        for (Vehicle vehicle : vList) {
            if(vehicle.getVehicleID().equalsIgnoreCase(id))
                return vehicle;
        }
        System.err.println("Not found!\n\n");
        return null;
    }
    
    public Vehicle searchByName(String name){
        if(vList.isEmpty()){
            System.err.println("Empty List. Please add Vehicle!");
        }
        name = name.trim().toUpperCase();
        for (Vehicle vehicle : vList) {
            if(vehicle.getVehicleName().toLowerCase().contains(name.toLowerCase()))
                return vehicle;
        }
        System.err.println("Not found!\n\n");
        return null;
    }
    
    public void displayAll(){
        if(vList.isEmpty()){
            System.err.println("Empty List. Please add Vehicle!");
        }else{
            display(vList);
            System.out.println("\n\n");
        }
    }
    
    public void displayByPrice() {
        List<Vehicle> sortedList = null;
        if (vList.isEmpty()) {
            System.err.println("Empty List. Pleas add Vehicle!");
        } else {
            sortedList = (ArrayList<Vehicle>) vList;
            Comparator<Vehicle> descendingPriceSort = ((o1, o2) -> {
                if (o1.getVehiclePrice() < o2.getVehiclePrice()) {
                    return 1;
                }
                if (o1.getVehiclePrice() > o2.getVehiclePrice()) {
                    return -1;
                }
                return 0;
            });
            Collections.sort(sortedList, descendingPriceSort);
            display(sortedList);
            System.out.println("\n\n");
        }
    }
    
    public void display(List list){
        System.out.println("ID        NAME             COLOR            PRICE            BRAND         TYPE         PRODUCT YEAR    ");
        for (Object o : list) {
            System.out.println(o);
        }
    }
    
    public void loadData(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        try {

            while (true) {
                String line = br.readLine();
                if (line == null || line.isEmpty()) {
                    break;
                }
                String[] split = line.split(",");
                String vID = split[0].trim();
                String vName = split[1].trim();
                String vColor = split[2].trim();
                double vPrice = Double.parseDouble(split[3].trim());
                String vBrand = split[4].trim();
                String vType = split[5].trim();
                int productYear = Integer.parseInt(split[6].trim());

                vList.add(new Vehicle(vID, vName, vColor, vPrice, vBrand, vType, productYear));
            }
        } catch (Exception e) {

        } finally {
            br.close();
            fr.close();
        }
    }
    
   private void saveData(String fileName) throws IOException{
       File f = new File(fileName);
       FileWriter fw = new FileWriter(f);
       BufferedWriter bw = new BufferedWriter(fw);
       for (Vehicle vhc : vList) {
           bw.write(vhc.getVehicleID() + "," + vhc.getVehicleName() + "," + vhc.getVehicleColor() + "," + vhc.getVehiclePrice() + "," + vhc.getVehicleBrand() + "," + vhc.getType() +"," + vhc.getPruductYear() + "\n");
       }
       bw.close();
       fw.close();
   }
    
    public void save(String fileName){
        try{
            saveData(fileName);
            System.out.println("Vehicle is saved to " + fileName);
            System.out.println("\n");
            System.out.println("\n");
        }catch(Exception e){
            
        }
    }
}
