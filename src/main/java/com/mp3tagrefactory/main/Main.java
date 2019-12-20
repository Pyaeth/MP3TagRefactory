package com.mp3tagrefactory.main;

import com.mp3tagrefactory.controller.WebQueryController;
import com.mp3tagrefactory.view.LoginFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class Main {

    public static void main(String[] args) {
        WebQueryController wqc = new WebQueryController("Wham - Last Christmas");
        try {
            // Set System L&F
        UIManager.setLookAndFeel(
            "javax.swing.plaf.metal.MetalLookAndFeel");
        MetalLookAndFeel.setCurrentTheme(new OceanTheme());
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
        new LoginFrame();
    }
    
}
