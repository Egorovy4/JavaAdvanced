package javaAdvancedLesson06.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import javaAdvancedLesson06.dao.BucketDao;
import javaAdvancedLesson06.domain.Bucket;
import javaAdvancedLesson06.utils.ConnectionUtils;

public class BucketDaoImpl implements BucketDao {
	private static String CREATE = "insert into bucket(`user_id`, `product_id`, `purchase_date`) values (?,?,?)";
	private static String READ_BY_ID = "select * from bucket where id = ?";
	private static String DELETE_BY_ID = "delete from bucket where id = ?";
	private static String READ_ALL = "select * from bucket";

	private static Logger LOG = Logger.getLogger(BucketDaoImpl.class);

	@Override
	public Bucket create(Bucket bucket) {
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(CREATE,
						Statement.RETURN_GENERATED_KEYS);) {

			preparedStatement.setInt(1, bucket.getUserId());
			preparedStatement.setInt(2, bucket.getProductId());
			preparedStatement.setDate(3, bucket.getPurchaseDate());
			preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			bucket.setId(resultSet.getInt(1));

			resultSet.close();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			LOG.error(e);
		}
		return bucket;
	}

	@Override
	public Bucket read(Integer id) {
		Bucket bucket = null;
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_ID);) {

			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			Integer bucketId = resultSet.getInt("id");
			Integer userId = resultSet.getInt("user_id");
			Integer productId = resultSet.getInt("product_id");
			Date purchaseDate = resultSet.getDate("purchase_date");

			bucket = new Bucket(bucketId, userId, productId, purchaseDate);

			resultSet.close();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			LOG.error(e);
		}
		return bucket;
	}

	@Override
	public Bucket update(Bucket t) {
		throw new IllegalStateException("You can't update bucket !");
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
	public List<Bucket> readAll() {
		List<Bucket> bucketList = new ArrayList<>();
		try (Connection connection = ConnectionUtils.openConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL);) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				bucketList.add(new Bucket(resultSet.getInt("id"), resultSet.getInt("user_id"),
						resultSet.getInt("product_id"), resultSet.getDate("purchase_date")));
			}

			resultSet.close();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			LOG.error(e);
		}
		return bucketList;
	}
}
