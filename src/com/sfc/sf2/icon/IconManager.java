/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sfc.sf2.icon;

import com.sfc.sf2.graphics.GraphicsManager;
import com.sfc.sf2.graphics.Tile;
import com.sfc.sf2.icon.io.PngManager;

/**
 *
 * @author wiz
 */
public class IconManager {
       
    private GraphicsManager graphicsManager = new GraphicsManager();
    private Tile[] tiles;

    public Tile[] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[] tiles) {
        this.tiles = tiles;
    }
       
    public void importDisassembly(String paletteFilePath, String graphicsFilePath){
        System.out.println("com.sfc.sf2.icon.IconManager.importDisassembly() - Importing disassembly ...");
        graphicsManager.importDisassembly(paletteFilePath, graphicsFilePath,false);
        tiles = graphicsManager.getTiles();
        System.out.println("com.sfc.sf2.icon.IconManager.importDisassembly() - Disassembly imported.");
    }
    
    public void exportDisassembly(String graphicsFilePath){
        System.out.println("com.sfc.sf2.icon.IconManager.importDisassembly() - Exporting disassembly ...");
        graphicsManager.exportDisassembly(graphicsFilePath, false);
        System.out.println("com.sfc.sf2.icon.IconManager.importDisassembly() - Disassembly exported.");        
    }   
    
    public void importRom(String romFilePath, String paletteOffset, String paletteLength, String graphicsOffset, String graphicsLength){
        System.out.println("com.sfc.sf2.icon.IconManager.importOriginalRom() - Importing original ROM ...");
        graphicsManager.importRom(romFilePath, paletteOffset, paletteLength, graphicsOffset, graphicsLength,false);
        tiles = graphicsManager.getTiles();
        System.out.println("com.sfc.sf2.icon.IconManager.importOriginalRom() - Original ROM imported.");
    }
    
    public void exportRom(String originalRomFilePath, String graphicsOffset){
        System.out.println("com.sfc.sf2.icon.IconManager.exportOriginalRom() - Exporting original ROM ...");
        graphicsManager.exportRom(originalRomFilePath, graphicsOffset, false);
        System.out.println("com.sfc.sf2.icon.IconManager.exportOriginalRom() - Original ROM exported.");        
    }      
    
    public void importPng(String basepath){
        System.out.println("com.sfc.sf2.icon.IconManager.importPng() - Importing PNG ...");
        tiles = PngManager.importPng(basepath);
        graphicsManager.setTiles(tiles);
        System.out.println("com.sfc.sf2.icon.IconManager.importPng() - PNG imported.");
    }
    
    public void exportPng(String basepath){
        System.out.println("com.sfc.sf2.icon.IconManager.exportPng() - Exporting PNG ...");
        PngManager.exportPng(tiles, basepath);
        System.out.println("com.sfc.sf2.icon.IconManager.exportPng() - PNG exported.");       
    }
}
