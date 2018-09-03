package model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable, IModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal idProduct;
	private String descriptionProduct;
	private BigDecimal prixProduct;
	private String quantiteProduct;
	private Categorie categorieProduct;

	public BigDecimal getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(BigDecimal id) {
		this.idProduct = id;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String description) {
		this.descriptionProduct = description;
	}

	public BigDecimal getPrixProduct() {
		return prixProduct;
	}

	public void setPrixProduct(BigDecimal prix) {
		this.prixProduct = prix;
	}

	public String getQuantiteProduct() {
		return quantiteProduct;
	}

	public void setQuantiteProduct(String quantite) {
		this.quantiteProduct = quantite;
	}

	public Categorie getCategorieProduct() {
		return categorieProduct;
	}

	public void setCategorieProduct(Categorie categorie) {
		this.categorieProduct = categorie;
	}	

	public Product() {
	}

	public Product(BigDecimal id, String description, BigDecimal prix, String quantite, Categorie categorie) {
		this.idProduct = id;
		this.descriptionProduct = description;
		this.prixProduct = prix;
		this.quantiteProduct = quantite;
		this.categorieProduct = categorie;
	}

	@Override
	public String getInsert() {
		return "INSERT INTO product VALUES("+idProduct+", '"+descriptionProduct+"', "+prixProduct+","+quantiteProduct+","+categorieProduct+")";
	}

	@Override
	public String getUpdate() {
		return "UPDATE product SET DESCRIPTION_PRODUCT='"+descriptionProduct+"', PRIX_PRODUCT="+prixProduct+", QUANTITE_PRODUCT="+quantiteProduct+", CATEGORIE_PRODUCT="+categorieProduct+" WHERE ID_PRODUCT="+idProduct;
	}

	@Override
	public String getDelete() {
		return "DELETE FROM product WHERE ID_PRODUCT="+idProduct;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", descriptionProduct=" + descriptionProduct + ", prixProduct="
				+ prixProduct + ", quantiteProduct=" + quantiteProduct + ", categorieProduct=" + categorieProduct.toString() + "]";
	}



}
