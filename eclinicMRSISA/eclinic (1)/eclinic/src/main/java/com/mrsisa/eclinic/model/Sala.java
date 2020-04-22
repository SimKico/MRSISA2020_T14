package com.mrsisa.eclinic.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tabela_sala")
public class Sala {

	@Id
	@Column(name="broj_sale", unique=true, nullable=false)
   private int brojSale;

}