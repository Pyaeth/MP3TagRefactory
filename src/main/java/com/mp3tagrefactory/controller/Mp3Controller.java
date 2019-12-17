/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mp3tagrefactory.controller;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import java.io.File;
import java.util.Arrays;
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
            Map<String, Boolean> opt = SavedVariables.getSavedVariables();
            for (String o : opt.keySet()) {
                if (opt.get(o)) {
                    mapMethodNames(o, new Mp3File(file), file);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void mapMethodNames(String methodName, Mp3File mp3file, File originalFile) {
        java.lang.reflect.Method method;
        try {
            method = Mp3Controller.class.getMethod(methodName, Mp3File.class);
            method.invoke(this,mp3file);
            mp3file.save(filename+"(1)");
            String fileBackup = originalFile.getAbsolutePath();
            originalFile.delete();
            File file2 = new File(fileBackup+"(1)");
            file2.renameTo(new File(fileBackup));
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refactorTitle(Mp3File mp3file) {
        if (mp3file.hasId3v2Tag()) {
            ID3v2 id3v2tag = mp3file.getId3v2Tag();
            filename = mp3file.getFilename();
            id3v2tag.setTitle(filename.split(" - ")[1].split("\\.")[0]);
            //System.out.println(mp3file.getId3v2Tag().getTitle());
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