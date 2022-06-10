/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author nickb
 */
class GameModel {

    private int sizeX, sizeY;
    private Cell cells[][];
    private int mineCount;
    private Random random = new Random();
    private Boolean gameOver = false;

    public GameModel(int boardSize, int minesCount) {

        this.mineCount = minesCount;
        if (boardSize == 1) {
            sizeX = sizeY = 8;
        } else if (boardSize == 2) {
            sizeX = 8 * 2;
            sizeY = 8;
        } else if (boardSize == 4) {
            sizeX = 8 * 2;
            sizeY = 8 * 2;
        }
        this.cells = new Cell[sizeY][sizeX];
       for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                
                    this.cells[i][j] = new Cell();
                

            }
        }
        fillCells();
    }

    void fillCells() {
        for (int i = 0; i < mineCount; ) {
            int randX = random.nextInt(sizeX), randY = random.nextInt(sizeY);
            System.out.println(randY + " " + randX);
            if (this.cells[randY][randX].getCellInfo() != -1) {
                this.cells[randY][randX].setCellInfo(-1);
                i++;
            } 
        }

        
          
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (this.cells[i][j].getCellInfo() != -1) {
                    this.cells[i][j].setCellInfo(nearMines(i, j));
                }

            }
        }
     printCells();
    }

    public int nearMines(int row, int col) {
        int minesCount = 0;
        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col - 1; j < col + 2; j++) {
                if ((i >= 0 && i < sizeY) && (j >= 0 && j < sizeX)) {
                    if (i != row || j != col) {
                        
                        if (this.cells[i][j].getCellInfo() == -1) {
                            minesCount++;
                        }
                    }
                }
            }
        }
        return minesCount;
    }

    void markCell(int row, int col) {
        this.cells[row][col].setIsMarked(Boolean.TRUE);
    }

    public void openCell(int row, int col) {
        if (this.cells[row][col].getCellInfo() != -1 && !this.cells[row][col].isMarked) {
            if (!this.cells[row][col].getIsOpened()) {
                this.cells[row][col].setIsOpened(Boolean.TRUE);
                if (this.cells[row][col].getCellInfo() == 0) {
                    for (int i = row - 1; i < row + 2; i++) {
                        for (int j = col - 1; j < col + 2; j++) {
                            if ((i >= 0 && i < sizeY) && (j >= 0 && j < sizeX)) {
                                if (i != row || j != col) {
                                    openCell(i, j);
                                }
                            }
                        }
                    }
                }
            }

        }
        else {
            this.cells[row][col].setIsOpened(Boolean.TRUE);
            gameOver = true;
        }

    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getMineCount() {
        return mineCount;
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Boolean getGameOver() {
        return gameOver;
    }

    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }

    
    public void printCells()
    {System.out.println("_________________________");
        for(int i = 0;i<sizeY;i++)
        {
       
            for(int j =0;j<sizeX;j++)
            {
                System.out.print(cells[i][j].getCellInfo()+" ");
            }
            System.out.println("");
            
        }
        System.out.println("_________________________");
    }
    
    public Boolean checkWin()
	{
		int i, j;
		int count = 0;
		for (i = 0; i < sizeY; i++)
		{
			for (j = 0; j < sizeX; j++)
			{
				if (this.cells[i][j].isMarked && this.cells[i][j].getCellInfo() == -1)
					count++;
			}
		}
		if (count == this.mineCount)
			return true;
		else return false;
	}
}
