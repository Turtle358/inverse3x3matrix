import java.util.Arrays;
/*
How to calculate the inverse of a 3x3 matrix
D - dirty
M - miners
C - cough
T - (on public) transport
D - (and) Die
Morbid but works ^

1. Calculate the determinate (D)
2. Calculate the matrix of Minors (M)
3. Apply the cofactor matrix (C):
    |+ - +|
    |- + -|
    |+ - +|
4. Transpose the matrix (along the leading diagonal) (T)
5. Multiply every item in the matrix by 1/determinate (D)
*/

public class Matrix {
    private float[][] matrix;
    public Matrix(float[][] matrix) {
        this.matrix = matrix;
    }

    public float determinant2x2(float a, float b, float c, float d) {
        // Calculate the determinate of a 2x2 matrix using the formula a*d - b*c
        return a*d - b*c;
    }

    public float[][] getRawMatrix() {
        return this.matrix;
    }

    public float determinant3x3() {
        // Get items in each position (as shown below)
        float a = matrix[0][0], b = matrix[0][1], c = matrix[0][2];
        float d = matrix[1][0], e = matrix[1][1], f = matrix[1][2];
        float g = matrix[2][0], h = matrix[2][1], i = matrix[2][2];
        // use the standard determinate 3x3 formula to calculate the determinate, using the 2x2 function
        return a * determinant2x2(e,f,h,i)
                - b * determinant2x2(d, f, g, i)
                + c * determinant2x2(d, e, g, h);
    }

    public void matrixMinors() {
        float[][] minors = new float[3][3];
        // Calculate minors for each element
        minors[0][0] = determinant2x2(matrix[1][1], matrix[1][2], matrix[2][1], matrix[2][2]);
        minors[0][1] = determinant2x2(matrix[1][0], matrix[1][2], matrix[2][0], matrix[2][2]);
        minors[0][2] = determinant2x2(matrix[1][0], matrix[1][1], matrix[2][0], matrix[2][1]);

        minors[1][0] = determinant2x2(matrix[0][1], matrix[0][2], matrix[2][1], matrix[2][2]);
        minors[1][1] = determinant2x2(matrix[0][0], matrix[0][2], matrix[2][0], matrix[2][2]);
        minors[1][2] = determinant2x2(matrix[0][0], matrix[0][1], matrix[2][0], matrix[2][1]);

        minors[2][0] = determinant2x2(matrix[0][1], matrix[0][2], matrix[1][1], matrix[1][2]);
        minors[2][1] = determinant2x2(matrix[0][0], matrix[0][2], matrix[1][0], matrix[1][2]);
        minors[2][2] = determinant2x2(matrix[0][0], matrix[0][1], matrix[1][0], matrix[1][1]);
        matrix = minors;
    }

    public void applyCofactorMatrix() {
        // Apply the cofactor matrix to our matrix
        int[][] cofactor = {{1, -1, 1},
                            {-1, 1, -1},
                            {1, -1, 1}};
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                matrix[i][j] = cofactor[i][j]*matrix[i][j];
            }
        }
    }

    public void transpose() {
        // transpose our matrix
        float[][] transposed = new float[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                transposed[i][j] = matrix[j][i];
            }
        }
        // Store it in our matrix variable
        matrix = transposed;
    }

    public void multiplyEveryItemByFloat(float a) {
        // for every item in the matrix, multiply it by a scalar (a)
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                matrix[i][j] = a*matrix[i][j];
            }
        }
    }

    public void inverseMatrix() {
        // Finally, inverse the matrix
        float determinate = determinant3x3();
        if((int) determinate == 0) {
            throw new IllegalArgumentException("The determinate of the matrix must not be 0");
        }
        matrixMinors();
        applyCofactorMatrix();
        transpose();
        multiplyEveryItemByFloat(1/determinate);
    }

    public void prettyPrintMatrix() {
        // This is not needed to inverse the matrix, it just makes it look nice in the console
        for (float[] row : matrix) {
            System.out.printf("| ");
            for (int i = 0; i < row.length; i++) {
                System.out.printf("%.6f", row[i]);
                if (i < row.length - 1) {
                    System.out.printf(" ");
                }
            }
            System.out.println(" |");
        }
    }
}