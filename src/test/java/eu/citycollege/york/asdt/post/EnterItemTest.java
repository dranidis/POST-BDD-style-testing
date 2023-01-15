package eu.citycollege.york.asdt.post;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EnterItemTest {
    private App sut;

    @Before
    public void createApp() {
        sut = new App();
    }

    /**
     * Scenario: Calculate total for a sale with multiple items
     * <p>
     * Given there is a product with the code 999 and a price of 10
     * <p>
     * When a new sale is created and an item is entered with the code 999 and a quantity of 2
     * <p>
     * Then the total of the sale is 20
     */
    @Test
    public void enterItemWithOneItem() {

        givenProductWithCodeAndPrice("999", 10);

        whenNewSale();
        whenItemEnteredWithCodeAndQuantity("999", 2);

        thenTotalIs(20);
    }

    private void thenTotalIs(int expected) {
        assertEquals(expected, sut.getSaleTotal());
    }

    private void whenItemEnteredWithCodeAndQuantity(String code, int qty) {
        sut.enterItem(code, qty);
    }

    private void whenNewSale() {
        sut.makeNewSale();
    }

    private void givenProductWithCodeAndPrice(String code, int price) {
        sut.addProduct(code, price);
    }

}
