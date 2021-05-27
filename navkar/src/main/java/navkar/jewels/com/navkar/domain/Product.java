package navkar.jewels.com.navkar.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="product",indexes = {@Index(columnList = "product_name")})
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="image_type")
	private String imageType;
	
	@Column(name="image_size",length = 1000)
	private byte[] imageSize;
	
	@Column(name="trending_product")
	private Boolean trendingProduct;
	
	@Column(name="top_products")
	private Boolean topProducts;
	
	@Column(name="product_price")
	private Boolean productPrice;
	
	@Column(name="product_description")
	private Boolean productDescription;
	
	
}
