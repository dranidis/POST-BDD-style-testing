package eu.citycollege.york.asdt.post;

public class Register {

    private ProductCatalog productCatalog;
    private Sale currentSale;

    public Register(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public void makeNewSale() {
        currentSale = new Sale();
    }

    public void enterItem(String productId, int quantity) throws ProductSpecificationNotFound {
        ProductSpecification productSpecification = productCatalog.getProductSpecification(productId);

        if (productSpecification != null) {
            currentSale.makeSaleLineItem(productSpecification, quantity);
        } else {
            throw new ProductSpecificationNotFound(productId);
        }
    }

    public int getSaleTotal() {
        return currentSale.getTotal();
    }
}
