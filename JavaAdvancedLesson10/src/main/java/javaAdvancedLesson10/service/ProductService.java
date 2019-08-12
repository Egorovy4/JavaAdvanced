package javaAdvancedLesson10.service;

import java.util.Map;

import javaAdvancedLesson10.domain.Product;
import javaAdvancedLesson10.shared.AbstractCRUD;

public interface ProductService extends AbstractCRUD<Product> {
	public Map<Integer, Product> readAllMap();
}
