package br.com.cast.challenge.products.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Entity
@Table(name = "invoice")
@DynamicUpdate
@JsonIgnoreProperties({ "id" })
@SequenceGenerator(initialValue = 1, name = "invoiceGen", sequenceName = "invoiceGen", allocationSize = 1)
@Data public class Invoice  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5357978961052431425L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoiceGen")
	private Integer id;
	
	@Version
    private Integer version;
	
	@Size(max = 254)
	@Column(name = "serial", nullable = false, length = 254)
	private String serial;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Client.class)
	@JoinColumn(name = "client", nullable = false, referencedColumnName = "id", 
		foreignKey = @ForeignKey(name = "FK_INVOICE_clientId"))
	private Client client;
	
	
	@ManyToMany(fetch = FetchType.LAZY, targetEntity = Product.class)
	@JoinTable(name = "invoice_item", 
		joinColumns = { @JoinColumn(name = "invoiceId", nullable = false,
			foreignKey = @ForeignKey(name = "FK_INVOICE_ITEM_invoiceId")) },
		inverseJoinColumns = { @JoinColumn(name = "itemId", nullable = false, 
			foreignKey = @ForeignKey(name = "FK_INVOICE_ITEM_itemId")) })
	private Set<Product> items =  new HashSet<>();
		
}
