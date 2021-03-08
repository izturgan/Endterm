package com.company;

import com.company.Repository.CustomerRepository;
import com.company.Repository.interfaces.ICustomerRepository;
import com.company.controller.Controller;
import com.company.data.IPostgresDB;
import com.company.data.PostgresDB;

public class Main {

    public static void main(String[] args) {
        IPostgresDB db = new PostgresDB();
        ICustomerRepository repo = new CustomerRepository(db);
        Controller controller = new Controller(repo);
        Cinema app = new Cinema(controller);
        app.start();
    }
}
