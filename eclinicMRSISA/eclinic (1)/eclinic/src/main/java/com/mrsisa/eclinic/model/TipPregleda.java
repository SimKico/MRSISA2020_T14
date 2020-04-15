/***********************************************************************
 * Module:  TipPregleda.java
 * Author:  natas
 * Purpose: Defines the Class TipPregleda
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.*;

/** @pdOid 83f6ecc3-08e1-4021-b693-0e0c02ab0354 */
public class TipPregleda {
   /** @pdOid 41c80b06-f022-439b-bbe8-eb1510275496 */
   private Double cijena;
   /** @pdOid d40350e0-c8cc-4bcd-b78f-98966d6a798a */
   private String sifra;
   /** @pdOid 3fdfb0ce-0271-4923-b3b2-0a743c918533 */
   private int trajanje;
   /** @pdOid 54d8419f-31e1-402c-9dc8-8f2b25874c34 */
   private Specijalizacija tip;
   
   /** @pdRoleInfo migr=no name=Pregled assc=association4 mult=0..* side=A */
   public Pregled[] pregled;

}