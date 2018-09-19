/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public abstract class Item {
    private String name;
    private int id;
    private int page;
    private int posX;
    private int posY;
    private int sizeX;
    private int sizeY;
    private boolean isText;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPage(int page) {
        this.page = page;
    }
    
    void setPos(int x, int y){
        this.posX = x;
        this.posY = y;
    }
    
    void setSize(int x, int y){
        this.sizeX = x;
        this.sizeY = y;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPage() {
        return page;
    }
    
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    
    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }
    
    public boolean isText(){
        return isText;
    }
    
    public abstract String getContent();
    
    public abstract void setContent(String data);
}
