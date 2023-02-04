package eu.citycollege.york.asdt.post;

import java.util.ArrayList;
import java.util.List;

public class PointOfSaleTerminal {

    private ProductCatalog productCatalog;
    private Register register;
    private List<Sale> completedSales;

    public PointOfSaleTerminal() {
        productCatalog = new ProductCatalog();
        completedSales = new ArrayList<>();
        register = new Register(productCatalog, completedSales);
    }

    public void addProduct(String string, int price) {
        productCatalog.addProductSpecification(string, price);
    }

    public Register getRegister() {
        return register;
    }

    public int getNumberOfCompletedSales() {
        return completedSales.size();
    }

}
