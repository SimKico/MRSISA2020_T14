/***********************************************************************
 * Module:  Pregled.java
 * Author:  natas
 * Purpose: Defines the Class Pregled
 ***********************************************************************/
package com.mrsisa.eclinic.model;

import java.util.*;

/** @pdOid 8ae40554-59e7-47f5-8a70-7a7be18186e4 */
public class Pregled {
   /** @pdOid c06d2242-8a35-4481-9d3f-2620d3121331 */
   private Date datum;
   /** @pdOid 9f5d08fa-5010-4e8a-98d3-380e0a544f42 */
   private int trajanje;
   /** @pdOid 0022ba4d-f962-47cc-9eeb-3bb9028fcef9 */
   private Date vrijemePocetka;
   /** @pdOid 59626d41-0360-413d-9cc8-5e5679c8a62f */
   private boolean odrzan;
   /** @pdOid bc3b55b4-6c30-45a6-b72d-49f98e89252e */
   private boolean slobodan;
   
   /** @pdRoleInfo migr=no name=TipPregleda assc=association4 mult=1..1 */
   public TipPregleda tipPregleda;
   /** @pdRoleInfo migr=no name=Sala assc=association32 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Sala> sala;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Sala> getSala() {
      if (sala == null)
         sala = new java.util.HashSet<Sala>();
      return sala;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSala() {
      if (sala == null)
         sala = new java.util.HashSet<Sala>();
      return sala.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSala */
   public void setSala(java.util.Collection<Sala> newSala) {
      removeAllSala();
      for (java.util.Iterator iter = newSala.iterator(); iter.hasNext();)
         addSala((Sala)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newSala */
   public void addSala(Sala newSala) {
      if (newSala == null)
         return;
      if (this.sala == null)
         this.sala = new java.util.HashSet<Sala>();
      if (!this.sala.contains(newSala))
         this.sala.add(newSala);
   }
   
   /** @pdGenerated default remove
     * @param oldSala */
   public void removeSala(Sala oldSala) {
      if (oldSala == null)
         return;
      if (this.sala != null)
         if (this.sala.contains(oldSala))
            this.sala.remove(oldSala);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSala() {
      if (sala != null)
         sala.clear();
   }

}