package com.example.simonadvent.Day3;

public class NumberLocation {
    private int startlocation;
    private String number;
    private boolean countable;

    public NumberLocation(int startlocation, String number){
        this.startlocation = startlocation;
        this.number = number;
        countable = false; //default werden wenn Nummern aus line extracted und als numberlocation object erstellt werden--> noch nciht countable
    }

    public int getLocation(){
        return this.startlocation;
    }

    public String getNumber(){
        return this.number;
    }

    public String getCountable() {
        return this.countable ? "YES" : "NO";
    }

    public void setCountable() {
        this.countable = true;
    }
}
