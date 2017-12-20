package code.interview.datastructures.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountRegionsInMatrix {
    private static class Cell {
        int col;
        int row;

        public Cell(int col, int row) {
            this.col = col;
            this.row = row;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this.getClass() == o.getClass()) {
                Cell c = (Cell)o;
                return c.row == row && c.col == col;
            }
            return false;
        }

        @Override
        public String toString() {
            return "col=" + col + ", row=" + row;
        }
        
    }

    static List<Set<Cell>> regions = new ArrayList<>();
    static int biggestRegion = 0;
    
    public static Set<Cell> getExistingRegion(int col, int row) {
        Set<Cell> result = null;

        for (Set<Cell> region : regions) {
            for (Cell c : region) {
                if (c.col == col && c.row == row) {
                    result = region;
                    break;
                }
            }
        }

        return result;
    }
    
    public static Set<Cell> getConnectedCells(int[][] matrix, int col, int row) {
    	int height = matrix.length, width = matrix[0].length; 
//    	System.out.println("height=" + height + ", width=" + width);
    	
        Set<Cell> cells = new HashSet<>();
        int i;
/*
		for (i = col - 1; i <= col + 1; i++) {
            if (i >= 0 && i < height) {
                if (row >= 1 && matrix[i][row - 1] == 1) {
                    cells.add(new Cell(i, row - 1));    
                }
                if (row < height - 1 && matrix[i][row + 1] == 1) {
                    cells.add(new Cell(i, row + 1));    
                }
            }
        }

        if (col >= 1 && matrix[col - 1][row] == 1) {
            cells.add(new Cell(col - 1, row));    
        }
        
        if (col < height - 1 && matrix[col + 1][row] == 1) {
            cells.add(new Cell(col + 1, row));    
        }
*/

		for (i = col - 1; i <= col + 1; i++) {
            if (i >= 0 && i < height) {
                if (row >= 1 && matrix[i][row - 1] == 1) {
                    cells.add(new Cell(i, row - 1));    
                }
//                if (row < height - 1 && matrix[i][row + 1] == 1) {
//                    cells.add(new Cell(i, row + 1));    
//                }
            }
        }

        if (col >= 1 && matrix[col - 1][row] == 1) {
            cells.add(new Cell(col - 1, row));    
        }
        
//        if (col < height - 1 && matrix[col + 1][row] == 1) {
//            cells.add(new Cell(col + 1, row));    
//        }
        
        return cells;
    }
    
    public static boolean regionContainsCell(Set<Cell> region, int col, int row) {
        return region.contains(new Cell(col, row));
    }

    public static int getBiggestRegion(int[][] matrix) {
    	int height = matrix.length, width = matrix[0].length; 
        Set<Cell> existingRegion;
        int steps = 0;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 1) {
                    System.out.println(++steps + ". Cell [" + i + "," + j + "] is filled");
                    Set<Cell> connectedCells = getConnectedCells(matrix, i, j);
                    System.out.println("Connected cells of [" + i + "," + j + "]: " + connectedCells);                    
                                       
                    existingRegion = null;
                    for (Cell connectedCell : connectedCells) {
                        existingRegion = getExistingRegion(connectedCell.col, connectedCell.row);
                        
                        if (existingRegion != null) {
                            System.out.println("Found an existing region: " + existingRegion);
                            break;
                        }
                    }

                    if (existingRegion == null) {
                        System.out.println("Cell [" + i + "," + j + "] doesn't belong to any region, create one...");
                        existingRegion = new HashSet<>();
                        existingRegion.add(new Cell(i, j));
                        regions.add(existingRegion);
                    } else {
                        System.out.println("Add the cell [" + i + "," + j + "] to the region: ");
                        existingRegion.add(new Cell(i, j));
                        System.out.println("Now the region is:" + existingRegion);
                    }
                    
                    if (existingRegion.size() > biggestRegion) {
                    	biggestRegion = existingRegion.size();
                    }

                	System.out.println("Biggest region size: " + biggestRegion);
                }
            }
        }
        
        return biggestRegion;
    }

//    8
//    9
//    0 1 0 0 0 0 1 1 0
//    1 1 0 0 1 0 0 0 1
//    0 0 0 0 1 0 1 0 0
//    0 1 1 1 0 1 0 1 1
//    0 1 1 1 0 0 1 1 0
//    0 1 0 1 1 0 1 1 0
//    0 1 0 0 1 1 0 1 1
//    1 0 1 1 1 1 0 0 0
    
    public static int[][] getArray() {
    	int grid[][] = new int[8][9];

    	grid[0][0] = 0;
        grid[0][1] = 1;
        grid[0][2] = 0;
        grid[0][3] = 0;
    	grid[0][4] = 0;
        grid[0][5] = 0;
        grid[0][6] = 1;
        grid[0][7] = 1;
    	grid[0][8] = 0;

    	grid[1][0] = 1;
        grid[1][1] = 1;
        grid[1][2] = 0;
        grid[1][3] = 0;
    	grid[1][4] = 1;
        grid[1][5] = 0;
        grid[1][6] = 0;
        grid[1][7] = 0;
    	grid[1][8] = 1;

    	grid[2][0] = 0;
        grid[2][1] = 0;
        grid[2][2] = 0;
        grid[2][3] = 0;
    	grid[2][4] = 1;
        grid[2][5] = 0;
        grid[2][6] = 1;
        grid[2][7] = 0;
    	grid[2][8] = 0;
    	
    	grid[3][0] = 0;
        grid[3][1] = 1;
        grid[3][2] = 1;
        grid[3][3] = 1;
    	grid[3][4] = 0;
        grid[3][5] = 1;
        grid[3][6] = 0;
        grid[3][7] = 1;
    	grid[3][8] = 1;

    	grid[4][0] = 0;
        grid[4][1] = 1;
        grid[4][2] = 1;
        grid[4][3] = 1;
    	grid[4][4] = 0;
        grid[4][5] = 0;
        grid[4][6] = 1;
        grid[4][7] = 1;
    	grid[4][8] = 0;

    	grid[5][0] = 0;
        grid[5][1] = 1;
        grid[5][2] = 0;
        grid[5][3] = 1;
    	grid[5][4] = 1;
        grid[5][5] = 0;
        grid[5][6] = 1;
        grid[5][7] = 1;
    	grid[5][8] = 0;

    	grid[6][0] = 0;
        grid[6][1] = 1;
        grid[6][2] = 0;
        grid[6][3] = 0;
    	grid[6][4] = 1;
        grid[6][5] = 1;
        grid[6][6] = 0;
        grid[6][7] = 1;
    	grid[6][8] = 1;

    	grid[7][0] = 1;
        grid[7][1] = 0;
        grid[7][2] = 1;
        grid[7][3] = 1;
    	grid[7][4] = 1;
        grid[7][5] = 1;
        grid[7][6] = 0;
        grid[7][7] = 0;
    	grid[7][8] = 0;

    	return grid;
    }
    
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
    	int grid[][] = getArray();

        System.out.println(getBiggestRegion(grid));
    }
}
