package soa.imp;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Connect;
import model.IModel;
import soa.IAbstractDAO;
import util.BDConstants;
import util.OperationConstants;
import util.StringUtil;

public abstract class AbstractDAO<T extends IModel> implements IAbstractDAO<T> {

	private Connect connect;
	private Class<T> genericClass;
	private StringUtil stringUtil;

	public AbstractDAO(Class<T> paramClass) {
		connect = new Connect();
		genericClass = paramClass;
		stringUtil = StringUtil.getInstance();
	}

	/*
	 * El tipo de dato T se refiere a la genericidad, la cual espera un objeto de
	 * una clase que implementa la interfaz IModel con el fin de realizar las operaciones
	 * de INSERT, DELETE, UPDATE.
	 */
	@Override
	public boolean excuteUpdate(T object, int typeOperation) throws SQLException {
		String sql = "";
		if(typeOperation == OperationConstants.TYPE_OPERATION_ADD) {
			sql = object.getInsert();
		} else if(typeOperation == OperationConstants.TYPE_OPERATION_UPDATE) {
			sql = object.getUpdate();
		} else if(typeOperation == OperationConstants.TYPE_OPERATION_DELETE) {
			sql = object.getDelete();
		}
		return connect.executeUpdate(sql);
	}

	/*
	 * 1. Se crea una lista que contiene objetos de tipo T (EN EL COLMENTARIO
	 *    del método anterior explico que es T) (62)
	 * 2. Se obtiene una instancia de tipoResultSet (63)
	 * 3. Se recorre el resultSet siempre y cuando se presenten resultados (64)
	 * 4. Se crea un objeto de tipo T y se inicializa con la clase generica (65)
	 * 5. Se declara un recorrido con el fin de poder obtener propiedades 
	 *    de la metaData (66).
	 * 6. Se obtiene el nombre de la columna por medio de la metaData (67)
	 * 7. Se convierte el nombre de columna en la base de datos a nombre de
	 *    atributo (68)
	 * 8. A partir del nombre del atributo se obtiene por medio de reflexión 
	 *    el atributo que pertenece la clase (69)
	 * 9. Se da acceso a los atributos privados (70)
	 * 10. Se asigna el dato que viene dentro del resulSet al object de tipo T (71)
	 * 11. Se agrega el objeto a la lista (73)
	 */
	public ArrayList<T> findObject(String sql) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		ArrayList<T> list = new ArrayList<>();
		ResultSet resultSet = connect.getResultSet(sql);
		while (resultSet.next()) {
			T object = genericClass.newInstance();
			for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
				String columnName = resultSet.getMetaData().getColumnName(i+1).toLowerCase();
				String fieldName = stringUtil.converterColumnNameToFieldName(columnName);
				Field field = object.getClass().getDeclaredField(fieldName);
				field.setAccessible(true);
				Object insertObject = null;
				if(columnName.equals(BDConstants.COLUMN_NAME_CATEGORY_PRODUCT)) {
					String queryFindCategory = BDConstants.QUERY_FIND_CATEGORY + resultSet.getObject(i+1);
					GestionCategories gestionCategories = new GestionCategories();
					insertObject = gestionCategories.findObject(queryFindCategory).get(0);
				}else {
					insertObject = resultSet.getObject(i+1);
				}
				field.set(object, insertObject);
			}
			list.add(object);
		}
		return list;
	}

}
