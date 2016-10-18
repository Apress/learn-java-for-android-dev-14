public class Queue<E>
{
   private E[] elements;
   private int head, tail;

   @SuppressWarnings("unchecked")
   Queue(int size)
   {
      if (size < 2)
         throw new IllegalArgumentException("" + size);
      elements = (E[]) new Object[size];
      head = 0;
      tail = 0;
   }

   void insert(E element) throws QueueFullException
   {
      if (isFull())
         throw new QueueFullException();
      elements[tail] = element;
      tail = (tail + 1) % elements.length;
   }

   E remove() throws QueueEmptyException
   {
      if (isEmpty())
         throw new QueueEmptyException();
      E element = elements[head];
      head = (head + 1) % elements.length;
      return element;
   }

   boolean isEmpty()
   {
      return head == tail;
   }

   boolean isFull()
   {
      return (tail + 1) % elements.length == head;
   }

   public static void main(String[] args)
      throws QueueFullException, QueueEmptyException
   {
      Queue<String> queue = new Queue<String>(6);
      System.out.println("Empty: " + queue.isEmpty());
      System.out.println("Full: " + queue.isFull());
      System.out.println("Adding A");
      queue.insert("A");
      System.out.println("Adding B");
      queue.insert("B");
      System.out.println("Adding C");
      queue.insert("C");
      System.out.println("Adding D");
      queue.insert("D");
      System.out.println("Adding E");
      queue.insert("E");
      System.out.println("Empty: " + queue.isEmpty());
      System.out.println("Full: " + queue.isFull());
      System.out.println("Removing " + queue.remove());
      System.out.println("Empty: " + queue.isEmpty());
      System.out.println("Full: " + queue.isFull());
      System.out.println("Adding F");
      queue.insert("F");
      while (!queue.isEmpty())
         System.out.println("Removing " + queue.remove());
      System.out.println("Empty: " + queue.isEmpty());
      System.out.println("Full: " + queue.isFull());
   }
}

class QueueEmptyException extends Exception
{
}

class QueueFullException extends Exception
{
}