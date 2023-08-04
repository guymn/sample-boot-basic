// package th.mfu;

// import java.util.Collection;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class ProductController {
//     @Autowired
//     private ProductRepository productRepository;

//     @GetMapping("/products")
//     public Collection<Product> getAllProduct() {
//         return productRepository.findAll();
//     }

//     @GetMapping("/products/productName/{productName}")
//     public ResponseEntity getProductByProductName(@PathVariable String productName) {
//         Optional<Product> products = productRepository.findByProductName(productName);

//         if (!products.isPresent()) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
//         }
//         Product pro = products.get();
//         return ResponseEntity.ok(pro);
//     }

//     @PostMapping("/products")
//     public ResponseEntity<String> createProduct(@RequestBody Product product) {
//         productRepository.save(product);
//         return ResponseEntity.ok("Product created");
//     }

//     @PatchMapping("/products/{PId}")
//     public ResponseEntity<String> updateProduct(@PathVariable Long PId, @RequestBody Product product) {
//         // check if id not exists
//         if (!productRepository.existsById(PId)) {
//             // return error message
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
//         }
//         productRepository.save(product);
//         return ResponseEntity.ok("Product updated");
//     }

//     @DeleteMapping("/products/{PId}")
//     public ResponseEntity<String> deleteProduct(@PathVariable Long PId) {
//         // check if id not exists
//         if (!productRepository.existsById(PId)) {
//             // return error message
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
//         }
//         productRepository.deleteById(PId);
//         return ResponseEntity.ok("Product deleted");
//     }

// }
