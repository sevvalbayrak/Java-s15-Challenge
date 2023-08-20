package com.workintech.library.model;

import com.workintech.library.interfaces.Listenable;
import com.workintech.library.interfaces.Watchable;

public class Film extends Artifacts implements Watchable, Listenable {

private int time;
    public Film(String name, String author, boolean available,int time) {
        super(name, author, available);
        this.time =time;
    }


    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public void listen() {

    }

    @Override
    public void watch() {

    }
}

