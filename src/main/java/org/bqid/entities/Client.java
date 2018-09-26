package org.bqid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeClient;
	private String nomClient;
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)		// 1...n
	// LAZY : ca veut dire que les comptes d'un client ne seront charger que si on les demande.
	//EAGER:(#LAZY) charger le client et tous les comptes de ce clients 
	private  Collection<Compte> comptes;
	
	
	
	public Client() {
		super();
	}
	public Client(String nomClient) {
		super();
		this.nomClient = nomClient;
	}
	public Long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	

}
