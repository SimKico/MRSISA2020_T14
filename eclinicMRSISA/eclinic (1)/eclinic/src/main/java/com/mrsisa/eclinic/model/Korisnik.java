/***********************************************************************
 * Module:  Korisnik.java
 * Author:  natas
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/
package com.mrsisa.eclinic.model;
import java.util.*;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="tabela_korisnika")
@Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(name="user_type", discriminatorType = STRING)
public class Korisnik implements UserDetails {

	private static final long serialVersionUID = 1L;
	
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="id", unique=true, nullable=false)
   private Long id;
   
   @Column(name = "user_type", insertable = false, updatable = false)
   private String tip;
	
   @Column(name="aktivan", unique=false, nullable=false, columnDefinition = "boolean default false")
   private boolean aktivan;
   
   @Column(name="ime", unique=false, nullable=false)
   private String ime;
   
   @Column(name="prezime", unique=false, nullable=false)
   private String prezime;
   
   @Column(name="dodijeljena_lozinka", unique=false,columnDefinition = "boolean default false")
	private boolean dodijeljenaLozinka;
   
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
   
   @OneToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="prijava_id", referencedColumnName="eadresa")
   public Prijava prijava;
   
	
	// SPRING SECURITY
	//====================================================================================

	private boolean enabled;

	private Date lastPasswordResetDate;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
	private List<Authority> authorities;

	//====================================================================================
	
	
  public Korisnik() {
		super();
	
  }
   public boolean prijava() {
      // TODO: implement
      return false;
   }
   
	public boolean isDodijeljenaLozinka() {
		return dodijeljenaLozinka;
	}


	public void setDodijeljenaLozinka(boolean dodijeljenaLozinka) {
		this.dodijeljenaLozinka = dodijeljenaLozinka;
	}
	    
	public String getTip() {
		return tip;
	}


	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public boolean isAktivan() {
		return aktivan;
	}
	
	
	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	
	
	public String getIme() {
		return ime;
	}
	
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	
	public String getPrezime() {
		return prezime;
	}
	
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	
	public Prijava getPrijava() {
		return prijava;
	}
	
	
	public void setPrijava(Prijava prijava) {
		this.prijava = prijava;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Korisnik( boolean aktivan, String ime, String prezime, boolean dodijeljenaLozinka,
			Prijava prijava, boolean enabled, Date lastPasswordResetDate, List<Authority> authorities,String email, String password) {
		super();
//		this.id = id;
//		this.tip = tip;
		this.aktivan = aktivan;
		this.ime = ime;
		this.prezime = prezime;
		this.dodijeljenaLozinka = dodijeljenaLozinka;
		this.prijava = prijava;
		this.enabled = enabled;
		this.lastPasswordResetDate = lastPasswordResetDate;
		this.authorities = authorities;
		this.email = email;
		this.password = password;
	}
	
	// SPRING SECURITY
		// ===========================================================================================
		public void setAuthorities(List<Authority> authorities) {
			this.authorities = authorities;
		}
		
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return authorities;
		}

		@Override
		public String getUsername() {
			return email;
		}

		public Date getLastPasswordResetDate() {
			return lastPasswordResetDate;
		}

		public void setLastPasswordResetDate(Date lastPasswordResetDate) {
			this.lastPasswordResetDate = lastPasswordResetDate;
		}

		@JsonIgnore
		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@JsonIgnore
		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@JsonIgnore
		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return enabled;
		}
		// ===========================================================================================
   

}