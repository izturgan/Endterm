package com.company.Repository.interfaces;

import com.company.controller.Controller;
import com.company.entities.*;

import java.util.List;

public interface ICustomerRepository {
    List <String> allCustomers();
    int createCustomer(Customer cur);
    int calculateCustomer(int customer_id);
    List <Film> getAllFilms();
    List <Customer> getCustomersInFilm(int id);
    boolean reserveFilm(int customer_id,int film_id);
    List <Room> getAllRooms();
    List <Customer> getCustomersInRoom(int id);
    boolean reserveRoom(int customer_id,int room_id);
    List <Shop> getAllShops();
    boolean reserveShop(int customer_id,int package_id);
}