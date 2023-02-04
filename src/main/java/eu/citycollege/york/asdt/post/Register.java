package eu.citycollege.york.asdt.post;

import java.util.List;

public class Register {

    private ProductCatalog productCatalog;
    private Sale currentSale;
    private List<Sale> completedSales;

    public Register(ProductCatalog productCatalog, List<Sale> completedSales) {
        this.productCatalog = productCatalog;
        this.completedSales = completedSales;
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

    public void endSale() {
        completedSales.add(currentSale);
    }
}
