package org.bqid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="groupes")   // si le nom de la classe est # du nom de la table dans la BD
public class Groupe implements Serializable{

}
