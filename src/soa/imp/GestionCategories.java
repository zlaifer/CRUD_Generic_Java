package soa.imp;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Categorie;

public class GestionCategories extends AbstractDAO<Categorie> {

	public GestionCategories() {
		super(Categorie.class);
	}
}
