package navkar.jewels.com.navkar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import navkar.jewels.com.navkar.domain.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
