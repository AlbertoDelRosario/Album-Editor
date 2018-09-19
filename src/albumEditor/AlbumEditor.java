/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package albumEditor;

import file.AlbumFile;
import gui.AlbumForm;
import model.Album;
import model.Library;

/**
 *
 * @author Hector Acosta Valido & Alberto del Rosario Déniz
 */
public class AlbumEditor {
    
    public static void main(String[] args){
        
        Album album = new Album();
        Library library = new Library();

        AlbumForm albumForm = new AlbumForm();
        albumForm.assignAlbum(album);
        albumForm.setVisible(true);

        AlbumFile albumFile = new AlbumFile();
        albumFile.loadLibrary(library);
        albumForm.assignAlbumFile(albumFile);
        albumForm.assignLibrary(library);
        albumForm.showAll();
    }
}
