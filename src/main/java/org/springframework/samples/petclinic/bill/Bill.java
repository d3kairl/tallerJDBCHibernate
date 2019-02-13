package org.springframework.samples.petclinic.bill;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.visit.Visit;


@Entity
@Table(name = "facturas")
public class Bill extends NamedEntity {
	@NotEmpty
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Digits(fraction = 0, integer = 10)
	private int num_id;
	
	@Temporal(TemporalType.DATE)
	@NotEmpty
	private Date fecha;
	
	@NotEmpty
	@Digits(fraction = 2, integer = 6)
	@DecimalMin("0.0")
	private double cuantia;
	
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "bill", cascade = CascadeType.ALL)
    private Visit visit;

	public int getNum_id() {
		return this.num_id;
	}

	public void setNum_id(int num_id) {
		this.num_id = num_id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getCuantia() {
		return this.cuantia;
	}

	public void setCuantia(double d) {
		this.cuantia = d;
	}

	public Owner getOwner() {
		return this.owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
}