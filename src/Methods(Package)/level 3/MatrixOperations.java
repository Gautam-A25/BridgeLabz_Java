class MatrixOperations {

    public static double[][] createRandomMatrix(int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = (int) (Math.random() * 9) + 1;
        return matrix;
    }

    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row)
                System.out.printf("%8.2f", val);
            System.out.println();
        }
        System.out.println();
    }

    public static double[][] add(double[][] A, double[][] B) {
        int r = A.length, c = A[0].length;
        double[][] result = new double[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }

    public static double[][] subtract(double[][] A, double[][] B) {
        int r = A.length, c = A[0].length;
        double[][] result = new double[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }

    public static double[][] multiply(double[][] A, double[][] B) {
        int r1 = A.length, c1 = A[0].length, c2 = B[0].length;
        double[][] result = new double[r1][c2];
        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c2; j++)
                for (int k = 0; k < c1; k++)
                    result[i][j] += A[i][k] * B[k][j];
        return result;
    }

    public static double[][] transpose(double[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        double[][] t = new double[c][r];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                t[j][i] = matrix[i][j];
        return t;
    }

    public static double determinant2x2(double[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    public static double determinant3x3(double[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
             - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
             + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0) return null;

        return new double[][]{
            { m[1][1] / det, -m[0][1] / det },
            { -m[1][0] / det, m[0][0] / det }
        };
    }

    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (det == 0) return null;

        double[][] inv = new double[3][3];

        inv[0][0] =  (m[1][1]*m[2][2]-m[1][2]*m[2][1]) / det;
        inv[0][1] = -(m[0][1]*m[2][2]-m[0][2]*m[2][1]) / det;
        inv[0][2] =  (m[0][1]*m[1][2]-m[0][2]*m[1][1]) / det;

        inv[1][0] = -(m[1][0]*m[2][2]-m[1][2]*m[2][0]) / det;
        inv[1][1] =  (m[0][0]*m[2][2]-m[0][2]*m[2][0]) / det;
        inv[1][2] = -(m[0][0]*m[1][2]-m[0][2]*m[1][0]) / det;

        inv[2][0] =  (m[1][0]*m[2][1]-m[1][1]*m[2][0]) / det;
        inv[2][1] = -(m[0][0]*m[2][1]-m[0][1]*m[2][0]) / det;
        inv[2][2] =  (m[0][0]*m[1][1]-m[0][1]*m[1][0]) / det;

        return inv;
    }

    public static void main(String[] args) {

        double[][] A = createRandomMatrix(3, 3);
        double[][] B = createRandomMatrix(3, 3);

        System.out.println("Matrix A:");
        displayMatrix(A);

        System.out.println("Matrix B:");
        displayMatrix(B);

        System.out.println("A + B:");
        displayMatrix(add(A, B));

        System.out.println("A - B:");
        displayMatrix(subtract(A, B));

        System.out.println("A x B:");
        displayMatrix(multiply(A, B));

        System.out.println("Transpose of A:");
        displayMatrix(transpose(A));

        System.out.println("Determinant of A: " + determinant3x3(A));

        double[][] invA = inverse3x3(A);
        if (invA != null) {
            System.out.println("Inverse of A:");
            displayMatrix(invA);
        } else {
            System.out.println("Inverse of A does not exist.");
        }
    }
}
