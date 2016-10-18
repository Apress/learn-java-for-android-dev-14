public interface Addressable
{
   class Address
   {
      private String boxNumber;
      private String street;
      private String city;

      public Address(String boxNumber, String street, String city)
      {
         this.boxNumber = boxNumber;
         this.street = street;
         this.city = city;
      }

      public String getBoxNumber()
      {
         return boxNumber;
      }

      public String getStreet()
      {
         return street;
      }

      public String getCity()
      {
         return city;
      }

      @Override
      public String toString()
      {
         return boxNumber+" - "+street+" - "+city;
      }
   }

   Address getAddress();
}