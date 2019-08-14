package javaAdvancedLesson10.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import javaAdvancedLesson10.domain.Bucket;
import javaAdvancedLesson10.domain.Product;
import javaAdvancedLesson10.dto.BucketDto;
import javaAdvancedLesson10.service.BucketService;
import javaAdvancedLesson10.service.ProductService;
import javaAdvancedLesson10.service.impl.BucketServiceImpl;
import javaAdvancedLesson10.service.impl.ProductServiceImpl;

@WebServlet("/buckets")
public class BucketsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BucketService bucketService = BucketServiceImpl.getBucketService();
	private ProductService productService = ProductServiceImpl.getProductService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		
		List<Bucket> buckets = bucketService.readAll();
		Map<Integer, Product> idToProduct = productService.readAllMap();
		List<BucketDto> listOfBucketDtos = map(userId, buckets, idToProduct);

		String json = new Gson().toJson(listOfBucketDtos);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	public List<BucketDto> map(Integer userId, List<Bucket> buckets, Map<Integer, Product> idToProduct) {
		return buckets.stream().map(bucket -> {
			BucketDto bucketDto = new BucketDto();
			bucketDto.bucketId = bucket.getId();
			bucketDto.purchaseDate = bucket.getPurchaseDate();

			Product product = idToProduct.get(bucket.getProductId());
			bucketDto.name = product.getName();
			bucketDto.description = product.getDescription();
			bucketDto.price = product.getPrice();
			if(userId == bucket.getUserId()) {
				return bucketDto;
			} else {
				return null;
			}
		}).collect(Collectors.toList());
	}
}
