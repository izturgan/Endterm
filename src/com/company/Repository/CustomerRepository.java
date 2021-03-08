package com.company.Repository;

import com.company.Repository.interfaces.ICustomerRepository;
import com.company.data.IPostgresDB;
import com.company.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final IPostgresDB database;

    public CustomerRepository(IPostgresDB database){this.database = database;}

    @Override
    public List<String> allCustomers() {
        Connection con = null;
        try {
            List <String> accounts = new ArrayList<String>();
            con = database.getConnection();
            String sql = "Select * FROM customers";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("customer_id");
                String email = rs.getString("mail");
                accounts.add(id + "   |   " + email + "\n");
            }
            return accounts;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public int getLastId(){
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "Select * FROM customers";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int last = 0;
            while(rs.next()){
                int id = rs.getInt("customer_id");
                last = id;
            }
            return last;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public int createCustomer(Customer customer) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "INSERT INTO customers(customer_id, first_Name, last_Name, mail, gender, city, phonenumber, film_id, room_id, package_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            int id = getLastId();
            if(id == -1){
                id = 1;
            }
            else{
                id++;
            }
            st.setInt(1, id);
            st.setString(2, customer.getFirstName());
            st.setString(3, customer.getSecondName());
            st.setString(4, customer.getMail());
            st.setString(5, customer.getGender());
            st.setString(6, customer.getCity());
            st.setString(7, customer.getPhonenumber());
            st.setInt(8, 0);
            st.setInt(9, 0);
            st.setInt(10, 0);
            st.execute();
            return id;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public List<Room> getAllRooms(){
        Connection con = null;
        try {
            List <Room> rooms = new ArrayList<Room>();
            con = database.getConnection();
            String sql = "Select * FROM Room";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Room pl = new Room(rs.getInt("id"),
                        rs.getString("type"),
                        rs.getInt("seat_number"));
                rooms.add(pl);
            }
            return rooms;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Film> getAllFilms(){
        Connection con = null;
        try {
            List <Film> films = new ArrayList<Film>();
            con = database.getConnection();
            String sql = "Select * FROM Film";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Film pl = new Film(
                        rs.getInt("id"),
                        rs.getInt("rating"),
                        rs.getString("genre"),
                        rs.getInt("year"),
                        rs.getInt("duration"),
                        rs.getString("time"),
                        rs.getInt("price")
                );
                films.add(pl);
            }
            return films;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Customer> getCustomersInFilm(int id) {
        Connection con = null;
        try {
            List <Customer> customers = new ArrayList<Customer>();
            con = database.getConnection();
            String sql = "Select * FROM Customers where film_id=" + id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Customer cl = new Customer(rs.getInt("customer_id"),
                        rs.getString("first_Name"),
                        rs.getString("last_Name"),
                        rs.getInt("age"),
                        rs.getString("mail"),
                        rs.getString("gender"),
                        rs.getString("city"),
                        rs.getString("phonenumber"),
                        rs.getInt("film_id"),
                        rs.getInt("room_id"),
                        rs.getInt("package_id"));
                customers.add(cl);
            }
            return customers;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean reserveFilm(int film_id, int customer_id) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "UPDATE Customers SET film_id=" + film_id + " WHERE customer_id=" + customer_id;
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Customer> getCustomersInRoom(int id) {
        Connection con = null;
        try {
            List <Customer> customers = new ArrayList<Customer>();
            con = database.getConnection();
            String sql = "Select * FROM customers where room_id=" + id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Customer cl = new Customer(rs.getInt("customer_id"),
                        rs.getString("first_Name"),
                        rs.getString("last_Name"),
                        rs.getInt("age"),
                        rs.getString("mail"),
                        rs.getString("gender"),
                        rs.getString("city"),
                        rs.getString("phonenumber"),
                        rs.getInt("film_id"),
                        rs.getInt("room_id"),
                        rs.getInt("package_id"));
                customers.add(cl);
            }
            return customers;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean reserveRoom(int room_id, int customer_id) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "UPDATE customers SET room_id=" + room_id + " WHERE customer_id=" + customer_id;
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Shop> getAllShops() {
        Connection con = null;
        try {
            List <Shop> shops = new ArrayList<Shop>();
            con = database.getConnection();
            String sql = "Select * FROM Shop";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Shop cn = new Shop(rs.getInt("id"),
                        rs.getString("popcorn"),
                        rs.getString("juice"),
                        rs.getString("chips"),
                        rs.getString("chocolate"));
                shops.add(cn);
            }
            return shops;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean reserveShop(int shop_id, int customer_id) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "Update customers SET package_id=" + shop_id + " WHERE customer_id=" + customer_id;
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public int calculateCustomer(int customer_id) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "SELECT * from customers where customer_id=" + customer_id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int film_id = 0;
            int total = 0;
            if(rs.next()){
                film_id = rs.getInt("Film_id");
            }
            else{
                return 0;
            }
            sql = "SELECT * from Film where id=" + film_id;
            rs = st.executeQuery(sql);
            if(rs.next()){
                total += rs.getDouble("price");
            }
            else{
                return 0;
            }
            return total;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }
}
