public class Postcard implements Addressable
{
   private Address address;

   public Postcard(Address address)
   {
      this.address = address;
   }

   @Override
   public Address getAddress()
   {
      return address;
   }
}