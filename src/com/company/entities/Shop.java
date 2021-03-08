package com.company.entities;

import com.sun.source.tree.UsesTree;

public class Shop {
    int id;
    String popcorn;
    String juice;
    String chips;
    String chocolate;
    public Shop(){
        popcorn = "";
        juice = "";
        chips = "";
        chocolate = "";
        id = 0;
    }
    public Shop(int id, String popcorn, String juice, String chips, String chocolate){
        this.id = id;
        this.chocolate = chocolate;
        this.chips = chips;
        this.juice = juice;
        this.popcorn = popcorn;
    }
    public Shop(String popcorn, String juice, String chips, String chocolate){
        this.chocolate = chocolate;
        this.chips = chips;
        this.juice = juice;
        this.popcorn = popcorn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPopcorn() {
        return popcorn;
    }

    public void setPopcorn(String popcorn) {
        this.popcorn = popcorn;
    }

    public String getChips() {
        return chips;
    }

    public void setChips(String chips) {
        this.chips = chips;
    }

    public String getChocolate() {
        return chocolate;
    }

    public void setChocolate(String chocolate) {
        this.chocolate = chocolate;
    }

    public String getJuice() {
        return juice;
    }

    public void setJuice(String juice) {
        this.juice = juice;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", popcorn=" + popcorn +
                ", juice='" + juice + '\'' +
                ", chips='" + chips + '\'' +
                ", chocolate='" + chocolate + '\'' +
                '}' + '\n';
    }
}
