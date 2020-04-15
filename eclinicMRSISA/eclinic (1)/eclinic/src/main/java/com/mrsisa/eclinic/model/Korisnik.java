/***********************************************************************
 * Module:  Korisnik.java
 * Author:  natas
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.*;

/** @pdOid 46306310-94bd-4f4e-85d3-f1f044684e7f */
public class Korisnik {
   /** @pdOid 7e0fc6ac-53ed-45f6-8618-461125a674c9 */
   private boolean aktivan;
   /** @pdOid 13c9439a-fe4c-42a8-990c-c8e8f9da0973 */
   private String ime;
   /** @pdOid ece066bf-9a91-431a-8a84-1727ef776b56 */
   private String prezime;
   
   /** @pdRoleInfo migr=no name=Prijava assc=association1 mult=1..1 type=Composition */
   public Prijava prijava;
   
   /** @pdOid 9ee47e41-7648-4f60-bd3c-a5d4841d3b78 */
   public boolean prijava() {
      // TODO: implement
      return false;
   }

}