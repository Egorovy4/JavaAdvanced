package javaAdvancedLesson05.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaAdvancedLesson05.dao.BucketDao;
import javaAdvancedLesson05.domain.Bucket;
import javaAdvancedLesson05.utils.ConnectionUtils;

public class BucketDaoImpl implements BucketDao {

	private Connection connection;
	private PreparedStatement preparedStatement;

	public BucketDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	private static String CREATE = "insert into bucket(`user_id`, `product_id`, `purchase_date`) values (?,?,?)";
	private static String READ_BY_ID = "select * from bucket where id = ?";
	private static String DELETE_BY_ID = "delete from bucket where id = ?";
	private static String READ_ALL = "select * from bucket";
	
	@Override
	public Bucket cteate(Bucket bucket) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, bucket.getUserId());
			preparedStatement.setInt(2, bucket.getProductId());
			preparedStatement.setDate(3, bucket.getPurchaseDate());
			preparedStatement.executeUpdate();
			
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			bucket.setId(resultSet.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bucket;
	}

	@Override
	public Bucket read(Integer id) {
		Bucket bucket = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			Integer bucketId = resultSet.getInt("id");
			Integer userId = resultSet.getInt("user_id");
			Integer productId = resultSet.getInt("product_id");
			Date purchaseDate = resultSet.getDate("purchase_date");

			bucket = new Bucket(bucketId, userId, productId, purchaseDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bucket;
	}

	@Override
	public Bucket update(Bucket t) {
		throw new IllegalStateException("You can't update bucket !");
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
	public List<Bucket> readAll() {
		List<Bucket> bucketList = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				bucketList.add(new Bucket(resultSet.getInt("id"), resultSet.getInt("user_id"),
						resultSet.getInt("product_id"), resultSet.getDate("purchase_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bucketList;
	}
}
