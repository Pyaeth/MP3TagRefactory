/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mp3tagrefactory.controller;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import resources.SavedVariables;

/**
 *
 * @author amicu
 */
public class Mp3Controller {

    private String filename;

    public Mp3Controller() {
    }

    public void refactory(File file) {
         try {
            Mp3File mp3file = new Mp3File(file);
            Map<String, Boolean> opt = userOptions();
            for (String o : opt.keySet()) {
                if (opt.get(o)) {
                    mapMethodNames(o, new Mp3File(file));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void mapMethodNames(String methodName, Mp3File mp3file) {
        java.lang.reflect.Method method;
        Object object = new String(methodName);
        try {
            method = object.getClass().getMethod(methodName, Mp3File.class);
            method.invoke(null,mp3file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, Boolean> userOptions() {
        boolean isTitleSelected = SavedVariables.isTitleSelected;
        boolean isContributingArtistsSelected = SavedVariables.isContributingArtistsSelected;
        boolean isAlbumArtistsSelected = SavedVariables.isAlbumArtistsSelected;
        boolean isAlbumSelected = SavedVariables.isAlbumSelected;
        boolean isYearSelected = SavedVariables.isYearSelected;
        boolean isTrackNoSelected = SavedVariables.isTrackNoSelected;
        boolean isGenreSelected = SavedVariables.isGenreSelected;
        Map<String, Boolean> options = new HashMap<>();
        options.put("refactorTitle", isTitleSelected);
        options.put("refactorAlbumArtist", isAlbumArtistsSelected);
        options.put("refactorAlbum", isAlbumSelected);
        options.put("refactorYear", isYearSelected);
        options.put("refactorTrackNo", isTrackNoSelected);
        options.put("refactorGenre", isGenreSelected);
        options.put("refactorContributingArtists", isContributingArtistsSelected);
        return options;
    }

    public void refactorTitle(Mp3File mp3file) {
        if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2tag = mp3file.getId3v2Tag();
            filename = mp3file.getFilename();
            id3v2tag.setTitle(filename.split(" - ")[1]);
        }
    }

    public void refactorAlbum(Mp3File mp3file) {
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
