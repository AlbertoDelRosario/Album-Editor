/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

public class Page {
    
    private int pageNum;
    public ArrayList<Item>items;
    
    Page(int pn){
        this.pageNum = pn;
        items = new ArrayList<Item>();
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    
    public int getPageNum(){
        return (pageNum);
    }
    
    public void addItem(Item itm){
        items.add(itm);
    }
    
    public void setItem(int id, String name, String data){
        items.get(id).setName(name);
        items.get(id).setContent(data);
    }
    
    public void setItem(int id, String data){
        items.get(id).setContent(data);
    }
    
    public void removeItem(int id){
        items.remove(id);
    }
    
}
