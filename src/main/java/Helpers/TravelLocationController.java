package Helpers;

import javax.swing.table.TableModel;
import java.sql.*;
import java.util.logging.*;

import Models.*;

public class TravelLocationController {
	private DBController dbController;
	private String tableName;

	public TravelLocationController() {
		dbController = new DBController();
		tableName = "travel_product_location";
	}

	public TableModel getAll() {
		ResultSet resultSet;

		try {
			resultSet = DBController.statement.executeQuery("SELECT * FROM `INF-G`." + tableName);
			return DBController.buildTableModel(resultSet);

		} catch (SQLException ex) {
			Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public void insert(TravelLocation travelLocation) {
		try {
			String statement = "INSERT INTO `INF-G`." + tableName + " (name) VALUES (?)";
			PreparedStatement preparedStatement = DBController.connection.prepareStatement(statement);

			preparedStatement.setString	(1, travelLocation.getName());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException ex) {
			Logger.getLogger(TravelLocationController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void update(TravelLocation travelLocation) {
		try {
			String statement = "UPDATE `INF-G`." + tableName + " SET `name` = ? WHERE `id` = ?";
			PreparedStatement preparedStatement = DBController.connection.prepareStatement(statement);

			preparedStatement.setString(1, travelLocation.getName());
			preparedStatement.setInt(2, travelLocation.getId());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException ex) {
			Logger.getLogger(TravelLocationController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void delete(TravelLocation travelLocation) {
		try {
			String statement = "DELETE FROM `INF-G`." + tableName + " WHERE `id` = ?";
			PreparedStatement preparedStatement = DBController.connection.prepareStatement(statement);

			preparedStatement.setInt(1, travelLocation.getId());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException ex) {
			Logger.getLogger(TravelLocationController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
