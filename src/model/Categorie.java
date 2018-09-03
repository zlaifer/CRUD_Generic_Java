package model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Categorie implements Serializable, IModel {
	private BigDecimal idCategorie;
	private String descriptionCategorie;
	private BigDecimal etatCategorie;

	public BigDecimal getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(BigDecimal id) {
		this.idCategorie = id;
	}

	public String getDescriptionCategorie() {
		return descriptionCategorie;
	}

	public void setDescriptionCategorie(String description) {
		this.descriptionCategorie = description;
	}

	public BigDecimal getEtatCategorie() {
		return etatCategorie;
	}

	public void setEtatCategorie(BigDecimal etat) {
		this.etatCategorie = etat;
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorie(BigDecimal id, String description, BigDecimal etat) {
		super();
		this.idCategorie = id;
		this.descriptionCategorie = description;
		this.etatCategorie = etat;
	}

	@Override
	public String getInsert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", descriptionCategorie=" + descriptionCategorie
				+ ", etatCategorie=" + etatCategorie + "]";
	}
	
	

}
