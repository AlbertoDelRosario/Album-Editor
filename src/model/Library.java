/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.util.ArrayList;

public class Library {
    public ArrayList<Imagen>images;
    public ArrayList<Page>styles;
    private int imgCounter;
    
    public Library(){
        images = new ArrayList<Imagen>();
        styles = new ArrayList<Page>();
        imgCounter = 0;
    }
    public void addStyle(){
        int num = styles.size();
        styles.add(new Page((num + 1)));
    }
    
    public void addStyleItem(int pg, int id, int posX, int posY, int sizeX, int sizeY, int type){
        
        if(type == 1){
            Item newItem = new Text(0, id, posX, posY, sizeX, sizeY);
            newItem.setContent("Insert Text");
            styles.get(pg).addItem(newItem);
        }else{
            Item newItem = new Imagen(0, id, posX, posY, sizeX, sizeY);
            newItem.setContent("library/stockImg.jpg");
            styles.get(pg).addItem(newItem);
        }
            
    }
    
    public void addImagen(String dir){
        File image = new File(dir);
        String name = new String("img" + imgCounter);
        Imagen img = new Imagen(0,imgCounter,name,0,0,0,0,dir);
        imgCounter++;
        images.add(img);
    }
    
    public void removeImagen(int id){
        images.remove(id);
    }
}