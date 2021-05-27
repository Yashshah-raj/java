package navkar.jewels.com.navkar.resources.rest;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import navkar.jewels.com.navkar.DTO.ProductDTO;
import navkar.jewels.com.navkar.service.ProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService; 
	
	@PostMapping(consumes = {org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> uploadingProduct(@RequestParam(value = "file") MultipartFile file,@RequestBody ProductDTO productRequest)
	{
		String responseMessage="";
		if(file!=null)
		{
			productRequest.setFile(file);
		}
		if(productRequest!=null)
		{
			responseMessage=productService.uploadProduct(productRequest);
		}
		return new ResponseEntity<String>(responseMessage,HttpStatus.CREATED);
	}
}
