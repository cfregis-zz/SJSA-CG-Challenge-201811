package br.com.cast.challenge.products.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Entity
@Table(name = "product")
@DynamicUpdate
@JsonIgnoreProperties({ "id" })
@SequenceGenerator(initialValue = 1, name = "productGen", sequenceName = "productGen", allocationSize = 1)
@Data public class Product  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3202200498010520757L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productGen")
	private Integer id;
	
	@Version
    private Integer version;
	
	@NotNull
	@Size(max = 254)
	@Column(name = "description", nullable = false, length = 254)
	private String description;
	
	@NotNull
	@Column(name="price", nullable = false)
	private BigDecimal price;
	
	@NotNull
	@Column(name="code", nullable = false)
	private String code;
	

		
}
