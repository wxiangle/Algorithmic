class DoubleDimensionalArray {

  public static void main(String[] args) {
    int matrix[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    rotate(matrix);

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  /**
   * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。不占用额外内存空间能否做到？
   * @param matrix
   */
  public static void rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length / 2; i++) {
      for (int j = 0; j < matrix.length; j++) {
        matrix[i][j] = matrix[i][j] ^ matrix[matrix.length - i - 1][j];
        matrix[matrix.length - i - 1][j] =
          matrix[i][j] ^ matrix[matrix.length - i - 1][j];
        matrix[i][j] = matrix[i][j] ^ matrix[matrix.length - i - 1][j];
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < i; j++) {
        matrix[i][j] = matrix[i][j] ^ matrix[j][i];
        matrix[j][i] = matrix[i][j] ^ matrix[j][i];
        matrix[i][j] = matrix[i][j] ^ matrix[j][i];
      }
    }
  }
}
