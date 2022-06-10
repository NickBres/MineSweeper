/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author nickb
 */
public class Cell {
    
    
    private int cellInfo;
    public static final int SizeCell = 50;
    Boolean isMarked,isOpened;
    
    
    
    public Cell()
    { 
        this.cellInfo = 0;
        this.isMarked = false;
        this.isOpened = false;
    }

    public int getCellInfo() {
        return cellInfo;
    }

    public void setCellInfo(int cellInfo) {
        this.cellInfo = cellInfo;
    }

 

    public Boolean getIsMarked() {
        return isMarked;
    }

    public void setIsMarked(Boolean isMarked) {
        this.isMarked = isMarked;
    }

    public Boolean getIsOpened() {
        return isOpened;
    }

    public void setIsOpened(Boolean isOpened) {
        this.isOpened = isOpened;
    }
    
    
}
