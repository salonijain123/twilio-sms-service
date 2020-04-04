package com.devglan.springboothibernatelogin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.metamodel.model.domain.IdentifiableDomainType;  
@Entity     
@Table(name="usersforHibernate")



public class User  {

	
	private int id;
	private String name;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String email;
	private String Password;
	
	
	
	@Id		
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
	@org.hibernate.annotations.GenericGenerator(
        name = "book_seq", 
        strategy = "com.devglan.springboothibernatelogin.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
            @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "B_"),
            @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	 
	private String token;
	

	


	public User(  byte[] file) {
		super();
		
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return Password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	 @Column
	    @Lob
	    private byte[] file;





	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	

    
	
	
}
