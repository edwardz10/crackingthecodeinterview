package code.interview.datastructures.strings;

public class SetMatrixLinesToZero {

	public static void setLinesToZero(int[][] initialMatrix) {
		int length = initialMatrix.length;// / initialMatrix[0].length;
		int width = initialMatrix[0].length;// / initialMatrix[0].length;
		System.out.println("Matrix length: " + length + ", width: " + width);

		boolean[] rows = new boolean[length];
		boolean[] cols = new boolean[width];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				if (initialMatrix[i][j] == 0) {
					System.out.println("Row " + i + " and column " + j + " marked to set to zero!");
					rows[i] = true;
					cols[j] = true;
				}
			}
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				if (rows[i] || cols[j]) {
					initialMatrix[i][j] = 0;				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{ 1, 2, 3, 11},
			{ 4, 5, 6, 0 },
			{ 7, 8, 9, 9 }
		};

		RotateMatrix.printMatrix(matrix);
		setLinesToZero(matrix);
		RotateMatrix.printMatrix(matrix);
	}
}
