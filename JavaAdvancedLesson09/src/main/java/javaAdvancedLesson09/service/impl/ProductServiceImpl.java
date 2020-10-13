package javaAdvancedLesson09.service.impl;

import java.util.List;

import javaAdvancedLesson09.dao.ProductDao;
import javaAdvancedLesson09.dao.impl.ProductDaoImpl;
import javaAdvancedLesson09.domain.Product;
import javaAdvancedLesson09.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private static ProductService productServiceImpl;
	private ProductDao productDao;

	private ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}

	public static ProductService getProductService() {
		if (productServiceImpl == null) {
			productServiceImpl = new ProductServiceImpl();
		}

		return productServiceImpl;
	}

	@Override
	public Product create(Product product) {
		return productDao.create(product);
	}

	@Override
	public Product read(Integer id) {
		return productDao.read(id);
	}

	@Override
	public Product update(Product product) {
		return productDao.update(product);
	}

	@Override
	public void delete(Integer id) {
		productDao.delete(id);
	}

	@Override
	public List<Product> readAll() {
		return productDao.readAll();
	}
}