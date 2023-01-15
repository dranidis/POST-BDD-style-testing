package eu.citycollege.york.asdt.post;

public class SaleLine {

    private ProductSpecification productSpecification;
    private int quantity;

    public SaleLine(ProductSpecification spec, int quantity) {
        this.productSpecification = spec;
        this.quantity = quantity;
    }

    public int getSubTotal() {
        return productSpecification.getPrice() * quantity;
    }

}
