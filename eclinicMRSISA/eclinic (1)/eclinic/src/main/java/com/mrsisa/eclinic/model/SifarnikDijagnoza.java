/***********************************************************************
 * Module:  SifarnikDijagnoza.java
 * Author:  natas
 * Purpose: Defines the Class SifarnikDijagnoza
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import static javax.persistence.CascadeType.ALL;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sifarnik_dijagnoza")
public class SifarnikDijagnoza {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="sif_dij_id", unique=true, nullable=false)
    private Long sifDid;
	
	@OneToMany(cascade = {ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name="sifra")
	private Set<Dijagnoza> dijagnoze = new HashSet<Dijagnoza>();
   
//   /** @pdGenerated default getter */
//   public java.util.Collection<Dijagnoza> getDijagnoza() {
//      if (dijagnoza == null)
//         dijagnoza = new java.util.HashSet<Dijagnoza>();
//      return dijagnoza;
//   }
//   
//   /** @pdGenerated default iterator getter */
//   public java.util.Iterator getIteratorDijagnoza() {
//      if (dijagnoza == null)
//         dijagnoza = new java.util.HashSet<Dijagnoza>();
//      return dijagnoza.iterator();
//   }
//   
//   /** @pdGenerated default setter
//     * @param newDijagnoza */
//   public void setDijagnoza(java.util.Collection<Dijagnoza> newDijagnoza) {
//      removeAllDijagnoza();
//      for (java.util.Iterator iter = newDijagnoza.iterator(); iter.hasNext();)
//         addDijagnoza((Dijagnoza)iter.next());
//   }
//   
//   /** @pdGenerated default add
//     * @param newDijagnoza */
//   public void addDijagnoza(Dijagnoza newDijagnoza) {
//      if (newDijagnoza == null)
//         return;
//      if (this.dijagnoza == null)
//         this.dijagnoza = new java.util.HashSet<Dijagnoza>();
//      if (!this.dijagnoza.contains(newDijagnoza))
//         this.dijagnoza.add(newDijagnoza);
//   }
//   
//   /** @pdGenerated default remove
//     * @param oldDijagnoza */
//   public void removeDijagnoza(Dijagnoza oldDijagnoza) {
//      if (oldDijagnoza == null)
//         return;
//      if (this.dijagnoza != null)
//         if (this.dijagnoza.contains(oldDijagnoza))
//            this.dijagnoza.remove(oldDijagnoza);
//   }
//   
//   /** @pdGenerated default removeAll */
//   public void removeAllDijagnoza() {
//      if (dijagnoza != null)
//         dijagnoza.clear();
//   }

}