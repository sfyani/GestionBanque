package org.bqid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length=1)    // par defaut name=TYPE et type=varchar
public class Operation implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numOperation;
	private Date dateOperation;
	private double montant;
// Il se peut que Many operation etre associes a une seule compte
	@ManyToOne  // est ce que por chq objet de cette classe (Opertaion) on associe un et un seul compte --> OUI ===> alors il faut une classe etrangere
	@JoinColumn(name="CODE_COMPTE")
	private Compte compte;
	@ManyToOne
	@JoinColumn(name="Code_EMPLOYE")
	private Employe employe;
	public Operation() {
		super();
	}
	public Operation(Long numOperation, Date dateOperation, double montant, Compte compte, Employe employe) {
		super();
		this.numOperation = numOperation;
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
		this.employe = employe;
	}
	public Long getNumOperation() {
		return numOperation;
	}
	public void setNumOperation(Long numOperation) {
		this.numOperation = numOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	

}
