package util;

public interface BDConstants {
	String TABLE_NAME_CATEGORY = "CATEGORIE";
	String COLUMN_NAME_ID_CATEGORY = "ID_CATEGORIE";
	String QUERY_FIND_CATEGORY = "SELECT * FROM " + TABLE_NAME_CATEGORY + " WHERE " + COLUMN_NAME_ID_CATEGORY + " = ";
	String COLUMN_NAME_CATEGORY_PRODUCT = "categorie_product";
}
