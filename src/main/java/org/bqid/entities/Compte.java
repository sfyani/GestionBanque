package org.bqid.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
// Parce que C est une classe dérivé   ( SINGLE_TABLE --> une seul table pour comptes courants et epargnes )
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
// on va utiliser une seul table pour les #tes comptes alors il ne faut un colonne pour differencier , on a chosit unn colonne qui s appele Type_Compte(par defaut C Type ) de type String de taille ( par defaut 255 caractere et C trooop ) 2 caractere ( CC ou CE )  
@DiscriminatorColumn(name="TYPE_COMPTE",discriminatorType=DiscriminatorType.STRING,length=2)
public class Compte {
	@Id
	//  Pas de GenratedValue car C un String
	private String codeCompte;
	private Date dateCreation;
	private double solde;
	@ManyToOne   //Many Comptes peut appartenir a One clien 
	@JoinColumn(name="CODE_CLIENT")  // C cle etranger
	private Client client;  // C le mappedBy determiner dans la classe Compte
	@ManyToOne
	@JoinColumn(name="CODE_EMPLLOYE")
	private Employe employe;
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;
	public Compte() {
		super();
	}
	public Compte(String codeCompte, Date dateCreation, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}
	public String getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Collection<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	
	
	

} 
