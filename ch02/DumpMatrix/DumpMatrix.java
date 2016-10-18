public class DumpMatrix
{
   public static void main(String[] args)
   {
      float[][] matrix = { { 1.0F, 2.0F, 3.0F }, { 4.0F, 5.0F, 6.0F }};
      for (int row = 0; row < matrix.length; row++)
      {
         for (int col = 0; col < matrix[row].length; col++)
            System.out.print(matrix[row][col] + " ");
         System.out.print("\n");
      }
   }
}