/***********************************************************************
 * Module:  Prijava.java
 * Author:  natas
 * Purpose: Defines the Class Prijava
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.*;

/** @pdOid eb1dab53-e698-4ee0-9069-17053809915b */
public class Prijava {
   /** @pdOid c000995c-f38f-4e03-910d-683cd70c2fcf */
   private String eAdresa;
   /** @pdOid 2fec05f9-b50e-409c-9f10-fa5cf9c74f77 */
   private String lozinka;
   
   /** @pdRoleInfo migr=no name=Korisnik assc=association1 mult=1..1 side=A */
   public Korisnik korisnik;

}