import java.util.*;
import java.io.*;

public class CS60813Cashikari {
	
	static boolean addBoxCheck(int[] randCheck, int tempRand) {
		
		boolean exists = true;
		
		for (int i = 0; i < randCheck.length; i++) 
			if (randCheck[i] == tempRand) 
				exists = false;

		return exists;
	}

	static int[][] shiftVert(int[][] oldBox, int[][] newBox) {
		
        for (int i = 0; i < 3; i++) {
        	
        	newBox[0][i] = oldBox[2][i];
        	System.out.print(newBox[0][i] + " ");
        	
        }
        System.out.println("");
        
        for (int i = 0; i < 3; i++) {
        	
        	newBox[1][i] = oldBox[0][i];
        	System.out.print(newBox[1][i] + " ");
        	
        }
        System.out.println("");

        for (int i = 0; i < 3; i++) {
	
        	newBox[2][i] = oldBox[1][i];
        	System.out.print(newBox[2][i] + " ");
	
        }
        System.out.println("");
		
		return newBox;
	}
	
	static int[][] shiftHoriz(int[][] oldBox, int[][] newBox) {
		
        for (int i = 0; i < 3; i++) {
        	
        	newBox[i][0] = oldBox[i][2];
        	//System.out.print(newBox[0][i] + " ");
        	
        }
        //System.out.println("");
        
        for (int i = 0; i < 3; i++) {
        	
        	newBox[i][1] = oldBox[i][0];
        	//System.out.print(newBox[1][i] + " ");
        	
        }
        //System.out.println("");

        for (int i = 0; i < 3; i++) {
	
        	newBox[i][2] = oldBox[i][1];
        	//System.out.print(newBox[2][i] + " ");
	
        }
        //System.out.println("");
        
        for (int i = 0; i < 3; i++) {
        	for (int j = 0; j < 3; j++) {
        	
        		System.out.print(newBox[i][j] + " ");
	
        	}
        	System.out.println("");
        }
        System.out.println("");
		
		return newBox;
	}
	
	static int[] makeRow(int[][] grid1, int[][] grid2, int[][] grid3) {
		
		int[] row = new int[9];
		
        for (int i = 0; i < 3; i++) {
        	
        	row[i] = grid1[0][i];
        	//System.out.print(newBox[0][i] + " ");
        	
        }
        
        int j = 0;
        for (int i = 3; i < 6; i++) {
        	
        	row[i] = grid2[0][j];
        	//System.out.print(newBox[0][i] + " ");
        	j++;
        	
        }
        
        int k = 0;
        for (int i = 6; i < 9; i++) {
        	
        	row[i] = grid3[0][k];
        	//System.out.print(newBox[0][i] + " ");
        	k++;
        	
        }
        
        for (int i = 0; i < 9; i++) {
        	
        	System.out.print(row[i] + " ");
        	
        }
		
		return row;
	}
	
	static int[] makeRow2(int[][] grid1, int[][] grid2, int[][] grid3) {
		
		int[] row = new int[9];
		
        for (int i = 0; i < 3; i++) {
        	
        	row[i] = grid1[1][i];
        	//System.out.print(newBox[0][i] + " ");
        	
        }
        
        int j = 0;
        for (int i = 3; i < 6; i++) {
        	
        	row[i] = grid2[1][j];
        	//System.out.print(newBox[0][i] + " ");
        	j++;
        	
        }
        
        int k = 0;
        for (int i = 6; i < 9; i++) {
        	
        	row[i] = grid3[1][k];
        	//System.out.print(newBox[0][i] + " ");
        	k++;
        	
        }
        
        for (int i = 0; i < 9; i++) {
        	
        	System.out.print(row[i] + " ");
        	
        }
		
		return row;
	}
	
