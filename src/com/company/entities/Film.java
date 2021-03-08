package com.company.entities;

public class Film {
    int id;
    int rating;
    String genre;
    int year;
    int duration;
    String time;
    int price;
    public Film(){
       id = 0;
       rating = 0;
       genre = "";
       year = 0;
       duration = 0;
       time = "";
    }
    public Film(int id, int rating, String genre, int year, int duration, String time, int price){
        this.id = id;
        this.year = year;
        this.rating = rating;
        this.genre = genre;
        this.duration = duration;
        this.time = time;
        this.price = price;
    }
    public Film(int rating, String genre, int year, int duration, String time, int price){
        this.year = year;
        this.rating = rating;
        this.genre = genre;
        this.duration = duration;
        this.time = time;
        this.price = price;
    }
    public int getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public int getRating() {
        return rating;
    }

    public String getTime() {
        return time;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", rating=" + rating +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                ", time=" + time +
                ", price=" + price +
                '}' + '\n';
    }
}
