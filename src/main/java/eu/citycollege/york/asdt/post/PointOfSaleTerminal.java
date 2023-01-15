package eu.citycollege.york.asdt.post;

public class PointOfSaleTerminal {

    private ProductCatalog productCatalog;
    private Register register;

    public PointOfSaleTerminal() {
        productCatalog = new ProductCatalog();
        register = new Register(productCatalog);
    }

    public void addProduct(String string, int price) {
        productCatalog.addProductSpecification(string, price);
    }

    public Register getRegister() {
        return register;
    }

}
