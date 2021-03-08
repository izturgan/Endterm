package com.company.entities;

import java.util.List;

public class Room {
    int id;
    String type;
    List <Integer>  seats;
    int seatNum;


    public Room(){
        seats = null;
    }
    public Room( int id,String type, int seatNum){
        this.id = id;
        this.type = type;
        this.seatNum = seatNum;
    }
    public void setCities(List<Integer> seats) {
        this.seats = seats;
    }

    public List<Integer> getSeats() {
        return seats;
    }

    public void setSeats(List<Integer> seats) {
        this.seats = seats;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", seats=" + seats +
                ", seatNum=" + seatNum +
                '}' + '\n';
    }
}
