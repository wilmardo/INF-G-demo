package Helpers;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.logging.*;

import Models.*;

public class TravelProductController {
	private DBController dbController;
	private String tableName;

	public TravelProductController() {
		dbController = new DBController();
		tableName = "travel_product";
	}

	public TableModel getAll() {
		ResultSet resultSet;

		try {
			resultSet = DBController.statement.executeQuery("SELECT tp.`fk_product_id`, tp.`name`, tp.`description`, tpl.`name`, tpm.`name` FROM `INF-G`.`" + tableName + "` tp " +
					"LEFT JOIN `INF-G`.`travel_product_location` tpl ON tp.fk_travel_product_location_id = tpl.id " +
					"LEFT JOIN `INF-G`.`travel_product_method` tpm ON tp.fk_travel_product_method_id = tpm.id;");
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

	public void insert(TravelProduct travelProduct) {
		ResultSet resultSet;
		String statement;
		PreparedStatement preparedStatement;

		try {
			// Insert into product
			statement = "INSERT INTO `INF-G`.`product` (type) VALUES (?)";

			preparedStatement = DBController.connection.prepareStatement(statement);
			preparedStatement.setInt(1, 0);

			preparedStatement.executeUpdate();
			preparedStatement.close();

			// Gets last inserted ID
			resultSet = DBController.statement.executeQuery("SELECT LAST_INSERT_ID()");

			while (resultSet.next()) {
				travelProduct.setProduct_id(Integer.parseInt(resultSet.getObject(1).toString()));
			}

			// Insert into travel product with product ID
			statement = "INSERT INTO `INF-G`.`" + tableName + "` (fk_product_id, name, description, fk_travel_product_location_id, fk_travel_product_method_id) " +
					"VALUES (?, ?, ?, " +
					"(SELECT id FROM `INF-G`.`travel_product_location` WHERE name = ?), " +
					"(SELECT id FROM `INF-G`.`travel_product_method` WHERE name = ?))";
			preparedStatement = DBController.connection.prepareStatement(statement);

			preparedStatement.setInt(1, travelProduct.getProduct_id());
			preparedStatement.setString(2, travelProduct.getName());
			preparedStatement.setString(3, travelProduct.getDescription());
			preparedStatement.setString(4, travelProduct.getTravel_product_location_id());
			preparedStatement.setString(5, travelProduct.getTravel_product_method_id());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException ex) {
			Logger.getLogger(TravelProductController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void update(TravelProduct travelProduct) {
		try {
			String statement = "UPDATE `INF-G`.`" + tableName + "` SET " +
					"`name` = ?, " +
					"`description` = ?, " +
					"`fk_travel_product_location_id` = (SELECT id FROM `INF-G`.`travel_product_location` WHERE name = ?), " +
					"`fk_travel_product_method_id`  = (SELECT id FROM `INF-G`.`travel_product_method` WHERE name = ?)" +
					"WHERE `fk_product_id` = ?";
			PreparedStatement preparedStatement = DBController.connection.prepareStatement(statement);

			preparedStatement.setString(1, travelProduct.getName());
			preparedStatement.setString(2, travelProduct.getDescription());
			preparedStatement.setString(3, travelProduct.getTravel_product_location_id());
			preparedStatement.setString(4, travelProduct.getTravel_product_method_id());
			preparedStatement.setInt(5, travelProduct.getProduct_id());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException ex) {
			Logger.getLogger(TravelProductController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void delete(TravelProduct travelProduct) {
		try {
			String statement = "DELETE FROM `INF-G`." + tableName + " WHERE `fk_product_id` = ?";
			PreparedStatement preparedStatement = DBController.connection.prepareStatement(statement);

			preparedStatement.setInt(1, travelProduct.getProduct_id());

			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException ex) {
			Logger.getLogger(TravelProductController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
