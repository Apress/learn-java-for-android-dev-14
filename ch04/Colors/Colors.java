interface Colors
{
   int RED = 1;
   int GREEN = 2;
   int BLUE = 3;
   int BLACK = 4;
}

interface Drawable extends Colors
{
   void draw(int color);
}

interface Fillable extends Colors
{
   void fill(int color);
}