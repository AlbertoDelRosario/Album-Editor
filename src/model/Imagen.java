/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Imagen extends Item{
    private String imgDir;
    
    Imagen(int pn, int id, String name, int posX, int posY, int sizeX, int sizeY, String dir){
        setPos(posX, posY);
        setSize(sizeX, sizeY);
        setName(name);
        setPage(pn);
        setId(id);
        this.imgDir = dir;
    }
    
    public Imagen(int pn, int id, int posX, int posY, int sizeX, int sizeY){
        setPos(posX, posY);
        setSize(sizeX, sizeY);
        setPage(pn);
        setId(id);
    }
    
    public String getContent(){
        return imgDir;
    }
    
    public void setContent(String dir){
        this.imgDir = dir;
    }
}
