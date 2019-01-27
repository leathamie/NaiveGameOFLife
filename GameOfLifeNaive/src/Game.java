import java.util.Scanner;

public class Game {
	 static int [][] grid;
	 static int size;
	 static boolean end = false;
	private static Scanner reader; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 1, 0, 1, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
	        };
		play(grid);
		
	}
	
	static void play(int[][] grid) {
		size = grid.length;
		reader = new Scanner(System.in);
		int nbGenerations = 1;
		while(!end) {
			grid = nextStep(grid);
			System.out.println("genration : " + nbGenerations);
			printGrid(grid);
			nbGenerations += 1;
			System.out.println("Pour afficher la génération suivante 1 + ENTER: ");
			int n = reader.nextInt();
			if (n != 1) {
				break;
			}
		}
		System.out.println("Mort à la géération " + nbGenerations-1);
	}
	static int[][] nextStep(int [][] g) {
		boolean stateEnd = true;
		int [][] nextGrid = new int [size][size];
		for (int i= 0; i < size; i++) {
			for (int j= 0; j < size; j++) {
				int val = cellNextState(g,i,j);
				if (val != 0) {
					stateEnd = false;
				}
				nextGrid[i][j] = val;
			}	
		}
		Game.end = stateEnd;
		return nextGrid;
	}
	
	static int cellNextState(int[][]g, int x, int y){
		int count = 0;
		int a; 
		int b;
		for (int i= x-1; i <= x+1; i++) {
			for (int j= y-1; j <= y+1; j++) {
				a = i;
				b = j;
				if (i < 0) {
					a = size -1;
				}else if(i >= size) {
					a = 0;
				}if (j < 0) {
					b = size -1;
				}else if(j > size -1) {
					b = 0;
				}
				if (g[a][b] == 1) {
					
					count += 1;
				}
			}	
		}
		count = count - g[x][y];
		if (count == 3) {
			return 1;
		}if (count == 2 && g[x][y] == 1) {
			return 1;
		}
		return 0;
	}
	static void printGrid(int[][] g) {
		String s = "";
		for (int i= 0; i < size; i++) {
			for (int j= 0; j < size; j++) {
				if(g[i][j]==1) {
					s += " X ";
				}else {
					s += " O ";
				}
			}
			s += "\n";
		}
		System.out.println(s);
	}

}
