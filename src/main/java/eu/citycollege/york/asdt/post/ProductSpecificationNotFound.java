package eu.citycollege.york.asdt.post;

public class ProductSpecificationNotFound extends Exception {

    private final String productId;

    public ProductSpecificationNotFound(String productId) {
        super("ProductSpecification with productId " + productId + " not found");
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

}
