/***********************************************************************
 * Module:  Operacija.java
 * Author:  natas
 * Purpose: Defines the Class Operacija
 ***********************************************************************/
package com.mrsisa.eclinic.model;

import java.util.*;

/** @pdOid 909247bd-94f6-44a4-85bd-57a9ccdddd68 */
public class Operacija {
   /** @pdOid 394fa128-c14b-4045-8bc4-61e62a17b173 */
   private String idOperacije;
   /** @pdOid 0db5ace3-ab79-4684-a462-8fe726b627b5 */
   private int trajanje;
   
   /** @pdRoleInfo migr=no name=Sala assc=association35 mult=1..1 */
   public Sala sala;

}