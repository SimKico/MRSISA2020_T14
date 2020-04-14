/***********************************************************************
 * Module:  IzvjestajPregleda.java
 * Author:  natas
 * Purpose: Defines the Class IzvjestajPregleda
 ***********************************************************************/
package com.mrsisa.eclinic.model;

import java.util.*;

/** @pdOid 4240c0d2-69f6-4c4e-9143-625832f3b188 */
public class IzvjestajPregleda {
   /** @pdOid 154d6a62-e222-4ffa-b0f0-5511d4f1540d */
   private String izvjestaj;
   
   /** @pdRoleInfo migr=no name=Pregled assc=association30 mult=1..1 */
   public Pregled pregled;

}