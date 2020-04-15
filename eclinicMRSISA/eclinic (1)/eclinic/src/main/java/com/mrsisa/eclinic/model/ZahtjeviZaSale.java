/***********************************************************************
 * Module:  ZahtjeviZaSale.java
 * Author:  natas
 * Purpose: Defines the Class ZahtjeviZaSale
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.*;

/** @pdOid 4e72ffb4-d39f-4946-9f5b-f414b2994a19 */
public class ZahtjeviZaSale {
   /** @pdOid 5f70130e-6017-4495-a311-e4518f3ab77d */
   private Date datum;
   /** @pdOid 49c3a7ed-fb30-4489-b457-7a64afa6061c */
   private String satnica;
   /** @pdOid ef0f085f-0069-4578-887c-4806b56c647e */
   private boolean prihvacen;
   
   /** @pdRoleInfo migr=no name=Sala assc=association33 mult=1..1 */
   public Sala sala;

}