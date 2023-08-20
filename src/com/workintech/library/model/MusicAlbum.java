package com.workintech.library.model;

import com.workintech.library.interfaces.Listenable;

public class MusicAlbum extends Artifacts implements Listenable {

    private int numberOfSongs;

    public MusicAlbum(String name, String author, boolean available,int numberOfSongs) {
        super(name, author, available);
        this.numberOfSongs=numberOfSongs;
    }


    @Override
    public void listen() {

    }
}
