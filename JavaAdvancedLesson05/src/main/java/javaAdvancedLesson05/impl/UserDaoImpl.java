package javaAdvancedLesson05.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaAdvancedLesson05.dao.UserDao;
import javaAdvancedLesson05.domain.User;
import javaAdvancedLesson05.utils.ConnectionUtils;

public class UserDaoImpl implements UserDao {

	private Connection connection;
	private PreparedStatement preparedStatement;

	public UserDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	private static String CREATE = "insert into user(`first_name`, `last_name`, `email`, `age`, `role`) values (?,?,?,?,?)";
	private static String READ_BY_ID = "select * from user where id = ?";
	private static String UPDATE_BY_ID = "update user set first_name = ?, last_name = ?, email = ?, age = ?, role = ? where id = ?";
	private static String DELETE_BY_ID = "delete from user where id = ?";
	private static String READ_ALL = "select * from user";

	@Override
	public User cteate(User user) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setInt(4, user.getAge());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			user.setId(resultSet.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User read(Integer id) {
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			Integer userId = resultSet.getInt("id");
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			String email = resultSet.getString("email");
			Integer age = resultSet.getInt("age");
			String role = resultSet.getString("role");

			user = new User(userId, firstName, lastName, email, age, role);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User update(User user) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setInt(4, user.getAge());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setInt(6, user.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> readAll() {
		List<User> userList = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				userList.add(new User(resultSet.getInt("id"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getString("email"), resultSet.getInt("age"),
						resultSet.getString("role")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
}
