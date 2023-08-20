package com.workintech.library.model;

public class Cleaner extends  Person{

    private boolean isAvailable;
    public Cleaner(int id, String name) {
        super(id, name);
    }

    public void performCleaning() {
        if (!isAvailable) {
            System.out.println("Cleaner isnt available for cleaning.");

        }else
        System.out.println("Cleaner is performing cleaning tasks.");
    }
}
