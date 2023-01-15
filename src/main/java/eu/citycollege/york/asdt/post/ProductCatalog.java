package eu.citycollege.york.asdt.post;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {

    Map<String, ProductSpecification> productSpecifications;

    public ProductCatalog() {
        productSpecifications = new HashMap<>();
    }

    public ProductSpecification getSpecification(String id) {
        return productSpecifications.get(id);
    }

    public void addProductSpecification(String string, int price) {
        productSpecifications.put(string, new ProductSpecification(string, price));
    }

}

