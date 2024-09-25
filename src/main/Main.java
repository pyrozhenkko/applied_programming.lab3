package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import battle.*;
import droids.Droid;
import droids.CasualDroid;
import droids.LifestealerDroid;
import droids.RegenerationDroid;

public class Main {
    public static void main(String[] args) {
        List<Droid> droid_list = new ArrayList<>();
        System.out.println("Welcome to the Droids program\n");
        menuPanel(droid_list);
    }
    public static void createDroid( List droid_list){
        System.out.println("Choose the droid you want to create: ");
        droidMenu();
        String choice =new Scanner(System.in).nextLine();
        switch(choice){
            case "1":{
                System.out.println("Enter the name of the droid: ");
                String name = new Scanner(System.in).nextLine();
                CasualDroid droid = new CasualDroid(name, 150, 15);
                droid_list.add(droid);
                break;
            }
            case "2":{
                System.out.println("Enter the name of the droid: ");
                String name = new Scanner(System.in).nextLine();
                LifestealerDroid droid = new LifestealerDroid(name, 100, 7,0.5);
                droid_list.add(droid);
                break;
            }
            case "3":{
                System.out.println("Enter the name of the droid: ");
                String name = new Scanner(System.in).nextLine();
                RegenerationDroid droid = new RegenerationDroid(name, 120, 5,5);
                droid_list.add(droid);
                break;
            }
            case "4":
                menuPanel(droid_list);
                break;
            default: System.out.println("Invalid choice. Try again!");
                break;
        }
        createDroid(droid_list);

    }
    public static void deleteDroid(List<Droid> droid_list){
        if(droid_list.isEmpty()){
            System.out.println("There isnt droid to delete: \n");
            menuPanel(droid_list);
        }
        System.out.println("Enter the name of the droid: ");
        String name =new Scanner(System.in).nextLine();
        for(Droid droid: droid_list){
            if(droid.getName().equals(name)){
                droid_list.remove(droid);
            }
        }
    }
    public static void printDroidList(List<Droid> droid_list){
        if(droid_list.isEmpty()){
            System.out.println("There is no droid\n");
            menuPanel(droid_list);
        }else{
            for(Droid droid : droid_list){
                droid.show();
            }
        }
    }
    public static void menuPanel(List<Droid> droid_list){
        System.out.println("Choose an option: ");
        menu();
        String choice = new Scanner(System.in).nextLine();
        switch(choice){
            case "1":createDroid(droid_list);break;
            case "2":deleteDroid(droid_list);break;
            case "3":printDroidList(droid_list);break;
            case "4": Battle1Vs1.Battle(droid_list); break;
            case "5":
                BattleTeamVsTeam.Battle(droid_list);
                break;
            case "6": ReadFile.reading();
            case "7": return;
            default: System.out.println("Invalid choice. Try again!");
            menuPanel(droid_list);
            break;
        }
    }
    public static void menu(){
        System.out.println("1. Create a droid");
        System.out.println("2. Delete a droid");
        System.out.println("3. Show all created droids");
        System.out.println("4. Droid fight (1vs1)");
        System.out.println("5. Droid fight (team vs team)");
        System.out.println("6. Read a file");
        System.out.println("7. Exit");
    }
    public static void droidMenu(){
        System.out.println("1. Casual Droid");
        System.out.println("2. Lifestealer Droid");
        System.out.println("3. Regeneration Droid");
        System.out.println("4. Back to the menu");
    }
}
