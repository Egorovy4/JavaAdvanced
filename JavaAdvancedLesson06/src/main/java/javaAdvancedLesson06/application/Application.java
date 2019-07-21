package javaAdvancedLesson06.application;

import java.sql.Date;

import javaAdvancedLesson06.domain.Bucket;
import javaAdvancedLesson06.domain.Product;
import javaAdvancedLesson06.domain.User;
import javaAdvancedLesson06.service.BucketService;
import javaAdvancedLesson06.service.ProductService;
import javaAdvancedLesson06.service.UserService;
import javaAdvancedLesson06.service.impl.BucketServiceImpl;
import javaAdvancedLesson06.service.impl.ProductServiceImpl;
import javaAdvancedLesson06.service.impl.UserServiceImpl;

public class Application {
	public static void main(String[] args) {
		UserService userService = UserServiceImpl.getUserService();
		ProductService productService = ProductServiceImpl.getProductService();
		BucketService bucketService = BucketServiceImpl.getBucketService();

		userService.create(new User("Igor", "Iwanyshyn", "iwanyshyn@gmail.com", 22, "user", "12345"));
		System.out.println(userService.read(1));
		userService.update(new User(1, "Igor", "Iwanyshyn", "iwanyshyn@gmail.com", 22, "admin", "12345"));
		System.out.println(userService.read(1));
//		userService.delete(1);
		System.out.println(userService.readAll());

		productService.create(new Product("Java thinking", "Information about \"Java thinking\"", 350.00));
		System.out.println(productService.read(1));
		productService.update(new Product(1, "Java thinking", "Information about \"Java thinking\"", 550.00));
		System.out.println(productService.read(1));
//		productService.delete(1);
		System.out.println(productService.readAll());

		bucketService.create(new Bucket(1, 1, Date.valueOf("2019-10-19")));
		System.out.println(bucketService.read(1));
//		bucketService.delete(1);
		System.out.println(bucketService.readAll());
	}
}
