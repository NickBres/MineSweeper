/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.ImageIcon;

/**
 *
 * @author nickb
 */
public class GraphicComponent {
    
    
    GameModel gameModel;
    

    public GraphicComponent(GameModel gameModel) {
        this.gameModel = gameModel;
        this.gameModel.printCells();
    }
    
    public void repaintBoard(Graphics g){
        
        for(int i = 0;i<gameModel.getSizeY();i++)
        {
            for(int j = 0;j<gameModel.getSizeX();j++)
            {
                if(gameModel.getCells()[i][j].getIsOpened() && gameModel.getCells()[i][j].getCellInfo()!=-1)
                {
                    switch (gameModel.getCells()[i][j].getCellInfo()) {
                        case 0:
                            g.setColor(Color.GRAY);
                            g.fillRect(j*Cell.SizeCell,i*Cell.SizeCell,Cell.SizeCell,Cell.SizeCell);
                            break;
                        case 1:
                            g.drawImage(new ImageIcon("Images/one.png").getImage(), j*Cell.SizeCell, i*Cell.SizeCell,Cell.SizeCell,Cell.SizeCell,null);
                            break;
                        case 2:
                            g.drawImage(new ImageIcon("Images/two.png").getImage(), j*Cell.SizeCell, i*Cell.SizeCell,Cell.SizeCell,Cell.SizeCell,null);
                            break;
                        case 3:
                            g.drawImage(new ImageIcon("Images/three.png").getImage(), j*Cell.SizeCell, i*Cell.SizeCell,Cell.SizeCell,Cell.SizeCell,null);
                            break;
                        case 4:
                            g.drawImage(new ImageIcon("Images/four.png").getImage(), j*Cell.SizeCell, i*Cell.SizeCell,Cell.SizeCell,Cell.SizeCell,null);
                            break;
                        case 5:
                            g.drawImage(new ImageIcon("Images/five.png").getImage(), j*Cell.SizeCell, i*Cell.SizeCell,Cell.SizeCell,Cell.SizeCell,null);
                            break;
                        case 6:
                            g.drawImage(new ImageIcon("Images/six.png").getImage(), j*Cell.SizeCell,i*Cell.SizeCell,Cell.SizeCell,Cell.SizeCell,null);
                            break;
                        case 7:
                            g.drawImage(new ImageIcon("Images/seven.png").getImage(), j*Cell.SizeCell,i*Cell.SizeCell,Cell.SizeCell,Cell.SizeCell,null);
                            break;
                        case 8:
                            g.drawImage(new ImageIcon("Images/eight.png").getImage(), j*Cell.SizeCell, i*Cell.SizeCell,Cell.SizeCell,Cell.SizeCell,null);
                            break;
                        default:
                            break;
                    }
                     
                    
                }
            }
        }
        
        
        
       
       
    }
    public void repaintOnlyBomb(int row,int col,Graphics g)
        {
             g.drawImage(new ImageIcon("Images/mine.png").getImage(), col*Cell.SizeCell, row*Cell.SizeCell,Cell.SizeCell,Cell.SizeCell,null);
        }
    
     public void markCell(int row,int col,Graphics g)
        {
             g.drawImage(new ImageIcon("Images/skull.png").getImage(), col*Cell.SizeCell, row*Cell.SizeCell,Cell.SizeCell,Cell.SizeCell,null);
        }

     public void unMarkCell(int row, int col, Graphics g) {
         g.drawImage(new ImageIcon("Images/unmark.png").getImage(), col*Cell.SizeCell, row*Cell.SizeCell,Cell.SizeCell,Cell.SizeCell,null);
    }
    
    
}
