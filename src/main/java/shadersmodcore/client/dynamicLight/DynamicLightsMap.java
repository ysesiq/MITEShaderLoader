package shadersmodcore.client.dynamicLight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicLightsMap {
   private Map map = new HashMap();
   private List list = new ArrayList();
   private boolean dirty = false;

   public DynamicLight put(int id, DynamicLight dynamicLight) {
      DynamicLight dynamiclight = (DynamicLight)this.map.put(id, dynamicLight);
      this.setDirty();
      return dynamiclight;
   }

   public DynamicLight get(int id) {
      return (DynamicLight)this.map.get(id);
   }

   public int size() {
      return this.map.size();
   }

   public DynamicLight remove(int id) {
      DynamicLight dynamiclight = (DynamicLight)this.map.remove(id);
      if (dynamiclight != null) {
         this.setDirty();
      }

      return dynamiclight;
   }

   public void clear() {
      this.map.clear();
      this.list.clear();
      this.setDirty();
   }

   private void setDirty() {
      this.dirty = true;
   }

   public List valueList() {
      if (this.dirty) {
         this.list.clear();
         this.list.addAll(this.map.values());
         this.dirty = false;
      }

      return this.list;
   }
}
