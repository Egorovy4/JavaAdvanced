package javaAdvancedLesson05.service.impl;

import java.util.List;

import javaAdvancedLesson05.dao.ProductDao;
import javaAdvancedLesson05.dao.impl.ProductDaoImpl;
import javaAdvancedLesson05.domain.Product;
import javaAdvancedLesson05.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	
	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
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
