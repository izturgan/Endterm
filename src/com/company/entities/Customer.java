package com.company.entities;

public class Customer {
    int id;
    String firstName;
    String secondName;
    int age;
    String mail;
    String gender;
    String city;
    String phonenumber;
    int film_id;
    int room_id;
    int package_id;
    public Customer() {
        firstName = "";
        secondName = "";
        age = 0;
        gender = "";
        mail = "";
        city = "";
        phonenumber = "";
    }

    public Customer(int id, String firstName, String secondName, int age, String gender, String mail, String city, String phonenumber, int film_id, int room_id, int package_id) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.gender = gender;
        this.mail = mail;
        this.phonenumber = phonenumber;
        this.city = city;
        this.film_id = film_id;
        this.room_id = room_id;
        this.package_id = package_id;
    }

    public Customer(String firstName, String secondName, int age, String gender, String mail, String city, String phonenumber, int film_id, int room_id, int package_id) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.mail = mail;
        this.phonenumber = phonenumber;
        this.city = city;
        this.film_id = film_id;
        this.room_id = room_id;
        this.package_id = package_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public int getPackage_id() {
        return package_id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getCity() {
        return city;
    }

    public String getMail() {
        return mail;
    }

    public void setmail(String mail) {
        this.mail = mail;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", mail='" + mail + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", film_id=" + film_id +
                ", room_id=" + room_id +
                ", package_id=" + package_id +
                '}';
    }
}

