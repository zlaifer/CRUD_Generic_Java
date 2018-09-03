package soa.imp;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;
import util.OperationConstants;

public class Prueba {
	public static void main(String[] args) {
		GestionProduct gestionProduct = new GestionProduct();
		try {
			String sql = "SELECT * FROM product";
			ArrayList<Product> result = gestionProduct.findObject(sql);
			for (Product product2 : result) {
				System.out.println(product2.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
