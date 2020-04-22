package com.mrsisa.eclinic.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="sale")
public class Sala {

	@Id
	@Column(name="broj_sale", unique=true, nullable=false)
    private int brojSale;

}