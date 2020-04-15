/***********************************************************************
 * Module:  ZdravstveniKarton.java
 * Author:  natas
 * Purpose: Defines the Class ZdravstveniKarton
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.*;

/** @pdOid bbfeb6a0-a610-4d56-9bbc-3685831862e7 */
public class ZdravstveniKarton {
   /** @pdOid df06924d-6664-4bd2-bf6c-bb3141485c78 */
   private int id;
   /** @pdOid 417dbe2e-fa89-442e-8cc4-6e8ebfd2a722 */
   private String krvnaGrupa;
   /** @pdOid 924fde0d-8641-46b0-a5ef-4c93960617f6 */
   private int visinaCm;
   /** @pdOid 7b7be43a-b7b6-4e5f-8b5a-cf265f7d2765 */
   private int tezinaKg;
   /** @pdOid e89b5f63-3978-4f7f-94f1-c697f3d49deb */
   private String alergije;
   /** @pdOid 610a9dd5-bcfb-4d85-ad26-2801daf3e731 */
   private String dioptrija;
   
   /** @pdRoleInfo migr=no name=Operacija assc=association26 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Operacija> operacija;
   /** @pdRoleInfo migr=no name=IzvjestajPregleda assc=association29 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<IzvjestajPregleda> izvjestajPregleda;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Operacija> getOperacija() {
      if (operacija == null)
         operacija = new java.util.HashSet<Operacija>();
      return operacija;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorOperacija() {
      if (operacija == null)
         operacija = new java.util.HashSet<Operacija>();
      return operacija.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newOperacija */
   public void setOperacija(java.util.Collection<Operacija> newOperacija) {
      removeAllOperacija();
      for (java.util.Iterator iter = newOperacija.iterator(); iter.hasNext();)
         addOperacija((Operacija)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newOperacija */
   public void addOperacija(Operacija newOperacija) {
      if (newOperacija == null)
         return;
      if (this.operacija == null)
         this.operacija = new java.util.HashSet<Operacija>();
      if (!this.operacija.contains(newOperacija))
         this.operacija.add(newOperacija);
   }
   
   /** @pdGenerated default remove
     * @param oldOperacija */
   public void removeOperacija(Operacija oldOperacija) {
      if (oldOperacija == null)
         return;
      if (this.operacija != null)
         if (this.operacija.contains(oldOperacija))
            this.operacija.remove(oldOperacija);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllOperacija() {
      if (operacija != null)
         operacija.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<IzvjestajPregleda> getIzvjestajPregleda() {
      if (izvjestajPregleda == null)
         izvjestajPregleda = new java.util.HashSet<IzvjestajPregleda>();
      return izvjestajPregleda;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIzvjestajPregleda() {
      if (izvjestajPregleda == null)
         izvjestajPregleda = new java.util.HashSet<IzvjestajPregleda>();
      return izvjestajPregleda.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIzvjestajPregleda */
   public void setIzvjestajPregleda(java.util.Collection<IzvjestajPregleda> newIzvjestajPregleda) {
      removeAllIzvjestajPregleda();
      for (java.util.Iterator iter = newIzvjestajPregleda.iterator(); iter.hasNext();)
         addIzvjestajPregleda((IzvjestajPregleda)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newIzvjestajPregleda */
   public void addIzvjestajPregleda(IzvjestajPregleda newIzvjestajPregleda) {
      if (newIzvjestajPregleda == null)
         return;
      if (this.izvjestajPregleda == null)
         this.izvjestajPregleda = new java.util.HashSet<IzvjestajPregleda>();
      if (!this.izvjestajPregleda.contains(newIzvjestajPregleda))
         this.izvjestajPregleda.add(newIzvjestajPregleda);
   }
   
   /** @pdGenerated default remove
     * @param oldIzvjestajPregleda */
   public void removeIzvjestajPregleda(IzvjestajPregleda oldIzvjestajPregleda) {
      if (oldIzvjestajPregleda == null)
         return;
      if (this.izvjestajPregleda != null)
         if (this.izvjestajPregleda.contains(oldIzvjestajPregleda))
            this.izvjestajPregleda.remove(oldIzvjestajPregleda);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIzvjestajPregleda() {
      if (izvjestajPregleda != null)
         izvjestajPregleda.clear();
   }

}