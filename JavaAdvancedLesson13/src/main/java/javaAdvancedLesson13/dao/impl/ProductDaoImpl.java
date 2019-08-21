package javaAdvancedLesson13.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import javaAdvancedLesson13.dao.ProductDao;
import javaAdvancedLesson13.domain.Product;
import javaAdvancedLesson13.shared.FactoryManager;

public class ProductDaoImpl implements ProductDao {

//	private static Logger LOG = Logger.getLogger(ProductDaoImpl.class);

	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Product create(Product product) {
		try {
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public Product read(Integer id) {
		Product product = null;
		try {
			product = em.find(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public Product update(Product product) {

		try {
			// TODO: to be implemented
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public void delete(Integer id) {
		try {
			// TODO: to be implemented
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> readAll() {
		Query query = null;
		try {
			query = em.createQuery("SELECT e FROM Product e");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

}
