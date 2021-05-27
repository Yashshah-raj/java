package navkar.jewels.com.navkar.service.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import navkar.jewels.com.navkar.DTO.ProductDTO;
import navkar.jewels.com.navkar.domain.Product;
import navkar.jewels.com.navkar.repository.ProductRepository;
import navkar.jewels.com.navkar.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	@Override
	public String uploadProduct(ProductDTO productRequest)
	{
		Product product=new Product();
		if(productRequest!=null)
		{
			MultipartFile multipartFile=null;
			String imageName="";
			String imageType="";
			byte[] imageInBytes=new byte[1024];
			if(productRequest.getFile()!=null)
			{
				multipartFile=productRequest.getFile();
				imageName=multipartFile.getOriginalFilename();
				imageType=multipartFile.getContentType();
				try {
				imageInBytes=compressBytes(multipartFile.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				product.setImageName(imageName);
				product.setImageSize(imageInBytes);
				product.setImageType(imageType);
			}
			if(productRequest.getProductDescription()!=null)
			{
				product.setProductDescription(productRequest.getProductDescription());
			}
			if(productRequest.getProductPrice()!=null)
			{
				product.setProductPrice(productRequest.getProductPrice());
			}
			if(productRequest.getTopProducts()!=null)
			{
				product.setTopProducts(productRequest.getTopProducts());
			}
			if(productRequest.getTrendingProduct()!=null)
			{
				product.setTrendingProduct(productRequest.getTrendingProduct());
			}
			return product.getProductName()+" has been succesfully saved with id = "+productRepo.save(product).getProductId();
		}
		return "Nothing is saved (Some error has occured while saving)";
	}
	
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}
}

