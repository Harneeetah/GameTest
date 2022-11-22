package com.bignita;

import com.example.game.ISaveable;
import com.example.game.Monster;
import com.example.game.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player anita = new Player("anita",10,4);
        System.out.println(anita.toString());
        saveObject(anita);
        anita.setHitPoints(7);
        System.out.println(anita);
        anita.setWeapon("laser gun");
        saveObject(anita);
       // loadObject(anita);
        System.out.println(anita);


        ISaveable darkwolf = new Monster("darkwolf", 60,30);

        System.out.println(darkwolf);
        System.out.println("strength= "+ ((Monster)darkwolf).getStrength());
        saveObject(darkwolf);

    }
    public static ArrayList<String> readValues() {
            ArrayList<String> values = new ArrayList();
            Scanner scanner = new Scanner(System.in);
            boolean quit = false;
            int index = 0;
            System.out.println("Choose\n1 to enter a string\n0 to quit");

            while (!quit) {
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        quit = true;
                        break;
                    case 1:
                        System.out.print("Enter a string: ");
                        String stringInput = scanner.nextLine();
                        values.add(index, stringInput);
                        ++index;
                        break;
                }
            }
            return values;
     }

     public static void saveObject(ISaveable objectToSave){
        for(int i = 0; i<objectToSave.write().size(); i++){
            System.out.println("Saving " + objectToSave.write().get(i) +" to storage device");
        }
     }

     public static void loadObject(ISaveable objectToLoad){
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
     }
}