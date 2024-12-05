import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[][] matrix = new float[3][3];

        System.out.println("Enter the elements of the 3x3 matrix row by row (3 numbers per line, separated by spaces):");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter row " + (i + 1) + ": ");
            String input = scanner.nextLine();
            String[] elements = input.split("\\s+");

            if (elements.length != 3) {
                System.out.println("Enter 3 numbers.");
                i--;
                continue;
            }

            try {
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = Float.parseFloat(elements[j]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter floats.");
                i--; // This will allow the user to re-enter the row
            }
        }
        scanner.close();
        Matrix myMatrixObject = new Matrix(matrix);
        myMatrixObject.inverseMatrix();
        myMatrixObject.prettyPrintMatrix();

    }
}