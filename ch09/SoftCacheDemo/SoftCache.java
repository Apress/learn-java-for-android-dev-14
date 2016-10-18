import java.lang.ref.SoftReference;

import java.util.HashMap;

public class SoftCache<K, V>
{
   private HashMap<K, SoftReference<V>> map; 

   public SoftCache()
   {
      map = new HashMap<K, SoftReference<V>>();
   }

   public V get(K key)
   {
      SoftReference<V> softRef = map.get(key);
      if (softRef == null)
         return null;
      return softRef.get();
   }

   public V put(K key, V value)
   {
      SoftReference<V> softRef = map.put(key, new SoftReference<V>(value));
      if (softRef == null)
         return null;
      V oldValue = softRef.get();
      softRef.clear();
      return oldValue;
   }

   public V remove(K key)
   {
      SoftReference<V> softRef = map.remove(key);
      if (softRef == null)
         return null;
      V oldValue = softRef.get();
      softRef.clear();
      return oldValue;
   }
}