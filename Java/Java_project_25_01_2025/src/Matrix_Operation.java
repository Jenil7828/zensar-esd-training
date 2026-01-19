import java.util.Scanner;

public class Matrix_Operation {
	Scanner scan = new Scanner(System.in);
	int mat1[][];
	int mat2[][];
	int mat3[][];
	int row, column;
	
	int[][] matrix_input() {
		System.out.print("Enter the Dimension of Matrix: ");
		row = scan.nextInt();
		column = scan.nextInt();
		int [][]mat = new int[row][column];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				System.out.print("Enter the element: ["+i+"]["+j+"]: ");
				mat[i][j] = scan.nextInt();
			}
		}
		return mat;
	}
	
	int[][] add(int mat1[][], int mat2[][]){
		int [][]mat3 = new int[mat1.length][mat1[0].length];
		if (mat1.length == mat2.length && mat1[0].length == mat2[0].length ) {
			for(int i = 0; i < mat1.length; i++) {
				for(int j = 0; j < mat1[0].length; j++) {
					mat3[i][j] = mat1[i][j]+mat2[i][j];
				}
			}
		}
		else {
			return null;
		}
		return mat3;
	}
	int[][] sub(int mat1[][], int mat2[][]){
		int [][]mat3 = new int[mat1.length][mat1[0].length];
		if (mat1.length == mat2.length && mat1[0].length == mat2[0].length ) {
			for(int i = 0; i < mat1.length; i++) {
				for(int j = 0; j < mat1[0].length; j++) {
					mat3[i][j] = mat1[i][j]-mat2[i][j];
				}
			}
		}
		else {
			return null;
		}
		return mat3;
	}
	
	int[][] multiply(int mat1[][], int mat2[][]){
		int [][]mat3 = new int[mat1.length][mat2[0].length];
		if(mat1[0].length == mat2.length) {
			for(int i = 0; i < mat1.length; i++) {
				for(int j = 0; j < mat2[0].length; j++) {
					for(int k= 0; k < mat2.length; k++) {
						mat3[i][j]= mat1[i][k]*mat2[j][k]+mat3[i][j];
					}
				}
			}
		}
		else {
			return null;
		}
		return mat3;
	}
	void display(int[][] mat) {
		for(int i=0; i <mat.length; i++) {
			for (int j = 0 ; j < mat[0].length; j++) {
				System.out.print(mat[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Matrix_Operation a = new Matrix_Operation();
		Matrix_Operation b = new Matrix_Operation();
		int [][]m1 = a.matrix_input();
		int [][]m2 = b.matrix_input();
		System.out.println("The values of matrix 1: ");
		a.display(m1);
		System.out.println("The values of matrix 2: ");
		a.display(m2);
		
		int res[][] = a.add(m1, m2);
		if(res != null) {
			System.out.println("Addition of matrix 1 and 2");
			a.display(res);
		}
		else {
			System.out.println("Mismatched Dimension ");
		}
		res = a.multiply(m1, m2);
		if(res != null) {
			System.out.println("Multiplication of matrix 1 and 2");
			a.display(res);
		}
		else {
			System.out.println("Mismatched Dimension ");
		}
		res = a.sub(m1, m2);
		if(res != null) {
			System.out.println("Subtraction of matrix 1 and 2");
			a.display(res);
		}
		else {
			System.out.println("Mismatched Dimension ");
		}
		
	}
}
