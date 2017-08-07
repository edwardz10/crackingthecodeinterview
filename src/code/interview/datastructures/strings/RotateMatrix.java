package code.interview.datastructures.strings;

public class RotateMatrix {

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public static void rotateMatrixMatrix(int[][] matrix) {
		int[][] new_matrix = new int[matrix.length][matrix.length]; 

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				new_matrix[j][matrix.length - i - 1] = matrix[i][j];
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = new_matrix[i][j];
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9 }
		};

		System.out.println("Initial matrix:");
		printMatrix(matrix);
		rotateMatrixMatrix(matrix);
		System.out.println("Rotated matrix:");
		printMatrix(matrix);
	}
}
