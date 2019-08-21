package javaAdvancedLesson13.service;

import java.util.Map;

import javaAdvancedLesson13.domain.Product;
import javaAdvancedLesson13.shared.AbstractCRUD;

public interface ProductService extends AbstractCRUD<Product> {
	public Map<Integer, Product> readAllMap();
}
