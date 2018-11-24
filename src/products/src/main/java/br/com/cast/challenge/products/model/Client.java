package br.com.cast.challenge.products.model;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Entity
@Table(name = "client")
@DynamicUpdate
@JsonIgnoreProperties({ "id" })
@SequenceGenerator(initialValue = 1, name = "clientGen", sequenceName = "clientGen", allocationSize = 1)
@Data public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2509666391404726965L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientGen")
	private Integer id;
	
	@Version
    private Integer version;
	
	@NotNull
	@Size(max = 254)
	@Column(name = "name", nullable = false, length = 254)
	private String name;
	
	@NotNull
	@Size(max = 254)
	@Column(name = "mail", unique = true, nullable = false, length = 254)
	private String mail;
	
	@NotNull
	@Size(max = 15)
	@Column(name = "cpf", unique = true, nullable = false, length = 15)
	private String cpf;
	
	
	@NotNull
	@OneToOne(cascade = {javax.persistence.CascadeType.PERSIST,CascadeType.REFRESH}, mappedBy="client")
	private Address address;
	
}
