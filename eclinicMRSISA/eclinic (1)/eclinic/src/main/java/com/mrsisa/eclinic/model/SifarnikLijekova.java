/***********************************************************************
 * Module:  SifarnikLijekova.java
 * Author:  natas
 * Purpose: Defines the Class SifarnikLijekova
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.*;

/** @pdOid f142bc74-461a-4fd8-8157-7c6da49fcf35 */
public class SifarnikLijekova {
   /** @pdRoleInfo migr=no name=Lijek assc=association40 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Lijek> lijek;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Lijek> getLijek() {
      if (lijek == null)
         lijek = new java.util.HashSet<Lijek>();
      return lijek;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorLijek() {
      if (lijek == null)
         lijek = new java.util.HashSet<Lijek>();
      return lijek.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newLijek */
   public void setLijek(java.util.Collection<Lijek> newLijek) {
      removeAllLijek();
      for (java.util.Iterator iter = newLijek.iterator(); iter.hasNext();)
         addLijek((Lijek)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newLijek */
   public void addLijek(Lijek newLijek) {
      if (newLijek == null)
         return;
      if (this.lijek == null)
         this.lijek = new java.util.HashSet<Lijek>();
      if (!this.lijek.contains(newLijek))
         this.lijek.add(newLijek);
   }
   
   /** @pdGenerated default remove
     * @param oldLijek */
   public void removeLijek(Lijek oldLijek) {
      if (oldLijek == null)
         return;
      if (this.lijek != null)
         if (this.lijek.contains(oldLijek))
            this.lijek.remove(oldLijek);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllLijek() {
      if (lijek != null)
         lijek.clear();
   }

}