package P1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MagicSquare {
    
	public static boolean generateMagicSquare(int n) {

		if (n % 2 == 0) {
			System.out.println("Input an even number!");
			return false;
		}
		if (n <= 0) {
			System.out.println("Input a negative number!");
			return false;
		}
		try {
			System.setOut(new PrintStream("src/P1/txt/6.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int magic[][] = new int[n][n];
		int row = 0, col = n / 2, i, j, square = n * n;

		for (i = 1; i <= square; i++) {
			magic[row][col] = i;
			if (i % n == 0)
				row++;
			else {
				if (row == 0)
					row = n - 1;
				else
					row--;
				if (col == (n - 1))
					col = 0;
				else
					col++;
			}
		}

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++)
				System.out.print(magic[i][j] + "\t");
			System.out.println();
		}

		return true;
		}
	public static boolean isConSpeCharacters(String string) {
		if (string.replaceAll("\\d*\\t*\\n*-*.*", "").length() == 0) {
			
			return true;
		}
		return false;
	}
	public static boolean isLegalMagicSquare(String fileName) throws IOException 
	{
		File file =new File("src/P1/txt/"+fileName); 
		BufferedReader in = null;
		in = new BufferedReader(new FileReader(file));
		String templine=null;
		templine=in.readLine();
		String [] a=templine.split("\t");
		String[][] ss;
		int rows=0,cols;
		cols=a.length;
		ss = new String[cols][cols];
		ss[rows]=a;
		
		while((templine=in.readLine())!=null)
		{
			if (!isConSpeCharacters(templine)) {
				System.out.print("Contains other delimiters! ");
				return false;
			}
			a=templine.split("\t");
			rows++;
			ss[rows]=a;
			if(a.length!=cols) 
			{
				System.out.print("wrong\n");
				return false;
			}
		}
		rows++;
		if(rows!=cols) 
		{
			System.out.println("rows != cols\n");
			return false;
		}
		//System.out.print("cols:"+cols+"\n");
		int[][] aim =new int[200][200];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				try {
					aim[i][j] = Integer.valueOf(ss[i][j]);
				} catch (NumberFormatException e) {
					System.out.print("Square" + "[" + i + "]" + "[" + j + "]" + "is not integer. ");
					return false;
				}
				if (aim[i][j] <= 0) {
					System.out.print("Square" + "[" + i + "]" + "[" + j + "]" + " is negative integer. ");
					return false;
				}
				// System.out.printf("%d\t", square[i][j]);
			}
			// System.out.println();
		}
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				System.out.print(aim[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
		int num=0;
		for(int i=0;i<rows;i++)
		{
			int sum=0;
			for(int j=0;j<cols;j++)
			{
				sum+=aim[i][j];
			}
			if(i==0) num=sum;
			if(sum!=num)
			{
				System.out.print(i);
				System.out.println("rows miss match\n");
				return false;
			}
		}
		System.out.println("rows match\n");
		for(int i=0;i<rows;i++)
		{
			int sum=0;
			for(int j=0;j<cols;j++)
			{
				sum+=aim[j][i];
			}
			if(sum!=num)
			{
				//System.out.print(i);
				System.out.println("cols miss match\n");
				return false;
			}
		}
		System.out.println("cols match\n");
		int sum=0;
		for(int i=0;i<rows;i++)
		{
			sum+=aim[i][i];
		}
		if(sum!=num)
		{
			//System.out.print(i);
			System.out.println("other1 miss match\n");
		}
		System.out.println("other1 match\n");
		sum=0;
		for(int i=0;i<rows;i++)
		{
			sum+=aim[i][rows-i-1];
		}
		if(sum!=num)
		{
			//System.out.print(i);
			System.out.println("other2 miss match\n");
		}
		System.out.println("other2 match\n");
         //reader.close();
		return true;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		String fileName="1.txt";
		boolean ans;
		String s;
		PrintStream out = System.out;
		Scanner in = new Scanner(System.in);
		int n = 0;
		boolean a;
		a=isLegalMagicSquare("1.txt");
		System.out.print(a+"\n");
		a=isLegalMagicSquare("2.txt");
		System.out.print(a+"\n");
		a=isLegalMagicSquare("3.txt");
		System.out.print(a+"\n");
		a=isLegalMagicSquare("4.txt");
		System.out.print(a+"\n");
		a=isLegalMagicSquare("5.txt");
		System.out.print(a+"\n");
		
		try {
			n = in.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Something input is not an integer!");
			return;
		}
		ans = generateMagicSquare(n) & isLegalMagicSquare("6.txt");
		System.setOut(out);
		if (!ans) {
			System.out.println(ans);
		} else
			System.out.println("6.txt " + ans);
	}
	
	

}
