package ruandao.math;

import java.util.*;

import ruandao.utility.Console;

public class Mine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. height, width, count
		//2. 打印　所有的地雷，每个地雷一行，形式：　（行号，列号）
		int rows = Console.inputInt("输入行数：");
		int cols = Console.inputInt("输入列数：");
		int mines = Console.inputInt("输入雷数：");
		int[][] ceils;
		
		ceils = bulei(rows, cols, mines);
		for(int i=1; i<rows+1; i++){
			for(int j=1; j<cols+1; j++){
				if( ceils[i][j] == -1 ){
					System.out.println("(" + i +  "," + j + ")");
				}
			}
		}
		
		
		ceils = startGame(rows, cols, mines);
		for(int i=1; i<rows+1; i++){
			for(int j=1; j<cols+1; j++){
				String s = "" ;
				s = " " + ceils[i][j];
				if( ceils[i][j] == -1 ) s = " *"; 
				if( ceils[i][j] == 0  ) s = " -";
				System.out.print(s);
			}
			System.out.println();
		}
		
	}
	
	public static int[][] bulei(int rows, int cols, int mines){
		int[][] ceils = new int[rows+1][cols+1];
		
		int i = 0, j = 0, count = 0;
   		Random random = new Random();
        do
        {
            i = 1+random.nextInt(rows);
            j = 1+random.nextInt(cols);
            if (ceils[i][j] == -1) continue;
            ceils[i][j] = -1;
            count++;
        } while (count < mines);
		
        return ceils;
	}
	
	
	public static int[][] startGame(int rows, int cols, int mines){
		int[][] ceils = new int[rows+2][cols+2];
		
		int i = 0, j = 0, count = 0;
   		Random random = new Random();
        do
        {
            i = 1+random.nextInt(rows);
            j = 1+random.nextInt(cols);
            if (ceils[i][j] == -1) continue;
            ceils[i][j] = -1;
            count++;
        } while (count < mines);
		
        for ( i = 0; i < rows + 2; i++)
        {
            for ( j = 0; j < cols + 2; j++)
            {
                if ( ceils[i][j] == -1 ) continue;
                if (i == 0 || j == 0 || i == rows + 1 || j == cols + 1)
                {
                    continue;
                }
                ceils[i][j] = roundNumber(ceils, i, j);
            }
        }
        return ceils;
	}

    public static int roundNumber(int[][]ceils, int row, int col)
    {
        int n = 0;
        if (ceils[row - 1][col - 1] == -1) n += 1;
        if (ceils[row - 1][col]     == -1) n += 1;
        if (ceils[row - 1][col + 1] == -1) n += 1;
        if (ceils[row][col - 1]     == -1) n += 1;
        if (ceils[row][col + 1]     == -1) n += 1;
        if (ceils[row + 1][col - 1] == -1) n += 1;
        if (ceils[row + 1][col]     == -1) n += 1;
        if (ceils[row + 1][col + 1] == -1) n += 1;
        return n ;
    }

}
