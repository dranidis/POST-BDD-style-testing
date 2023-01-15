package eu.citycollege.york.asdt.post;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {

    Map<String, ProductSpecification> productSpecifications;

    public ProductCatalog() {
        productSpecifications = new HashMap<>();
    }

    public ProductSpecification getProductSpecification(String productId) {
        return productSpecifications.get(productId);
    }

    public void addProductSpecification(String productId, int price) {
        productSpecifications.put(productId, new ProductSpecification(productId, price));
    }

}

