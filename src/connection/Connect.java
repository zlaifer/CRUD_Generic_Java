package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

	private Connection cnx;

	public Connect() {
		conectar();
	}

	private void conectar() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cnx = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "oracle123");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Error en la conexión de la base de datos");
		}
	}

	public boolean executeUpdate(String sql) throws SQLException {
		Statement statement = cnx.createStatement();
		return statement.executeUpdate(sql) == 1;
	}

	public ResultSet getResultSet(String sql) throws SQLException {
		Statement statement = cnx.createStatement();
		return statement.executeQuery(sql);
	}
}
