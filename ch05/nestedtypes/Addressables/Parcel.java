public class Parcel implements Addressable
{
   private Address address;

   public Parcel(Address address)
   {
      this.address = address;
   }

   @Override
   public Address getAddress()
   {
      return address;
   }
}