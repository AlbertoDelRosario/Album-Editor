/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.zip.*;
import model.Album;
import model.Item;
import model.Text;
import model.Library;
import model.Page;

public class AlbumFile {
    private String dest = "album/";
    String nl = System.getProperty( "line.separator" );
    
    private void setAlbumName(String dir, Album album){
        File fName = new File(dir);
        String name = fName.getName();
        String aname = name.substring(0, (name.length()- 6));
        album.albumName = aname;
    }
    
    public void loadData(Album album){
        int n = 0;
        try{
            Scanner st=new Scanner(new File("album/style.dat"));
            n = st.nextInt();
            album.style.items.clear();
            for (int i = 0; i < n; i++){

                album.addStyle(st.nextInt(), st.nextInt(), st.nextInt(), st.nextInt(), st.nextInt(), st.nextInt());
            }
            st.close();
        }catch(Exception e){
        }
        
        try{
            Scanner pg=new Scanner(new File("album/pages.dat"));
            int k = pg.nextInt();
            album.albumPages.clear();
            
            for (int i = 0; i < k; i++){
                album.addPage();
                
                for (int j = 0;j < n;j++){
                    Item itm = album.style.items.get(j);
                    int pag = pg.nextInt();
                    int id = pg.nextInt();
                    String name, ref = pg.next();
                    File file = new File(ref);
                    name = file.getName();
                    name = name.substring(0, (name.length() - 4));
                    if (itm instanceof Text){
                        String data = "";
                        try{
                            Scanner tx = new Scanner(file);
                            while (tx.hasNext()){
                                data+= tx.next() + " ";
                            }
                            data = data.trim();
                            tx.close();
                        }catch(Exception e){
                        }
                        album.albumPages.get(i).setItem(j, name, data);
                    }else{
                        album.albumPages.get(i).setItem(j, name, ref);
                    }
                }
            }
            pg.close();
            
        }catch(Exception e){
        }

    }
    
    public void loadZipFile(String dir, Album album){
        try{
            setAlbumName(dir, album);
            
            FileInputStream file = new FileInputStream(new File(dir).getAbsolutePath());
            ZipInputStream zip = new ZipInputStream(file);
            ZipEntry ze;
            OutputStream out = null;
            while((ze = zip.getNextEntry()) != null){
                String fileName = ze.getName();
                if(ze.isDirectory()){
                    new File(dest, fileName).mkdirs();
                    
                }else{
                    out = new FileOutputStream(new File(dest, fileName));
                    
                    byte[] buf = new byte[1024];
                    int len;
                    
                    while((len = zip.read(buf)) > 0){
                        out.write(buf, 0, len);
                    }
                    out.close();
                    
                }
                zip.closeEntry();
                
            }
            zip.close();
            file.close();
              
        }catch(Exception e){
        }
    }
    
    public void saveData(Album album){
        try{
            FileWriter st = new FileWriter("album/style.dat");
            int c;
            st.write(album.style.items.size()+""+nl);
            for (c = 0;c < album.style.items.size();c++){
                Item itm = album.style.items.get(c);
                if (itm instanceof Text){
                    st.write(itm.getId() + " " + itm.getPosX() + " " + itm.getPosY() + " " + itm.getSizeX() + " " + itm.getSizeY() + " " + "1"+nl);
                }else{
                    st.write(itm.getId() + " " + itm.getPosX() + " " + itm.getPosY() + " " + itm.getSizeX() + " " + itm.getSizeY() + " " + "2"+nl);
                }
            }
            st.close();
            
        }catch (Exception e1) {
	}
        
        try{
            FileWriter pw = new FileWriter("album/pages.dat");
            pw.write(album.albumPages.size()+""+ nl);
            int i,j;
            for (i = 0;i<album.albumPages.size();i++){
                for (j = 0;j<album.albumPages.get(i).items.size();j++){
                    Item itm = album.albumPages.get(i).items.get(j);
                    String dir;
                    if (itm instanceof Text){
                        dir = "album/txt/" + itm.getName() + ".txt";
                        pw.write(i + " " + j + " " + dir + nl);
                        
                        try{
                            FileWriter txt = new FileWriter(dir);
                            txt.write(itm.getContent());
                            txt.close();
                        }catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        
                    }else{
                        dir = "album/img/" + itm.getName() + ".jpg";
                        pw.write(i + " " + j + " " + dir + nl);
                        
                        
                    }
                }
            }
            pw.close();
        }catch (Exception e1) {
	}
    }
    
