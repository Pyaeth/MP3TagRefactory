/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mp3tagrefactory.controller;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;

/**
 *
 * @author amicu
 */
public class Mp3Controller {
    
    private String filename;
    
    public Mp3Controller() {
    }

    public void refactorTitle(Mp3File mp3file) {
        if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2tag = mp3file.getId3v2Tag();
            filename = mp3file.getFilename();
            id3v2tag.setTitle(filename.split(" - ")[1]);
        }
    }
    
    public void refactorArtist(Mp3File mp3file) {
        if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2tag = mp3file.getId3v2Tag();
            filename = mp3file.getFilename();
            id3v2tag.setArtist(filename.split(" - ")[0]);
        }
    }
    
    public void refactorAlbumArtist(Mp3File mp3file) {
        if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2tag = mp3file.getId3v2Tag();
            filename = mp3file.getFilename();
            id3v2tag.setAlbumArtist(filename.split(" - ")[0]);
        }
    }
    
    public void refactorContributingArtists(Mp3File mp3file) {
        if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2tag = mp3file.getId3v2Tag();
            filename = mp3file.getFilename();
            id3v2tag.setComposer(filename.split(" - ")[0]);
        }
    }
    
    public void refactorTrackNo(Mp3File mp3file, int trackNo) {
        if (mp3file.hasId3v2Tag()) {
            mp3file.getId3v2Tag().setTrack(String.valueOf(trackNo));
        }
    }
    
    public void refactorYear(Mp3File mp3file, int year) {
        if (mp3file.hasId3v2Tag()) {
            mp3file.getId3v2Tag().setYear(String.valueOf(year));
        }
    }
    
    public void refactorGenre(Mp3File mp3file, int genre) {
        if (mp3file.hasId3v2Tag()) {
            mp3file.getId3v2Tag().setGenre(genre);
        }
    }

}
