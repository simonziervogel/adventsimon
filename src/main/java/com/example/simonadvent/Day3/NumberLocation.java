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
    public NumberLocation(int startlocation, String number, boolean countable) {
        this.startlocation = startlocation;
        this.number = number;
        this.countable = countable;

    }

    public int getLocation(){
        return this.startlocation;
    }

    public String getNumber(){
        return this.number;
    }

    public boolean getCountable() {
        return this.countable;
    }

    public void setCountableTrue() {
        this.countable = true;
    }
}
