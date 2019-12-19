package com.mp3tagrefactory.view;

import com.mp3tagrefactory.controller.Mp3Controller;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import resources.SavedVariables;

/**
 *
 * @author amicu
 */
public class RefactoryFrame extends javax.swing.JFrame implements ItemListener {

    public DefaultListModel<String> model;
    private ArrayList<String> tracks = null;
    private ArrayList<File> files;
    private File selectedFolder;

    public RefactoryFrame() {
        //setUndecorated(true);
        initComponents();
        setResizable(true);
        setLocationRelativeTo(null);
        jButton2.setEnabled(false);
        setVisible(true);

        model = new DefaultListModel();
        jList1.setModel(model);
        jButton1.addActionListener(ev -> selectFolder(ev));
        jMenuItem4.addActionListener(ev -> System.exit(0));
        jButton2.addActionListener(ev -> startRefactory());
        jButton3.addActionListener(ev -> openFolder());

        jCheckBox1.addItemListener(this);
        jCheckBox2.addItemListener(this);
        jCheckBox3.addItemListener(this);
        jCheckBox4.addItemListener(this);
        jCheckBox5.addItemListener(this);
        jCheckBox6.addItemListener(this);
        jCheckBox7.addItemListener(this);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();
        if (source == jCheckBox1) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                SavedVariables.setIsContributingArtistsSelected(true);
            }
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                SavedVariables.setIsContributingArtistsSelected(false);
            }
        }

        if (source == jCheckBox2) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                SavedVariables.setIsTitleSelected(true);
            }
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                SavedVariables.setIsTitleSelected(false);
            }
        }

        if (source == jCheckBox3) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                SavedVariables.setIsAlbumSelected(true);
            }
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                SavedVariables.setIsAlbumSelected(false);
            }
        }

        if (source == jCheckBox4) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                SavedVariables.setIsYearSelected(true);
            }
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                SavedVariables.setIsYearSelected(false);
            }
        }

        if (source == jCheckBox5) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                SavedVariables.setIsAlbumArtistsSelected(true);
            }
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                SavedVariables.setIsAlbumArtistsSelected(false);
            }
        }

        if (source == jCheckBox6) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                SavedVariables.setIsGenreSelected(true);
            }
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                SavedVariables.setIsGenreSelected(false);
            }
        }

        if (source == jCheckBox7) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                SavedVariables.setIsTrackNoSelected(true);
            }
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                SavedVariables.setIsTrackNoSelected(false);
            }
        }

    }

    private void selectFolder(ActionEvent e) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFolder = jfc.getSelectedFile();
            files = Arrays.asList(selectedFolder.listFiles()).stream()
                    .filter(elem -> elem.getName().endsWith(".mp3"))
                    .collect(Collectors.toCollection(ArrayList::new));
            tracks = files.stream()
                    .map(f -> f.getName())
                    .collect(Collectors.toCollection(ArrayList::new));
            if (!tracks.isEmpty()) {
                jButton2.setEnabled(true);
            }
            listTracks();
        }
    }
    
    private void openFolder() {
        try {
            Desktop.getDesktop().open(selectedFolder);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No selected folder found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listTracks() {
        model.clear();
        if (tracks != null && !tracks.isEmpty()) {
            tracks.forEach(model::addElement);
        } else {
            JOptionPane.showMessageDialog(null, "No mp3 files found in the selected folder.");
        }
    }

    private void startRefactory() {
        try {
            Mp3Controller controller = new Mp3Controller();
            files.stream().forEach(controller::refactory);
        } catch (Exception ex) {
            Logger.getLogger(RefactoryFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Please select the desired location of your music files: ");

        jButton1.setBackground(new java.awt.Color(240, 0, 0));
        jButton1.setText("Select folder");

        jScrollPane1.setViewportView(jList1);

        jLabel4.setText("Choose which fields to populate:");

        jCheckBox1.setText("Contributing artists");
        jCheckBox1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCheckBox2.setText("Title");
        jCheckBox2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCheckBox3.setText("Album");
        jCheckBox3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCheckBox4.setText("Year");
        jCheckBox4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCheckBox5.setText("Album artist");
        jCheckBox5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCheckBox6.setText("Genre");
        jCheckBox6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCheckBox7.setText("Track no.#");
        jCheckBox7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton2.setBackground(new java.awt.Color(24, 240, 24));
        jButton2.setText("START!");

        jLabel2.setText("Operation details:");

        jButton3.setBackground(new java.awt.Color(240, 0, 240));
        jButton3.setText("Open folder");

        jMenu1.setText("File");

        jMenuItem3.setText("Preferences");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Logout");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 22, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox2)
                                            .addComponent(jCheckBox1)
                                            .addComponent(jCheckBox5)
                                            .addComponent(jCheckBox3)
                                            .addComponent(jCheckBox4)
                                            .addComponent(jCheckBox7)
                                            .addComponent(jCheckBox6))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4, jCheckBox5, jCheckBox6, jCheckBox7});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox6)
                        .addGap(35, 35, 35)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCheckBox1, jCheckBox2, jCheckBox3, jCheckBox4, jCheckBox5, jCheckBox6, jCheckBox7});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
