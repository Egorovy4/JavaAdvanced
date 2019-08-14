package javaAdvancedLesson05.service.impl;

import java.util.List;

import javaAdvancedLesson05.dao.BucketDao;
import javaAdvancedLesson05.dao.impl.BucketDaoImpl;
import javaAdvancedLesson05.domain.Bucket;
import javaAdvancedLesson05.service.BucketService;

public class BucketServiceImpl implements BucketService {
	private BucketDao bucketDao;

	public BucketServiceImpl() {
		bucketDao = new BucketDaoImpl();
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
