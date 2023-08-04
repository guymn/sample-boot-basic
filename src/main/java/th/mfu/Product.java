// package th.mfu;

// import javax.persistence.*;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;

// import com.fasterxml.jackson.annotation.JsonProperty;

// @Entity
// public class Product {
//     @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//     private Long PId;

//     @JsonProperty("productName")
//     private String productName;

//     @JsonProperty("description")
//     private String description;

//     @JsonProperty("price")
//     private Long price;

//     public Product(Long PId, String productName, String description, Long price) {
//         this.PId = PId;
//         this.productName = productName;
//         this.description = description;
//         this.price = price;
//     }

//     public String getProductName() {
//         return productName;
//     }

//     public void setProductName(String productName) {
//         this.productName = productName;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public void setDescription(String description) {
//         this.description = description;
//     }

//     public Long getPrice() {
//         return price;
//     }

//     public void setPrice(Long price) {
//         this.price = price;
//     }

//     public Long getPId() {
//         return PId;
//     }

//     public void setPId(Long pId) {
//         PId = pId;
//     }

// }
