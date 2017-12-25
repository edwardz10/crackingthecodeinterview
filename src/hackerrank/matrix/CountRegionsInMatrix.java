package hackerrank.matrix;

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
    	int width = matrix.length, height = matrix[0].length; 
//    	System.out.println("height=" + height + ", width=" + width);
    	
        Set<Cell> cells = new HashSet<>();
        int i;

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

        if (col >= 1 && matrix[col - 1][row] == 1) {
            cells.add(new Cell(col - 1, row));    
        }
        
        if (col < height - 1 && matrix[col + 1][row] == 1) {
            cells.add(new Cell(col + 1, row));    
        }
        
        return cells;
    }
    
    public static boolean regionContainsCell(Set<Cell> region, int col, int row) {
        return region.contains(new Cell(col, row));
    }

    public static int getBiggestRegion(int[][] matrix) {
    	int height = matrix.length, width = matrix[0].length; 
        Set<Cell> existingRegion1, existingRegion2;
        int steps = 0;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 1) {
                    //System.out.println(++steps + ". Cell [" + i + "," + j + "] is filled");
                    Set<Cell> connectedCells = getConnectedCells(matrix, i, j);
                    //System.out.println("Connected cells of [" + i + "," + j + "]: " + connectedCells);                    
                                       
                    existingRegion1 = null;
                    for (Cell connectedCell : connectedCells) {
                    	if (existingRegion1 == null) {
                    		existingRegion1 = getExistingRegion(connectedCell.col, connectedCell.row);

                    		if (existingRegion1 != null) {
                                //System.out.println("Found the first existing region: " + existingRegion1);
                            }
                    	} else {
                    		existingRegion2 = getExistingRegion(connectedCell.col, connectedCell.row);
                    		
                    		if (existingRegion2 != null && existingRegion1 != existingRegion2) {
                                //System.out.println("Found the second existing region: " + existingRegion2);
                                //System.out.println("Merge 2 regions: " + existingRegion1 + " and " + existingRegion2);
                                existingRegion1.addAll(existingRegion2);
                                regions.remove(existingRegion2);
                                break;
                            }
                    	}
                    	
                    }

                    if (existingRegion1 == null) {
                        //System.out.println("Cell [" + i + "," + j + "] doesn't belong to any region, create one...");
                        existingRegion1 = new HashSet<>();
                        existingRegion1.add(new Cell(i, j));
                        regions.add(existingRegion1);
                    } else {
                        //System.out.println("Add the cell [" + i + "," + j + "] to the region: ");
                        existingRegion1.add(new Cell(i, j));
                        //System.out.println("Now the region is:" + existingRegion1);
                    }
                    
                    if (existingRegion1.size() > biggestRegion) {
                    	biggestRegion = existingRegion1.size();
                    }

                	//System.out.println("Biggest region size: " + biggestRegion);
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

//    7
//    8
//    1 0 0 1 0 1 0 0
//    0 0 0 0 0 0 0 1
//    1 0 1 0 1 0 0 0
//    0 0 0 0 0 0 1 0
//    1 0 0 1 0 0 0 0
//    0 0 0 0 0 0 0 1
//    0 1 0 0 0 1 0 0
    
    public static int[][] getArray8x9() {
    	int grid[][] = new int[9][8];

    	grid[0][0] = 0;
        grid[0][1] = 1;
        grid[0][2] = 0;
        grid[0][3] = 0;
    	grid[0][4] = 0;
        grid[0][5] = 0;
        grid[0][6] = 0;
        grid[0][7] = 1;

    	grid[1][0] = 1;
        grid[1][1] = 1;
        grid[1][2] = 0;
        grid[1][3] = 1;
    	grid[1][4] = 1;
        grid[1][5] = 1;
        grid[1][6] = 1;
        grid[1][7] = 0;

    	grid[2][0] = 0;
        grid[2][1] = 0;
        grid[2][2] = 0;
        grid[2][3] = 1;
    	grid[2][4] = 1;
        grid[2][5] = 0;
        grid[2][6] = 0;
        grid[2][7] = 1;
    	
    	grid[3][0] = 0;
        grid[3][1] = 0;
        grid[3][2] = 0;
        grid[3][3] = 1;
    	grid[3][4] = 1;
        grid[3][5] = 1;
        grid[3][6] = 0;
        grid[3][7] = 1;

    	grid[4][0] = 0;
        grid[4][1] = 1;
        grid[4][2] = 1;
        grid[4][3] = 0;
    	grid[4][4] = 0;
        grid[4][5] = 1;
        grid[4][6] = 1;
        grid[4][7] = 1;

    	grid[5][0] = 0;
        grid[5][1] = 0;
        grid[5][2] = 0;
        grid[5][3] = 1;
    	grid[5][4] = 0;
        grid[5][5] = 0;
        grid[5][6] = 1;
        grid[5][7] = 1;

    	grid[6][0] = 1;
        grid[6][1] = 0;
        grid[6][2] = 1;
        grid[6][3] = 0;
    	grid[6][4] = 1;
        grid[6][5] = 1;
        grid[6][6] = 0;
        grid[6][7] = 0;

    	grid[7][0] = 1;
        grid[7][1] = 0;
        grid[7][2] = 0;
        grid[7][3] = 1;
    	grid[7][4] = 1;
        grid[7][5] = 1;
        grid[7][6] = 1;
        grid[7][7] = 0;

    	grid[8][0] = 0;
        grid[8][1] = 1;
        grid[8][2] = 0;
        grid[8][3] = 1;
    	grid[8][4] = 0;
        grid[8][5] = 0;
        grid[8][6] = 1;
        grid[8][7] = 0;

        return grid;
    }

    public static int[][] getArray7x8() {
    	int grid[][] = new int[8][7];

    	grid[0][0] = 1;
        grid[0][1] = 0;
        grid[0][2] = 1;
        grid[0][3] = 0;
    	grid[0][4] = 1;
        grid[0][5] = 0;
        grid[0][6] = 0;

    	grid[1][0] = 0;
        grid[1][1] = 0;
        grid[1][2] = 0;
        grid[1][3] = 0;
    	grid[1][4] = 0;
        grid[1][5] = 0;
        grid[1][6] = 1;

    	grid[2][0] = 0;
        grid[2][1] = 0;
        grid[2][2] = 1;
        grid[2][3] = 0;
    	grid[2][4] = 0;
        grid[2][5] = 0;
        grid[2][6] = 0;
    	
    	grid[3][0] = 1;
        grid[3][1] = 0;
        grid[3][2] = 0;
        grid[3][3] = 0;
    	grid[3][4] = 1;
        grid[3][5] = 0;
        grid[3][6] = 0;

    	grid[4][0] = 0;
        grid[4][1] = 0;
        grid[4][2] = 1;
        grid[4][3] = 0;
    	grid[4][4] = 0;
        grid[4][5] = 0;
        grid[4][6] = 0;

    	grid[5][0] = 1;
        grid[5][1] = 0;
        grid[5][2] = 0;
        grid[5][3] = 0;
    	grid[5][4] = 0;
        grid[5][5] = 0;
        grid[5][6] = 1;

    	grid[6][0] = 0;
        grid[6][1] = 0;
        grid[6][2] = 0;
        grid[6][3] = 1;
    	grid[6][4] = 0;
        grid[6][5] = 0;
        grid[6][6] = 0;

    	grid[7][0] = 0;
        grid[7][1] = 1;
        grid[7][2] = 0;
        grid[7][3] = 0;
    	grid[7][4] = 0;
        grid[7][5] = 1;
        grid[7][6] = 0;

        return grid;
    }    
    
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
    	int grid[][] = getArray7x8();

        System.out.println(getBiggestRegion(grid));
    }
}
