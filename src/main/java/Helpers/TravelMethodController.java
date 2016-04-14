package Helpers;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.logging.*;

import Models.*;

public class TravelMethodController {
	private DBController dbController;
	private String tableName;

	public TravelMethodController() {
		dbController = new DBController();
		tableName = "travel_product_method";
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

	public ComboBoxModel getAllNames() {
		ResultSet resultSet;

		try {
			DefaultComboBoxModel list = new DefaultComboBoxModel();

			resultSet = DBController.statement.executeQuery("SELECT `name` FROM `INF-G`." + tableName);

			while (resultSet.next()) {
				list.addElement(resultSet.getObject(1).toString());
			}

			return list;

		} catch (SQLException ex) {
			Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public void insert(TravelMethod travelMethod) {
		try {
			String statement = "INSERT INTO `INF-G`." + tableName + " (name) VALUES (?)";
			PreparedStatement preparedStatement = DBController.connection.prepareStatement(statement);

			preparedStatement.setString	(1, travelMethod.getName());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException ex) {
			Logger.getLogger(TravelMethodController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void update(TravelMethod travelMethod) {
		try {
			String statement = "UPDATE `INF-G`." + tableName + " SET `name` = ? WHERE `id` = ?";
			PreparedStatement preparedStatement = DBController.connection.prepareStatement(statement);

			preparedStatement.setString(1, travelMethod.getName());
			preparedStatement.setInt(2, travelMethod.getId());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException ex) {
			Logger.getLogger(TravelMethodController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void delete(TravelMethod travelMethod) {
		try {
			String statement = "DELETE FROM `INF-G`." + tableName + " WHERE `id` = ?";
			PreparedStatement preparedStatement = DBController.connection.prepareStatement(statement);

			preparedStatement.setInt(1, travelMethod.getId());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException ex) {
			Logger.getLogger(TravelMethodController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
