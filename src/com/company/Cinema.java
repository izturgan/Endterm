package com.company;

import com.company.entities.*;
import com.company.controller.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Cinema {
    private final Controller controller;
    private final Scanner scanner;

    public Cinema(Controller controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Good day, we wish you good luck in booking tickets");
        System.out.println("If you already have an account write number 1");
        System.out.println("If you want to register write number 2");
        int opt = scanner.nextInt();
        int id = 0;
        scanner.nextLine();
        if(opt == 1) {
            String res = allClientsMenu();
            System.out.println(res);
            System.out.println("Select an account");
            id = scanner.nextInt();
            scanner.nextLine();
        }
        else {
            id = createClientMenu();
        }
        while(true){
            System.out.println("Select option: (0 - 4)");
            System.out.println("Enter 1 if you want to book/reserve Room");
            System.out.println("Enter 2 if you want to book/reserve Film");
            System.out.println("Enter 3 if you want to select something Shop");
            System.out.println("Enter 4 if you want to calculate the money needed");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter the option: (0-4)");
                int option = scanner.nextInt();
                scanner.nextLine();
                if(option == 1){
                    reserveRoomMenu(id);
                }
                else if(option == 2) {
                    reserveFilmMenu(id);
                }
                else if(option == 3){
                    selectShopMenu(id);
                }
                else if(option == 4){
                    calculateClientMenu(id);
                }
                else{
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("----------------------------------------");
        }
    }

    public String allClientsMenu(){
        System.out.println("Here is the list of accounts: ");
        String res = controller.allClients();
        return res;
    }

    public int createClientMenu(){
        System.out.println("Please give some information about yourself, please");
        System.out.println("Please enter name");
        String name = scanner.nextLine();
        System.out.println("Please enter surname");
        String surname = scanner.nextLine();
        System.out.println("Please enter age");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter gender");
        String gender = scanner.nextLine();
        System.out.println("Please enter mail");
        String mail = scanner.nextLine();
        System.out.println("Please enter your city");
        String city = scanner.nextLine();
        System.out.println("Please enter your phonenumber");
        String phonenumber = scanner.nextLine();
        Customer cur = new Customer(name, surname, age, gender, mail,city,phonenumber,0,0,0);
        int id = controller.createClient(cur);
        System.out.println(id);
        return id;
    }

    public void reserveRoomMenu(int id){
        System.out.println("1. See the Rooms list");
        System.out.println("2. See customers list in exact Room");
        System.out.println("3. Book the seat in the Room");
        System.out.println("Enter 0 if you want to exit");
        try {
            int option = -1;
            while(option != 2 || option != 3 || option != 0) {
                System.out.println("Enter the option: (0 - 3)");
                option = scanner.nextInt();
                scanner.nextLine();
                if(option == 0){
                    return;
                }
                if (option == 1) {
                    String response = controller.getAllRooms();
                    System.out.println(response);
                } else if (option == 2) {
                    System.out.println("Please enter id of Room");
                    int curid = scanner.nextInt();
                    scanner.nextLine();
                    String response = controller.getCustomersInRoom(curid);
                    System.out.println(response);
                } else if (option == 3) {
                    System.out.println("Please enter id of Room");
                    int curid = scanner.nextInt();
                    scanner.nextLine();
                    String response = controller.reserveRoom(id, curid);
                    System.out.println(response);
                } else {
                    System.out.println("Input must be in range between 0 and 3!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void reserveFilmMenu(int id){
        System.out.println("1. See the Films list");
        System.out.println("2. See customers list in exact Film");
        System.out.println("3. Book the seat in the Film");
        System.out.println("Enter 0 if you want to exit");
        try {
            int option = -1;
            while(option != 2 || option != 3 || option != 0) {
                System.out.println("Enter the option: (0 - 3)");
                option = scanner.nextInt();
                scanner.nextLine();
                if(option == 0){
                    return;
                }
                if (option == 1) {
                    String response = controller.getAllFilms();
                    System.out.println(response);
                } else if (option == 2) {
                    System.out.println("Please enter id of Film");
                    int curid = scanner.nextInt();
                    scanner.nextLine();
                    String response = controller.getCustomersInFilm(curid);
                    System.out.println(response);
                } else if (option == 3) {
                    System.out.println("Please enter id of Film");
                    int curid = scanner.nextInt();
                    scanner.nextLine();
                    String response = controller.reserveFilm(id, curid);
                    System.out.println(response);
                } else {
                    System.out.println("Input must be in range between 0 and 3!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void selectShopMenu(int id){
        System.out.println("1. See all packages of snacks");
        System.out.println("2. Select package Id");
        System.out.println("Enter 0 if you want to exit");
        try {
            int option = -1;
            while(option != 2 || option != 0) {
                System.out.println("Enter the option: (0 - 2)");
                option = scanner.nextInt();
                scanner.nextLine();
                if(option == 0){
                    return;
                }
                if (option == 1) {
                    String response = controller.getAllShops();
                    System.out.println(response);
                } else if (option == 2) {
                    System.out.println("Please enter id of package");
                    int curid = scanner.nextInt();
                    scanner.nextLine();
                    String response = controller.reserveShop(id, curid);
                    System.out.println(response);
                } else {
                    System.out.println("Input must be in range between 0 and 2!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void calculateClientMenu(int id){
        String response = controller.calculateClient(id);
        System.out.println(response);
    }

}
