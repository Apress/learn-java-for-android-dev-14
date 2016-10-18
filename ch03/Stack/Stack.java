public class Stack
{
   private Object[] elements;
   private int top;

   public Stack(int size)
   {
      elements = new Object[size];
      top = -1; // indicate that stack is empty
   }

   public void push(Object o)
   {
      if (top + 1 == elements.length)
      {
         System.out.println("stack is full");
         return;
     }
     elements[++top] = o;
   }

   public Object pop()
   {
      if (top == -1)
      {
         System.out.println("stack is empty");
         return null;
      }
      Object element = elements[top--];
//      elements[top + 1] = null;
      return element;
   }

   public static void main(String[] args)
   {
      Stack stack = new Stack(2);
      stack.push("A");
      stack.push("B");
      stack.push("C");
      System.out.println(stack.pop());
      System.out.println(stack.pop());
      System.out.println(stack.pop());
   }
}