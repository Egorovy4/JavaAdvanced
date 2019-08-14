package javaAdvancedLesson07.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import javaAdvancedLesson07.dao.UserDao;
import javaAdvancedLesson07.domain.User;
import javaAdvancedLesson07.utils.ConnectionUtils;

public class UserDaoImpl implements UserDao {
	private static String CREATE = "insert into user(`first_name`, `last_name`, `email`, `age`, `role`, `password`) values (?,?,?,?,?,?)";
	private static String READ_BY_ID = "select * from user where id = ?";
	private static String UPDATE_BY_ID = "update user set first_name = ?, last_name = ?, email = ?, age = ?, role = ?, password = ? where id = ?";
	private static String DELETE_BY_ID = "delete from user where id = ?";
	private static String READ_ALL = "select * from user";
	private static String READ_BY_EMAIL = "select * from user where email = ?";

	private static Logger LOG = Logger.getLogger(UserDaoImpl.class);

	@Override
	public User create(User user) {
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(CREATE,
						Statement.RETURN_GENERATED_KEYS);) {
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setInt(4, user.getAge());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			user.setId(resultSet.getInt(1));

			resultSet.close();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			LOG.error(e);
		}
		return user;
	}

	@Override
	public User read(Integer id) {
		User user = null;
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_ID);) {

			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			Integer userId = resultSet.getInt("id");
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			String email = resultSet.getString("email");
			Integer age = resultSet.getInt("age");
			String role = resultSet.getString("role");
			String password = resultSet.getString("password");

			user = new User(userId, firstName, lastName, email, age, role, password);

			resultSet.close();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			LOG.error(e);
		}
		return user;
	}

	@Override
	public User update(User user) {
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);) {

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setInt(4, user.getAge());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setInt(7, user.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			LOG.error(e);
		}
		return user;
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
	public List<User> readAll() {
		List<User> userList = new ArrayList<>();
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL);) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				userList.add(new User(resultSet.getInt("id"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getInt("age"),
						resultSet.getString("role"), resultSet.getString("password")));
			}
			resultSet.close();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			LOG.error(e);
		}
		return userList;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_EMAIL);) {

			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			Integer userId = resultSet.getInt("id");
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			Integer age = resultSet.getInt("age");
			String role = resultSet.getString("role");
			String password = resultSet.getString("password");

			user = new User(userId, firstName, lastName, email, age, role, password);

			resultSet.close();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			LOG.error(e);
		}
		return user;
	}
}
