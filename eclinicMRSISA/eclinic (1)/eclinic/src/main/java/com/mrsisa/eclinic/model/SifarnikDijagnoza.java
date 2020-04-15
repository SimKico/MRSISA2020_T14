/***********************************************************************
 * Module:  SifarnikDijagnoza.java
 * Author:  natas
 * Purpose: Defines the Class SifarnikDijagnoza
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.*;

/** @pdOid c58d74e8-a429-478e-b586-97ebd9dcd310 */
public class SifarnikDijagnoza {
   /** @pdRoleInfo migr=no name=Dijagnoza assc=association44 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Dijagnoza> dijagnoza;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Dijagnoza> getDijagnoza() {
      if (dijagnoza == null)
         dijagnoza = new java.util.HashSet<Dijagnoza>();
      return dijagnoza;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorDijagnoza() {
      if (dijagnoza == null)
         dijagnoza = new java.util.HashSet<Dijagnoza>();
      return dijagnoza.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newDijagnoza */
   public void setDijagnoza(java.util.Collection<Dijagnoza> newDijagnoza) {
      removeAllDijagnoza();
      for (java.util.Iterator iter = newDijagnoza.iterator(); iter.hasNext();)
         addDijagnoza((Dijagnoza)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newDijagnoza */
   public void addDijagnoza(Dijagnoza newDijagnoza) {
      if (newDijagnoza == null)
         return;
      if (this.dijagnoza == null)
         this.dijagnoza = new java.util.HashSet<Dijagnoza>();
      if (!this.dijagnoza.contains(newDijagnoza))
         this.dijagnoza.add(newDijagnoza);
   }
   
   /** @pdGenerated default remove
     * @param oldDijagnoza */
   public void removeDijagnoza(Dijagnoza oldDijagnoza) {
      if (oldDijagnoza == null)
         return;
      if (this.dijagnoza != null)
         if (this.dijagnoza.contains(oldDijagnoza))
            this.dijagnoza.remove(oldDijagnoza);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllDijagnoza() {
      if (dijagnoza != null)
         dijagnoza.clear();
   }

}