/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImagenEditor {
    
    private BufferedImage i;
    private float contrast = 1f;
    private float brightness = 1f;
    private Imagen img;
    
    public ImagenEditor(Imagen img){
        this.img = img;
        try{
            i = ImageIO.read(new File(img.getContent()));
        }catch(IOException e){
                
        }
    }
    
    public void setBlackWhite(){
        int w = i.getWidth();
        int h = i.getHeight();
        for(int n = 0; n < h; n++){
            for(int m = 0; m < w; m++){
               Color c = new Color(i.getRGB(m, n));
               int red = (int)(c.getRed() * 0.299);
               int green = (int)(c.getGreen() * 0.587);
               int blue = (int)(c.getBlue() *0.114);
               Color newColor = new Color(red+green+blue,
               red+green+blue,red+green+blue);
               i.setRGB(m, n, newColor.getRGB());
            }
        }
    }
    
    public void setBrightness(float nBrightness){
        RescaleOp r = new RescaleOp(1f, brightness+nBrightness, null);
        i = r.filter(i, null);
    }
    
    public void setContrast(float nContrast){
        RescaleOp r = new RescaleOp(contrast+nContrast, 1f, null);
        i = r.filter(i, null);
    }
    
    public BufferedImage getBufferedImage(){
        return i;
    }
    
    public void setBufferedImage(String s){
        try{
            i = ImageIO.read(new File(s));
        }catch(IOException e){
                
        }
    }
    public void saveImage(){
        String dir;
        dir = img.getContent();
        File outputFile = new File(dir);
        try{
            ImageIO.write(i, "jpg", outputFile);
        }catch(IOException e2){
            
        }
        
    }
    
}
