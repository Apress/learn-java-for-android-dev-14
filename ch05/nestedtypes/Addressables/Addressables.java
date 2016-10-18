public class Addressables
{
   public static void main(String[] args)
   {
      Addressable[] addressables = 
      {
         new Letter(new Addressable.Address("10", "AnyStreet", "AnyTown")),
         new Parcel(new Addressable.Address("20", "Doe Street", "NewTown")),
         new Postcard(new Addressable.Address("30", "Ender Avenue", "AnyCity"))
      };

      for (Addressable addressable: addressables)
         System.out.println(addressable.getAddress());
   }
}