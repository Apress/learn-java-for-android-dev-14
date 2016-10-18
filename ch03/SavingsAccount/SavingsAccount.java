public class SavingsAccount
{
   int balance;

   SavingsAccount deposit(int amount)
   {
      balance += amount;
      return this;
   }

   SavingsAccount printBalance()
   {
      System.out.println(balance);
      return this;      
   }

   public static void main(String[] args)
   {
      new SavingsAccount().deposit(1000).printBalance();
   }
}