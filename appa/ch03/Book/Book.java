public class Book
{
   private String name;
   private String author;
   private String isbn;

   public Book(String name, String author, String isbn)
   {
      this.name = name;
      this.author = author;
      this.isbn = isbn;
   }

   public String getName()
   {
      return name;
   }

   public String getAuthor()
   {
      return author;
   }

   public String getISBN()
   {
      return isbn;
   }

   public static void main(String[] args)
   {
      Book[] books = new Book[]
                     {
                        new Book("Jane Eyre", 
                                 "Charlotte Brontë",
                                 "0895772000"),
                        new Book("A Kick in the Seat of the Pants",
                                 "Roger von Oech",
                                 "0060155280"),
                        new Book("The Prince and the Pilgrim",
                                 "Mary Stewart",
                                 "0340649925")
                     };
      for (int i = 0; i < books.length; i++)
         System.out.println(books[i].getName() + " - " +
                            books[i].getAuthor() + " - " +
                            books[i].getISBN());
   }
}