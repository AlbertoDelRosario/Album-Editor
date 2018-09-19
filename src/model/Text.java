/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Text extends Item{
    private String text;
    
    Text(int pn, int id, String name, int posX, int posY, int sizeX, int sizeY, String text){
        setPos(posX, posY);
        setSize(sizeX, sizeY);
        setName(name);
        setPage(pn);
        setId(id);
        this.text = text;
    }
    
    public Text(int pn, int id, int posX, int posY, int sizeX, int sizeY){
        setPos(posX, posY);
        setSize(sizeX, sizeY);
        setPage(pn);
        setId(id);
    }
    
    public String getContent(){
        return text;
    }
    
    public void setContent(String text){
        this.text = text;
    }
}
