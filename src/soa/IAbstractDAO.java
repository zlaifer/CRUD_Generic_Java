package soa;

import java.sql.SQLException;
import java.util.ArrayList;

import model.IModel;

public interface IAbstractDAO<T extends IModel> {

	boolean excuteUpdate(T object, int typeOpeartion) throws SQLException;
	ArrayList<T> findObject(String sql) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException;

}
