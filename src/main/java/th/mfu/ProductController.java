package th.mfu;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private HashMap<String, Product> productDB = new HashMap<String, Product>();

    @GetMapping("/products")
    public Collection<Product> getAllProduct() {
        return productDB.values();
    }

    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        if(productDB.containsKey(product.getProductName())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Product name is already exists");
        }
        productDB.put(product.getProductName(), product);
        return ResponseEntity.ok("Product created");
    }
}
