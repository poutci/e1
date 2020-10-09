
public class Matrix {
	public static void main(String[] args) {
		int row = 3; //1
		int column = 3; //1
		int[][] matrix1 = {{1,2,5}, {4,7,2}, {1,7,3}}; //1
		int[][] matrix2 = {{3,7,8}, {8,1,0}, {1,3,8}}; //1
		int[][] matrixAdd = new int[row][column]; //1
		int[][] matrixMulti = new int[row][column]; //1
		
		//this adds the two matrices together 
		for(int i = 0; i < row; i++) { //n*n+2
			for(int j = 0; j < column; j++) { //n
				matrixAdd[i][j] = matrix1[i][j]+matrix2[i][j]; //2
			}
		}// n^2 +2 
		
		//this multiplies the two matrices together
		for(int i = 0; i < row; i++) { //n*n+3
			for(int j = 0; j < column; j++) {//n
				matrixMulti[i][j] += matrix1[i][j]*matrix2[i][j]; //3
			}
		}//n^2+3
		
		//this displays the matrices
		System.out.println("Addition of two matrices"); //1
		for(int i = 0; i < row; i++) { //n*n+1+1
			for(int j = 0; j < column; j++) { //n
				System.out.print(matrixAdd[i][j] + " "); //1
			}
			System.out.println(); //1
		} // n^2 + 2
		System.out.println("Multiplication of two matrices"); //1
		for(int i = 0; i < row; i++) { //n*n + 2
			for(int j = 0; j < column; j++) { //n
				System.out.print(matrixMulti[i][j] + " "); //1
			}
			System.out.println(); //1
		}
	} //n^2 + 2

} // 4n^2 + 15 operations O(n^2) in runtime
