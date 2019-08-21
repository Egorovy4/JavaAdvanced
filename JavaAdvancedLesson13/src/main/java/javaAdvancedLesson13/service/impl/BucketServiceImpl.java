package javaAdvancedLesson13.service.impl;

import java.util.List;

import javaAdvancedLesson13.dao.BucketDao;
import javaAdvancedLesson13.dao.impl.BucketDaoImpl;
import javaAdvancedLesson13.domain.Bucket;
import javaAdvancedLesson13.service.BucketService;

public class BucketServiceImpl implements BucketService {
	private static BucketService bucketServiceImpl;
	private BucketDao bucketDao;

	private BucketServiceImpl() {
		bucketDao = new BucketDaoImpl();
	}

	public static BucketService getBucketService() {
		if (bucketServiceImpl == null) {
			bucketServiceImpl = new BucketServiceImpl();
		}

		return bucketServiceImpl;
	}

	@Override
	public Bucket create(Bucket bucket) {
		return bucketDao.create(bucket);
	}

	@Override
	public Bucket read(Integer id) {
		return bucketDao.read(id);
	}

	@Override
	public Bucket update(Bucket bucket) {
		return bucketDao.update(bucket);
	}

	@Override
	public void delete(Integer id) {
		bucketDao.delete(id);
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}
}
