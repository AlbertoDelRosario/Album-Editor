/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import model.ImagenEditor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author Héctor
 */
public class EditorForm extends JFrame {
    
    
    private JButton blancoNegro;
    private JButton saveImage;
    private JButton dContrast;
    private JButton iContrast;
    private JButton dBrightness;
    private JButton iBrightness;
    private JLabel brightnessLabel;
    private JLabel contrastLabel;
    private JPanel panelImagen;
    private ImagePanel imagen;
    private ImagenEditor editor;
    
    public EditorForm(){
        initComponents();
    }
    
    private void initComponents() {

        panelImagen = new javax.swing.JPanel();
        imagen = new ImagePanel();
        blancoNegro = new javax.swing.JButton();
        saveImage = new javax.swing.JButton();
        brightnessLabel = new javax.swing.JLabel();
        contrastLabel = new javax.swing.JLabel();
        dContrast = new javax.swing.JButton();
        iContrast = new javax.swing.JButton();
        dBrightness = new javax.swing.JButton();
        iBrightness = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setResizable(false);

        panelImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelImagen.setToolTipText("");

        javax.swing.GroupLayout imagenLayout = new javax.swing.GroupLayout(imagen);
        imagen.setLayout(imagenLayout);
        imagenLayout.setHorizontalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imagenLayout.setVerticalGroup(
            imagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        blancoNegro.setText("White/Black");
        blancoNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blancoNegroActionPerformed(evt);
            }
        });

        saveImage.setText("Save image");
        saveImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImageActionPerformed(evt);
            }
        });

        brightnessLabel.setText("brightness");
        brightnessLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        contrastLabel.setText("Contrast");
        contrastLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        dContrast.setText("-");
        dContrast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dContrastActionPerformed(evt);
            }
        });

        iContrast.setText("+");
        iContrast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iContrastActionPerformed(evt);
            }
        });

        dBrightness.setText("-");
        dBrightness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dBrightnessActionPerformed(evt);
            }
        });

        iBrightness.setText("+");
        iBrightness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iBrightnessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(saveImage)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(blancoNegro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                                        .addComponent(contrastLabel))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 231, Short.MAX_VALUE)
                                .addComponent(brightnessLabel)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dContrast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dBrightness))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(iContrast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(iBrightness))
                        .addGap(21, 21, 21)))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dContrast)
                        .addComponent(iContrast)
                        .addComponent(contrastLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blancoNegro)
                        .addGap(12, 12, 12)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(brightnessLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dBrightness)
                        .addComponent(iBrightness)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(saveImage)
                .addContainerGap())
        );

        pack();
    }
    
    private void dContrastActionPerformed(java.awt.event.ActionEvent evt) {                                          
        editor.setContrast(-0.1f);
        imagen.paintComponent(imagen.getGraphics());
    } 
    
    private void iContrastActionPerformed(java.awt.event.ActionEvent evt) {                                          
        editor.setContrast(0.1f);
        imagen.paintComponent(imagen.getGraphics());
    }
    
    private void blancoNegroActionPerformed(ActionEvent evt) {                                            
        editor.setBlackWhite();
        imagen.paintComponent(imagen.getGraphics());
    }
    
    private void dBrightnessActionPerformed(java.awt.event.ActionEvent evt) {                                            
        editor.setBrightness(-10f);
        imagen.paintComponent(imagen.getGraphics());
    }                                           

    private void iBrightnessActionPerformed(java.awt.event.ActionEvent evt) {                                            
        editor.setBrightness(10f);
        imagen.paintComponent(imagen.getGraphics());
    }     
    
    private void saveImageActionPerformed(java.awt.event.ActionEvent evt) {                                            
        editor.saveImage();
        setVisible(false);
    }
        
    private class ImagePanel extends JPanel{      
        @Override
        public void paintComponent(Graphics g){
            BufferedImage tThumbImage = new BufferedImage( 397, 160, BufferedImage.TYPE_INT_RGB );
            g.drawImage( editor.getBufferedImage(), 0, 0, 397, 160, null ); //draw the image scaled
        }
    }
    
    public void assignEditor(ImagenEditor i){
        editor = i;
    }
}
