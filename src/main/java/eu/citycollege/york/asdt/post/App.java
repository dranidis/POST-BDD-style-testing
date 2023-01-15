package eu.citycollege.york.asdt.post;

public class App {
    private ProductCatalog productCatalog;
    private Register register;

    public App() {
        productCatalog = new ProductCatalog();
        register = new Register(productCatalog);
    }

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
    }

    public void addProduct(String string, int price) {
        productCatalog.addProductSpecification(string, price);
    }

    public Register getRegister() {
        return register;
    }

}
