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

    public void enterItem(String id, int quantity) {
        ProductSpecification spec = productCatalog.getSpecification(id);

        if (spec != null) {
            currentSale.makeSaleLineItem(spec, quantity);
        }
    }

    public int getSaleTotal() {
        return currentSale.getTotal();
    }
}
