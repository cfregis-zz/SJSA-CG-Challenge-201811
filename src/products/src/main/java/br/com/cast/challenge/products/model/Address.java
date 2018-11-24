package br.com.cast.challenge.products.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "address")
@DynamicUpdate
@JsonIgnoreProperties({ "id" })
@SequenceGenerator(initialValue = 1, name = "addressGen", sequenceName = "addressGen", allocationSize = 1)
@Data public class Address  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5153845897997686333L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressGen")
	private Integer id;
	
	@Version
    private Integer version;
	
	@NotNull
	@Size(max = 254)
	@Column(name = "street", nullable = false, length = 254)
	private String street;
	
	@NotNull
	@Size(max = 254)
	@Column(name = "city", nullable = false, length = 254)
	private String city;
	
	@NotNull
	@Size(max = 2)
	@Column(name = "province", nullable = false, length = 2)
	private String province;
	
	@NotNull
	@Column(name="postalCode", nullable = false)
	private String postalCode;
	
	@JoinColumn(name="client", nullable = false, referencedColumnName = "id", 
			foreignKey = @ForeignKey(name = "FK_ADDRESS_clientId"))
	@OneToOne
	private Client client;
		
}
