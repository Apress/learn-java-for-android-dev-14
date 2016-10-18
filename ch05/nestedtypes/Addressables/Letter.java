public class Letter implements Addressable
{
   private Address address;

   public Letter(Address address)
   {
      this.address = address;
   }

   @Override
   public Address getAddress()
   {
      return address;
   }
}