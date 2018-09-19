/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import javax.swing.JFileChooser;
import file.AlbumFile;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Album;
import model.Imagen;
import model.ImagenEditor;
import model.Item;
import model.Library;
import model.Page;
import model.Text;

public class AlbumForm extends javax.swing.JFrame {

    /**
     * Creates new form AlbumForm
     */
    Album al;
    AlbumFile af;
    Library lib;
    Border noSelection = BorderFactory.createEmptyBorder();
    Border selection = BorderFactory.createLineBorder(Color.BLACK);
    CaretListenerTextArea caretListenerTextArea = new CaretListenerTextArea();

    protected class CaretListenerTextArea extends JTextArea implements CaretListener{
        public void caretUpdate(CaretEvent e){
            String data;
            int activePg, activeItm;
            Item itm;
            
            activePg = pageList.getSelectedIndex();
            activeItm = itemList.getSelectedIndex();
            itm = al.albumPages.get(activePg).items.get(activeItm);
            data = ((JTextArea)pagePanel.getComponent(activeItm)).getText();
            itm.setContent(data);
        }
    }
    
    public AlbumForm() {
        initComponents();
        styleList.setVisible(false);
        styleButton.setVisible(false);

    }
    public void assignAlbumFile(AlbumFile albumFile){
        this.af = albumFile;
    }
    
    public void assignAlbum(Album album){
        this.al = album;
        al.albumName = "nuevo";
    }
    
    public void assignLibrary(Library library){
        this.lib = library;
    }
    
    public String fileBrowser(int opt){
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        FileNameExtensionFilter flt = new FileNameExtensionFilter("album", "album");
        fc.setFileFilter(flt);
        if (opt == 2){
            
            fc.setDialogTitle("Save album");
            fc.setSelectedFile(new File(al.albumName));
            //FileNameExtensionFilter flt = new FileNameExtensionFilter("Album", "Album");
            //fc.setFileFilter(flt);
            
            int result = fc.showSaveDialog(libraryPanel);
            if(result == JFileChooser.APPROVE_OPTION){
                File selectedFile = fc.getSelectedFile();
                return selectedFile.getAbsolutePath();
                //System.out.println("Selected file: " + select.getAbsolutePath());
            }else{
                return null;
            }
        }else{
            fc.setDialogTitle("Load album");
            //FileNameExtensionFilter flt = new FileNameExtensionFilter("Album", "Album");
            //fc.setFileFilter(flt);
            
            int result = fc.showOpenDialog(libraryPanel);
            if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = fc.getSelectedFile();
               return selectedFile.getAbsolutePath();
               //System.out.println("Selected file: " + select.getAbsolutePath());
            }else{
                return null;
            }
            
        }
        
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        libraryPanel = new javax.swing.JPanel();
        libList = new java.awt.List();
        styleList = new java.awt.List();
        styleButton = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        albumContentLabel = new javax.swing.JLabel();
        libraryLabel = new javax.swing.JLabel();
        pagePanel = new javax.swing.JPanel();
        albumPanel = new javax.swing.JPanel();
        pageList = new java.awt.List();
        itemList = new java.awt.List();
        secPagLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newAlbum = new javax.swing.JMenuItem();
        loadAlbum = new javax.swing.JMenuItem();
        saveAlbum = new javax.swing.JMenuItem();
        shareAlbum = new javax.swing.JMenuItem();
        sendToFrame = new javax.swing.JMenuItem();
        albumMenu = new javax.swing.JMenu();
        addPage = new javax.swing.JMenuItem();
        removePage = new javax.swing.JMenuItem();
        libraryMenu = new javax.swing.JMenu();
        addImagen = new javax.swing.JMenuItem();
        removeImagen = new javax.swing.JMenuItem();
        editImagen = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Album Editor");
        setResizable(false);

        libraryPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        libList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                libListMouseClicked(evt);
            }
        });
        libList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libListActionPerformed(evt);
            }
        });

        styleList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                styleListMouseClicked(evt);
            }
        });

        styleButton.setText("set style");
        styleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                styleButtonActionPerformed(evt);
            }
        });

        imageLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        imageLabel.setPreferredSize(new java.awt.Dimension(120, 120));
        imageLabel.setRequestFocusEnabled(false);

        javax.swing.GroupLayout libraryPanelLayout = new javax.swing.GroupLayout(libraryPanel);
        libraryPanel.setLayout(libraryPanelLayout);
        libraryPanelLayout.setHorizontalGroup(
            libraryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(libList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(styleList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, libraryPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(styleButton)
                .addGap(31, 31, 31))
            .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        libraryPanelLayout.setVerticalGroup(
            libraryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(libraryPanelLayout.createSequentialGroup()
                .addComponent(libList, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(styleList, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(styleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        albumContentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        albumContentLabel.setText("album contents");
        albumContentLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        libraryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libraryLabel.setText("imagen library");
        libraryLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pagePanel.setBackground(new java.awt.Color(255, 255, 255));
        pagePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout pagePanelLayout = new javax.swing.GroupLayout(pagePanel);
        pagePanel.setLayout(pagePanelLayout);
        pagePanelLayout.setHorizontalGroup(
            pagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );
        pagePanelLayout.setVerticalGroup(
            pagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );

        albumPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        albumPanel.setMinimumSize(new java.awt.Dimension(174, 665));

        pageList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pageListMouseClicked(evt);
            }
        });

        itemList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemListMouseClicked(evt);
            }
        });

        secPagLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secPagLabel.setText("selected page");

        javax.swing.GroupLayout albumPanelLayout = new javax.swing.GroupLayout(albumPanel);
        albumPanel.setLayout(albumPanelLayout);
        albumPanelLayout.setHorizontalGroup(
            albumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(albumPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(secPagLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(albumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pageList, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        albumPanelLayout.setVerticalGroup(
            albumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, albumPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(secPagLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemList, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251))
            .addGroup(albumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(albumPanelLayout.createSequentialGroup()
                    .addComponent(pageList, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 474, Short.MAX_VALUE)))
        );

        fileMenu.setText("File");

        newAlbum.setText("New album");
        newAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAlbumActionPerformed(evt);
            }
        });
        fileMenu.add(newAlbum);

        loadAlbum.setText("Load album");
        loadAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadAlbumActionPerformed(evt);
            }
        });
        fileMenu.add(loadAlbum);

        saveAlbum.setText("Save album");
        saveAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAlbumActionPerformed(evt);
            }
        });
        fileMenu.add(saveAlbum);

        shareAlbum.setText("Share album");
        shareAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shareAlbumActionPerformed(evt);
            }
        });
        fileMenu.add(shareAlbum);

        sendToFrame.setText("Send to frame");
        sendToFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToFrameActionPerformed(evt);
            }
        });
        fileMenu.add(sendToFrame);

        jMenuBar1.add(fileMenu);

        albumMenu.setText("Album");

        addPage.setText("Add page");
        addPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPageActionPerformed(evt);
            }
        });
        albumMenu.add(addPage);

        removePage.setText("Remove page");
        removePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePageActionPerformed(evt);
            }
        });
        albumMenu.add(removePage);

        jMenuBar1.add(albumMenu);

        libraryMenu.setText("Library");

        addImagen.setText("Add image");
        addImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addImagenActionPerformed(evt);
            }
        });
        libraryMenu.add(addImagen);

        removeImagen.setText("Remove image");
        removeImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeImagenActionPerformed(evt);
            }
        });
        libraryMenu.add(removeImagen);

        editImagen.setText("Edit image");
        editImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editImagenActionPerformed(evt);
            }
        });
        libraryMenu.add(editImagen);

        jMenuBar1.add(libraryMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(albumContentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(albumPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(libraryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libraryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(albumContentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(libraryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(libraryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(albumPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadAlbumActionPerformed
        
        String fp = fileBrowser(1);
        if (fp != null){
            af.loadZipFile(fp, al);
            af.loadData(al);
        }
        setTitle(al.albumName);
        showAll();
        int active = 0;
        pageList.select(active);
        showPageItems();
        startPage(al.style);
        selectPage(al.albumPages.get(active));
        
    }//GEN-LAST:event_loadAlbumActionPerformed

    private void saveAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAlbumActionPerformed
        String fp = fileBrowser(2);
        if (fp != null){
            af.saveData(al);
            af.saveZipFile(fp);   
        }
        
    }//GEN-LAST:event_saveAlbumActionPerformed

    private void styleListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_styleListMouseClicked
        int active;
        active = styleList.getSelectedIndex();
        Page style = lib.styles.get(active);
        startPage(style);
        
    }//GEN-LAST:event_styleListMouseClicked

    private void newAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAlbumActionPerformed
        
        String fp = fileBrowser(2);
        if (fp != null){
            af.saveData(al);
            af.saveZipFile(fp);   
        }
        int i;
        af.loadData(al);
        for (i = 0; i < al.albumPages.size(); i++){
            af.unloadPage(al, i);
        }
        al.albumPages.clear();
        al.albumName = "New album";
        al.imgCounter = 0;
        al.txtCounter = 0;
        
        pageList.removeAll();
        itemList.removeAll();
        pagePanel.removeAll();
        setStyle();
        
    }//GEN-LAST:event_newAlbumActionPerformed

    private void styleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_styleButtonActionPerformed
        int i, active;
        active = styleList.getSelectedIndex();
        
        al.albumPages.clear();
        al.style.items.clear();
        
        Page style = lib.styles.get(active);
        for (i = 0;i < style.items.size();i++){
            al.style.addItem(style.items.get(i));
        }
        
        styleList.setVisible(false);
        styleButton.setVisible(false);
        
        addAlbumPage();
        selectPage(al.albumPages.get(0));
        showAll();
    }//GEN-LAST:event_styleButtonActionPerformed

    private void addImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addImagenActionPerformed

        String data;
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        FileNameExtensionFilter flt = new FileNameExtensionFilter("jpg", "jpg");
        fc.setFileFilter(flt);
        
        fc.setDialogTitle("Load image");

        int result = fc.showOpenDialog(libraryPanel);
        if(result == JFileChooser.APPROVE_OPTION){
          File selectedFile = fc.getSelectedFile();
          data = selectedFile.getAbsolutePath();
          
          af.loadImagen(lib, data);
          showAll();
          
        }
    }//GEN-LAST:event_addImagenActionPerformed

    private void removeImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeImagenActionPerformed
        int active;
        active = libList.getSelectedIndex();
        if (active > -1){
            String data;
            data = lib.images.get(active).getContent();
            af.unloadImagen(lib, active);
            showAll();
            
        }
        
    }//GEN-LAST:event_removeImagenActionPerformed

    private void libListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libListActionPerformed
        int activeImg, activeItm, activePg;
        activeImg = libList.getSelectedIndex();
        activeItm = itemList.getSelectedIndex();
        activePg = pageList.getSelectedIndex();
        if (activeItm != -1){
            String data,dir;
            data = lib.images.get(activeImg).getContent();
            dir = al.albumPages.get(activePg).items.get(activeItm).getContent();
            
            af.copyImagen(data, dir);
            
            selectPage(al.albumPages.get(activePg));
            showPageItems();
        }
    }//GEN-LAST:event_libListActionPerformed

    private void libListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_libListMouseClicked
        int active;
        Item itm;
        String data;
        
        active = libList.getSelectedIndex();
        itm = lib.images.get(active);
        data = itm.getContent();
        
        ImageIcon icon = new ImageIcon(data);
        int WIDTH = imageLabel.getWidth();
        int HEIGHT = imageLabel.getHeight();
        Image img = icon.getImage();
        Image shortImg = img.getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_AREA_AVERAGING);
        icon = new ImageIcon(shortImg);
        imageLabel.setIcon(icon);
        
    }//GEN-LAST:event_libListMouseClicked

    private void addPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPageActionPerformed
        addAlbumPage();
        showAll();
    }//GEN-LAST:event_addPageActionPerformed

    private void itemListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemListMouseClicked
        int i, j,active;

        String data, name;
        active=pageList.getSelectedIndex();
        i = itemList.getSelectedIndex();

        if (active != -1 && i != -1){
            for (j = 0;j < itemList.getItemCount();j++){
                
                if(pagePanel.getComponent(j) instanceof JLabel){
                    ((JLabel)pagePanel.getComponent(j)).setBorder(noSelection);
                    if (j == i){
                        ((JLabel)pagePanel.getComponent(j)).setBorder(selection);
                        
                    }

                }else{
                    ((JTextArea)pagePanel.getComponent(j)).setBorder(noSelection);
                    ((JTextArea)pagePanel.getComponent(j)).removeCaretListener(caretListenerTextArea);

                    if (j == i){
                        ((JTextArea)pagePanel.getComponent(j)).setBorder(selection);
                        ((JTextArea)pagePanel.getComponent(j)).addCaretListener(caretListenerTextArea);
                    }

                }

            }
            pagePanel.revalidate();
            pagePanel.repaint();
            
        }
    }//GEN-LAST:event_itemListMouseClicked

    private void pageListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pageListMouseClicked

        int active;
        active=pageList.getSelectedIndex();
        if (active != -1){
            showPageItems();
            selectPage(al.albumPages.get(active));
        }
    }//GEN-LAST:event_pageListMouseClicked

    private void removePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePageActionPerformed
        int active;
        active = pageList.getSelectedIndex();
        if(al.albumPages.size() > 1 && active > -1){
            af.unloadPage(al, active);
            al.removePage(active);
            showAll();
        }
        
    }//GEN-LAST:event_removePageActionPerformed

    private void shareAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shareAlbumActionPerformed
        ShareForm sf = new ShareForm();
        sf.assignAlbum(al);
        sf.setVisible(true);
    }//GEN-LAST:event_shareAlbumActionPerformed

    private void sendToFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToFrameActionPerformed
        SendForm stff = new SendForm();
        stff.assignAlbum(al);
        stff.setVisible(true);
    }//GEN-LAST:event_sendToFrameActionPerformed

    private void editImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editImagenActionPerformed
        int active;
        Imagen img;
        active = libList.getSelectedIndex();
        if (active > -1){
            img = lib.images.get(active);
            EditorForm form = new EditorForm();
            form.assignEditor(new ImagenEditor(img));
            form.setVisible(true);
        }
        
    }//GEN-LAST:event_editImagenActionPerformed

    public void setStyle(){
        int i;
        styleList.setVisible(true);
        styleButton.setVisible(true);
        styleList.removeAll();
        for (i = 0;i < lib.styles.size();i++){
            styleList.add("style " + lib.styles.get(i).getPageNum());
        }
    }
    
    public void addAlbumPage(){
        int i;
        Item itm;
        Page pg;
        al.addPage();
        pg = al.albumPages.get(al.albumPages.size() - 1);
        for (i = 0; i< pg.items.size(); i++){
            itm = pg.items.get(i);
            if (itm instanceof Text){
                
            }else{
                String dir,src;
                dir = "album/img/" + itm.getName() + ".jpg";
                src = itm.getContent();
                af.copyImagen(src, dir);
                itm.setContent(dir);
            }
        }
    }
    
    public void startPage(Page page){
        pagePanel.removeAll();
        
        int i, px, py, sx, sy;
        String data;
        Item itm;
        for(i = 0;i<page.items.size();i++){
            itm = page.items.get(i);
            data = itm.getContent();
            px = itm.getPosX() * 229 + 10;
            py = itm.getPosY() * 323 + 10;
            sx = itm.getSizeX() * 229 - 20;
            sy = itm.getSizeY() * 323 - 20;
            if(itm instanceof Text){
                
                JTextArea txt = new JTextArea();
                txt.setName("" + itm.getId());
                txt.setBounds(px, py, sx, sy);
                
                txt.setText(itm.getContent());
                
                txt.setVisible(true);
                
                
                
                pagePanel.add(txt);
                
                pagePanel.revalidate();
                pagePanel.repaint();
            }else{
                
                JLabel img = new JLabel();
                
                img.setName("" + itm.getId());
                img.setBounds(px, py, sx, sy);
                img.setOpaque(true);

                ImageIcon icon = new ImageIcon(data);
                Image imag = icon.getImage();
                Image shortImg = imag.getScaledInstance(sx, sy, java.awt.Image.SCALE_AREA_AVERAGING);
                icon = new ImageIcon(shortImg);
                img.setIcon(icon);
                
                img.setVisible(true);
                
                pagePanel.add(img);
                
                pagePanel.revalidate();
                pagePanel.repaint();
            }
        }
    }
    
    public void selectPage(Page page){
        int i;
        String data;
        Item itm;
        
        for(i = 0;i<page.items.size();i++){
            itm = page.items.get(i);
            data = itm.getContent();
            if(itm instanceof Text){
                
                ((JTextArea)pagePanel.getComponent(i)).setText(data);
               
                pagePanel.revalidate();
                pagePanel.repaint();
            }else{
                ImageIcon icon = new ImageIcon(data);
                int WIDTH = ((JLabel)pagePanel.getComponent(i)).getWidth();
                int HEIGHT = ((JLabel)pagePanel.getComponent(i)).getHeight();
                Image img = icon.getImage();
                Image shortImg = img.getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_AREA_AVERAGING);
                icon = new ImageIcon(shortImg);
                ((JLabel)pagePanel.getComponent(i)).setIcon(icon);
                pagePanel.revalidate();
                pagePanel.repaint();
            }
        }
    }
    
    public void showAll(){
        pageList.removeAll();
        for(int i=0;i<al.albumPages.size();i++){
            
            pageList.add("Page" + al.albumPages.get(i).getPageNum());
        }
        libList.removeAll();
        for(int i=0;i<lib.images.size();i++){
            
            libList.add("" + lib.images.get(i).getName());
        }
        
    }
    
    public void showPageItems(){
        int i, active;
        itemList.removeAll();
        active=pageList.getSelectedIndex();
        secPagLabel.setText("Page " + (active + 1));
        
        for(i=0;i<al.albumPages.get(active).items.size();i++){
            itemList.add(al.albumPages.get(active).items.get(i).getName());
            
        }

    }   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlbumForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlbumForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlbumForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlbumForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlbumForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addImagen;
    private javax.swing.JMenuItem addPage;
    private javax.swing.JLabel albumContentLabel;
    private javax.swing.JMenu albumMenu;
    private javax.swing.JPanel albumPanel;
    private javax.swing.JMenuItem editImagen;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel imageLabel;
    private java.awt.List itemList;
    private javax.swing.JMenuBar jMenuBar1;
    private java.awt.List libList;
    private javax.swing.JLabel libraryLabel;
    private javax.swing.JMenu libraryMenu;
    private javax.swing.JPanel libraryPanel;
    private javax.swing.JMenuItem loadAlbum;
    private javax.swing.JMenuItem newAlbum;
    private java.awt.List pageList;
    private javax.swing.JPanel pagePanel;
    private javax.swing.JMenuItem removeImagen;
    private javax.swing.JMenuItem removePage;
    private javax.swing.JMenuItem saveAlbum;
    private javax.swing.JLabel secPagLabel;
    private javax.swing.JMenuItem sendToFrame;
    private javax.swing.JMenuItem shareAlbum;
    private javax.swing.JButton styleButton;
    private java.awt.List styleList;
    // End of variables declaration//GEN-END:variables
}