	static int[] makeRow3(int[][] grid1, int[][] grid2, int[][] grid3) {
		
		int[] row = new int[9];
		
        for (int i = 0; i < 3; i++) {
        	
        	row[i] = grid1[2][i];
        	//System.out.print(newBox[0][i] + " ");
        	
        }
        
        int j = 0;
        for (int i = 3; i < 6; i++) {
        	
        	row[i] = grid2[2][j];
        	//System.out.print(newBox[0][i] + " ");
        	j++;
        	
        }
        
        int k = 0;
        for (int i = 6; i < 9; i++) {
        	
        	row[i] = grid3[2][k];
        	//System.out.print(newBox[0][i] + " ");
        	k++;
        	
        }
        
        for (int i = 0; i < 9; i++) {
        	
        	System.out.print(row[i] + " ");
        	
        }
		
		return row;
	}
	
	public static void main(String[] args) throws Exception {
		
		/*
		//int[][] original = new int[3][3];
		int[] rand = new int[9];
		Random rn = new Random();
		int tempRand = 0;
		boolean exists = false;
			
		int box1 = 1;
		int box2 = 2;
		int box3 = 3;
		int box4 = 4;
		int box5 = 5;
		int box6 = 6;
		int box7 = 7;
		int box8 = 8;
		int box9 = 9;
		
		int[][] original = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
					
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				
				System.out.print(original[i][j] + " ");
				
			}
			System.out.println("");
		}
		*/
		int n = 3;
		int[][] magic = new int[n][n];
		//int[][] magicTest = new int[3][3];
		
		//System.out.println(magicTest[][]);
		int l = 0;// vert
		int k = 1;// horiz
		for (int i = 1; i <= 9; i++) {
			
			if (magic[l][k] == 0) {
				magic[l][k] = i;
			} else {
				
				l = l + 2;
				k--;
				
				
				if(l == 3) {	
					l = 0;	
				} else if (l == 4){
					l = 1;
				}
				
				if (k == -1) {
					k = 2;
				}
				
				magic[l][k] = i;
				
			}
			
			if(l == 0) {	
				l = 2;	
			} else {
				l--;
			}
			
			if(k == 2) {
				k = 0;	
			} else {
				k++;
			}
			
		}
		
		System.out.println("Original Grid: ");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(magic[i][j] + " ");
			}
			System.out.println("");
		}
		
		
		//int n = Integer.parseInt(args[0]);
        if (n % 2 == 0) throw new RuntimeException("n must be odd");

        //int[][] magic = new int[n][n];
        int[][] magic2 = new int[n][n];
        int[][] magic3 = new int[n][n];
        int[][] magic4 = new int[n][n];
        int[][] magic5 = new int[n][n];
        int[][] magic6 = new int[n][n];
        int[][] magic7 = new int[n][n];
        int[][] magic8 = new int[n][n];
        int[][] magic9 = new int[n][n];

        /*
        int row = n-1;
        int col = n/2;
        magic[row][col] = 1;

        for (int i = 2; i <= n*n; i++) {
            if (magic[(row + 1) % n][(col + 1) % n] == 0) {
                row = (row + 1) % n;
                col = (col + 1) % n;
            }
            else {
                row = (row - 1 + n) % n;
                // don't change col
            }
            magic[row][col] = i;
        }

        
        // print results
        System.out.println("Original Grid: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (magic[i][j] < 10)  System.out.print(" ");  // for alignment
                if (magic[i][j] < 100) System.out.print(" ");  // for alignment
                System.out.print(magic[i][j] + " ");
            }
            System.out.println();
        }
        */
		
			
        //System.out.println(magic[0][1]);
        System.out.println("grid 2");
        magic2 = shiftVert(magic, magic2);
        System.out.println("grid 3");
        magic3 = shiftVert(magic2, magic3);
        System.out.println("grid 4");
        magic4 = shiftHoriz(magic, magic4);
        System.out.println("grid 5");
        magic5 = shiftHoriz(magic2, magic5);
        System.out.println("grid 6");
        magic6 = shiftHoriz(magic3, magic6);
        System.out.println("grid 7");
        magic7 = shiftHoriz(magic4, magic7);
        System.out.println("grid 8");
        magic8 = shiftHoriz(magic5, magic8);
        System.out.println("grid 9");
        magic9 = shiftHoriz(magic6, magic9);
       
        
        //System.out.println("test");
        //for (int i = 0; i < 3; i++) {
        	
        	//System.out.print(magic[i][0] + " ");
	
        //}
		
		int[] row1 = new int[9];
		int[] row2 = new int[9];
		int[] row3 = new int[9];
		int[] row4 = new int[9];
		int[] row5 = new int[9];
		int[] row6 = new int[9];
		int[] row7 = new int[9];
		int[] row8 = new int[9];
		int[] row9 = new int[9];

		System.out.println("Board 1");
		row1 = makeRow(magic, magic2, magic3);
		System.out.println("");
		row2 = makeRow2(magic, magic2, magic3);
		System.out.println("");
		row3 = makeRow3(magic, magic2, magic3);
		System.out.println("");
		row4 = makeRow(magic4, magic5, magic6);
		System.out.println("");
		row5 = makeRow2(magic4, magic5, magic6);
		System.out.println("");
		row6 = makeRow3(magic4, magic5, magic6);
		System.out.println("");
		row7 = makeRow(magic7, magic8, magic9);
		System.out.println("");
		row8 = makeRow2(magic7, magic8, magic9);
		System.out.println("");
		row9 = makeRow3(magic7, magic8, magic9);
		System.out.println("");
		
		System.out.println("Board 2");
		row7 = makeRow(magic7, magic8, magic9);
		System.out.println("");
		row8 = makeRow2(magic7, magic8, magic9);
		System.out.println("");
		row9 = makeRow3(magic7, magic8, magic9);
		System.out.println("");
		row1 = makeRow(magic, magic2, magic3);
		System.out.println("");
		row2 = makeRow2(magic, magic2, magic3);
		System.out.println("");
		row3 = makeRow3(magic, magic2, magic3);
		System.out.println("");
		row4 = makeRow(magic4, magic5, magic6);
		System.out.println("");
		row5 = makeRow2(magic4, magic5, magic6);
		System.out.println("");
		row6 = makeRow3(magic4, magic5, magic6);
		System.out.println("");
		
		System.out.println("Board 3");
		row4 = makeRow(magic4, magic5, magic6);
		System.out.println("");
		row5 = makeRow2(magic4, magic5, magic6);
		System.out.println("");
		row6 = makeRow3(magic4, magic5, magic6);
		System.out.println("");
		row7 = makeRow(magic7, magic8, magic9);
		System.out.println("");
		row8 = makeRow2(magic7, magic8, magic9);
		System.out.println("");
		row9 = makeRow3(magic7, magic8, magic9);
		System.out.println("");
		row1 = makeRow(magic, magic2, magic3);
		System.out.println("");
		row2 = makeRow2(magic, magic2, magic3);
		System.out.println("");
		row3 = makeRow3(magic, magic2, magic3);
		System.out.println("");
		
		System.out.println("Board 4");
		row9 = makeRow3(magic7, magic8, magic9);
		System.out.println("");
		row8 = makeRow2(magic7, magic8, magic9);
		System.out.println("");
		row7 = makeRow(magic7, magic8, magic9);
		System.out.println("");
		row6 = makeRow3(magic4, magic5, magic6);
		System.out.println("");
		row5 = makeRow2(magic4, magic5, magic6);
		System.out.println("");
		row4 = makeRow(magic4, magic5, magic6);
		System.out.println("");
		row3 = makeRow3(magic, magic2, magic3);
		System.out.println("");
		row2 = makeRow2(magic, magic2, magic3);
		System.out.println("");
		row1 = makeRow(magic, magic2, magic3);
        
        
	}
}