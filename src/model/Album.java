/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

public class Album {
    public String albumName;
    public Page style;
    public ArrayList<Page>albumPages;
    public int txtCounter;
    public int imgCounter;
    
    public Album(){
        style = new Page(0);
        albumPages = new ArrayList<Page>();
    }
    
    public void addStyle(int id, int posX, int posY, int sizeX, int sizeY, int type){
        
        if(type == 1){
            Item newItem = new Text(0, id, posX, posY, sizeX, sizeY);
            style.addItem(newItem);
        }else{
            Item newItem = new Imagen(0, id, posX, posY, sizeX, sizeY);
            style.addItem(newItem);
        }
            
    }
    
    public void addPage(){
        int i, num = albumPages.size();
        albumPages.add(new Page((num + 1)));
        for (i = 0;i < style.items.size();i++){
            Item style = this.style.items.get(i);
            if (style instanceof Text){
                txtCounter++;
                Item txt = new Text(num, style.getId(), style.getPosX(), style.getPosY(), style.getSizeX(), style.getSizeY());
                String data = "Insert Text";
                txt.setContent(data);
                txt.setName("txt" + txtCounter);
                albumPages.get(num).addItem(txt);

            }else{
                imgCounter++;
                Item img = new Imagen(num, style.getId(), style.getPosX(), style.getPosY(), style.getSizeX(), style.getSizeY());
                img.setContent("library/stockImg.jpg");
                img.setName("img" + imgCounter);
                albumPages.get(num).addItem(img);
               
            }
        }
    }
    
    public void removePage(int pn){
        int i;
        albumPages.remove((pn));
        for(i = pn; i < albumPages.size(); i++){
            albumPages.get(i).setPageNum(i + 1);
        }
    }
    
}
