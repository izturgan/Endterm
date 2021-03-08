package com.company.controller;

import com.company.Repository.interfaces.ICustomerRepository;
import com.company.entities.*;

import java.util.List;

public class Controller {
    private final ICustomerRepository repo;

    public Controller(ICustomerRepository repo) {
        this.repo = repo;
    }

    public String allClients(){
        List <String> Clients = repo.allCustomers();
        return Clients.toString();
    }

    public int createClient(Customer cur){
        int created = repo.createCustomer(cur);
        if(created == -1){
            System.out.println("Creation failed!");
        }
        else{
            System.out.println("Created successfully!");
        }
        return created;
    }

    public String getAllFilms(){
        List <Film> Films = repo.getAllFilms();
        return Films.toString();
    }

    public String getCustomersInFilm(int id){
        List <Customer> Customers = repo.getCustomersInFilm(id);
        return Customers.toString();
    }

    public String reserveFilm(int client_id, int film_id){
        boolean response = repo.reserveFilm(client_id, film_id);
        return (response ? "Reserved successfully" : "Reserve failed");
    }
    public String getAllRooms(){
        List <Room> Rooms = repo.getAllRooms();
        return Rooms.toString();
    }

    public String getCustomersInRoom(int id){
        List <Customer> Customers = repo.getCustomersInRoom(id);
        return Customers.toString();
    }

    public String reserveRoom(int client_id, int Room_id){
        boolean response = repo.reserveRoom(client_id, Room_id);
        return (response ? "Reserved successfully" : "Reserve failed");
    }

    public String getAllShops(){
        List <Shop> Shops = repo.getAllShops();
        return Shops.toString();
    }

    public String reserveShop(int client_id, int package_id){
        boolean response = repo.reserveShop(client_id, package_id);
        return (response ? "Reserved successfully" : "Reserve failed");
    }

    public String calculateClient(int client_id){
        int res = repo.calculateCustomer(client_id);
        return "Needed money: " + res;
    }
}
