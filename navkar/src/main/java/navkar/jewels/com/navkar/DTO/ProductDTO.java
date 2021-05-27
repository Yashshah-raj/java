package navkar.jewels.com.navkar.DTO;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private String productName;
	private MultipartFile file;
	private Boolean trendingProduct;
	private Boolean topProducts;
	private Boolean productPrice;
	private Boolean productDescription;
	
	


}
