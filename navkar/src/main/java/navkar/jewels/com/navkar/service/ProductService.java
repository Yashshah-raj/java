package navkar.jewels.com.navkar.service;

import org.springframework.stereotype.Service;

import navkar.jewels.com.navkar.DTO.ProductDTO;


public interface ProductService {
	
	public String uploadProduct(ProductDTO productRequest);
}
