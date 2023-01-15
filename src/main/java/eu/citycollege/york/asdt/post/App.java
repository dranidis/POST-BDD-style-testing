package eu.citycollege.york.asdt.post;

public class App {
    private Sale currentSale;
    private ProductCatalog productCatalog;

    public App() {
        productCatalog = new ProductCatalog();
    }

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }

    public void addProduct(String string, int price) {
        productCatalog.addProductSpecification(string, price);
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
