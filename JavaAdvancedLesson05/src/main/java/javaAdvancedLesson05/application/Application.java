package javaAdvancedLesson05.application;

import java.sql.Date;

import javaAdvancedLesson05.domain.Bucket;
import javaAdvancedLesson05.domain.Product;
import javaAdvancedLesson05.domain.User;
import javaAdvancedLesson05.service.BucketService;
import javaAdvancedLesson05.service.ProductService;
import javaAdvancedLesson05.service.UserService;
import javaAdvancedLesson05.service.impl.BucketServiceImpl;
import javaAdvancedLesson05.service.impl.ProductServiceImpl;
import javaAdvancedLesson05.service.impl.UserServiceImpl;

public class Application {
	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		ProductService productService = new ProductServiceImpl();
		BucketService bucketService = new BucketServiceImpl();
		
		userService.create(new User("Igor", "Iwanyshyn", "iwanyshyn@gmail.com", 22, "user"));
		System.out.println(userService.read(1));
		userService.update(new User(1, "Igor", "Iwanyshyn", "iwanyshyn@gmail.com", 22, "admin"));
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
		bucketService.delete(1);
		System.out.println(bucketService.readAll());
	}
}
