/***********************************************************************
 * Module:  MedicinskaSestra.java
 * Author:  natas
 * Purpose: Defines the Class MedicinskaSestra
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MS")
public class MedicinskaSestra extends Korisnik {
}