    public void saveZipFile(String dir){
        try{
            String zipName = dir + ".album";

            FileOutputStream file = new FileOutputStream(zipName);
            ZipOutputStream zip = new ZipOutputStream(file);
            addFolderToZip("", dest, zip);
            zip.flush();
            zip.close();
            
        }catch(Exception e1){
        }
            
    }
    
    private void addFileToZip(String path, String srcFile, ZipOutputStream zip) throws Exception {

        File folder = new File(srcFile);
        if (folder.isDirectory()) {
            addFolderToZip(folder.getName(), srcFile, zip);
        } else {
            byte[] buf = new byte[1024];
            int len;
            FileInputStream in = new FileInputStream(new File(srcFile).getAbsolutePath());
            zip.putNextEntry(new ZipEntry(path + folder.getName()));
            while ((len = in.read(buf)) > 0) {
                zip.write(buf, 0, len);
            }
            in.close();
        }
    }
    
    private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip) throws Exception {
        File folder = new File(srcFolder);

        for (String fileName : folder.list()) {
            if (path.equals("")) {
                addFileToZip("", srcFolder + "/" + fileName, zip);
            } else {
             addFileToZip(path + "/", srcFolder + "/" + fileName, zip);
            }
        }
    }
    
    public void loadLibrary(Library lib){
        int styleCounter;
        String dir;
        styleCounter = 0;
        dir = "library/styles";
        File styles = new File(dir);
        for (String filename : styles.list()){
            lib.addStyle();
            try{
                Scanner sr = new Scanner(new File(dir + "/" + filename));
                int i, n;
                n = sr.nextInt();
                for (i=0;i<n;i++){
                    lib.addStyleItem(styleCounter, sr.nextInt(), sr.nextInt(), sr.nextInt(), sr.nextInt(), sr.nextInt(), sr.nextInt());
                }
                styleCounter++;
                sr.close();
            }catch(Exception e3){
            }
            
        }
        dir = "library/img";
        File images = new File(dir);
        for (String filename : images.list()){
            lib.addImagen(dir + "/" + filename);
        }
        
        
    }
    
    public void loadImagen(Library lib, String src){
        try{
            int id = lib.images.size();
            String dir = "library/img/img" + id + ".jpg";
            lib.addImagen(src);
            lib.images.get(id).setContent(dir);
            File fl = new File(dir);
            FileInputStream in = new FileInputStream(new File(src).getAbsolutePath());
            FileOutputStream out = new FileOutputStream(dir);

            byte[] buf = new byte[1024];
            int len;
            while((len = in.read(buf)) > 0){
                out.write(buf, 0, len);
            }
            in.close();
            out.close()
                    ;
        }catch (Exception e4) {
        }
    }
    
    public void unloadImagen(Library lib, int active){
        Item itm = lib.images.get(active);
        String src = itm.getContent();
        lib.removeImagen(active);
        Path del = Paths.get(src);
        try{
            Files.delete(del);
        }catch(Exception e5){
        }
    }
    
    public void copyImagen(String src, String dir){
        try{
            File fl = new File(dir);
            FileInputStream in = new FileInputStream(src);
            FileOutputStream out = new FileOutputStream(dir);

            byte[] buf = new byte[1024];
            int len;
            while((len = in.read(buf)) > 0){
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
                    
        }catch (Exception e6) {
        }
    }
    
    public void unloadPage(Album album, int active){
        int i;
        Page pg;
        Item itm;
        String src;
        pg = album.albumPages.get(active);
        
        for (i = 0; i < pg.items.size();i++){
            itm = pg.items.get(i);
            if(itm instanceof Text){
                src = "album/txt/" + itm.getName() + ".txt";
            }else{
                src = itm.getContent();
            }
            Path del = Paths.get(src);
            try{
                Files.delete(del);
            }catch(Exception e5){
            }
        }
        
    }
}
