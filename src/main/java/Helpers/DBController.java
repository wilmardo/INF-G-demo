package Helpers;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;
import java.util.logging.*;

public class DBController {
	public static Connection connection;
	public static Statement statement;

	private static String dbserver;
	private static String database;
	private static String username;
	private static String password;

	public DBController() {
		connection = getConnection();

		try {
			statement = connection.createStatement();
		}
		catch (SQLException ex) {
			Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private static void init() {
		String driver = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driver);
		}
		catch (ClassNotFoundException ex) {
			Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
		}

		dbserver = "wilmardenouden.nl";
		database = "INF-G";
		username = "inf-g";
		password = "pass12345";
	}

	public Connection getConnection() {
		if (connection==null) {
			init();
			connection=createConnection();
		}
		return connection;
	}

	private Connection createConnection() {
		String connectionString = "jdbc:mysql://" + dbserver + "/" + database + "?" +
				"user=" + username + "&password=" + password;

		try {
			return DriverManager.getConnection(connectionString);
		}
		catch (SQLException ex) {
			Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {

		ResultSetMetaData metaData = resultSet.getMetaData();

		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();

		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		while (resultSet.next()) {
			Vector<Object> vector = new Vector<Object>();

			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(resultSet.getObject(columnIndex));
			}

			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);
	}
}
