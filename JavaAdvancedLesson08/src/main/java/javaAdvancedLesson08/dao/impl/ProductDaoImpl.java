package javaAdvancedLesson08.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import javaAdvancedLesson08.dao.ProductDao;
import javaAdvancedLesson08.domain.Product;
import javaAdvancedLesson08.utils.ConnectionUtils;

public class ProductDaoImpl implements ProductDao {
	private static String CREATE = "insert into product(`name`, `description`, `price`) values (?,?,?)";
	private static String READ_BY_ID = "select * from product where id = ?";
	private static String UPDATE_BY_ID = "update product set name = ?, description = ?, price = ? where id = ?";
	private static String DELETE_BY_ID = "delete from product where id = ?";
	private static String READ_ALL = "select * from product";

	private static Logger LOG = Logger.getLogger(ProductDaoImpl.class);

	@Override
	public Product create(Product product) {
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(CREATE,
						Statement.RETURN_GENERATED_KEYS);) {

			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			product.setId(resultSet.getInt(1));

			resultSet.close();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			LOG.error(e);
		}
		return product;
	}

	@Override
	public Product read(Integer id) {
		Product product = null;
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_ID);) {

			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			Integer productId = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String description = resultSet.getString("description");
			Double price = resultSet.getDouble("price");

			product = new Product(productId, name, description, price);

			resultSet.close();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			LOG.error(e);
		}
		return product;
	}

	@Override
	public Product update(Product product) {
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);) {

			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setInt(4, product.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			LOG.error(e);
		}
		return product;
	}

	@Override
	public void delete(Integer id) {
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);) {

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			LOG.error(e);
		}
	}

	@Override
	public List<Product> readAll() {
		List<Product> productList = new ArrayList<>();
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL);) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				productList.add(new Product(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getString("description"), resultSet.getDouble("price")));
			}

			resultSet.close();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			LOG.error(e);
		}
		return productList;
	}
}
