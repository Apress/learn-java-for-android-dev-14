public class Graph
{
   final static int ROWS = 11; // Must be odd
   final static int COLS= 23;

   public static void main(String[] args)
   {
      char[][] screen = new char[ROWS][COLS];
      for (int row = 0; row < screen.length; row++)
         for (int col = 0; col < screen[0].length; col++)
            screen[row][col] = ' ';
      double scaleX = COLS / 360.0;
      for (int degree = 0; degree < 360; degree++)
      {
         int row = ROWS / 2 +
                   (int) Math.round(ROWS / 2 * Math.sin(Math.toRadians(degree)));
         int col = (int) (degree * scaleX);
         screen[row][col] = 'S';
         row = ROWS / 2 +
               (int) Math.round(ROWS / 2 * Math.cos(Math.toRadians(degree)));
         screen[row][col] = (screen[row][col] == 'S') ? '*' : 'C';
      }
      for (int row = ROWS - 1; row >= 0; row--)
      {
         for (int col = 0; col < COLS; col++)
            System.out.print(screen[row][col]);
         System.out.println();
      }
   }
}