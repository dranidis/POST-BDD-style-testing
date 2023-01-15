package eu.citycollege.york.asdt.post;

public class ProductSpecification {

    private int price;
    private String id;

    public ProductSpecification(String id, int price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

}

