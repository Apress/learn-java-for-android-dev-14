enum Coin
{
   PENNY(1),
   NICKEL(5),
   DIME(10),
   QUARTER(25);

   private final int denomValue;

   Coin(int denomValue)
   {
      this.denomValue = denomValue;
   }

   int denomValue()
   {
      return denomValue;
   }

   int toDenomination(int numPennies)
   {
      return numPennies / denomValue;
   }
}