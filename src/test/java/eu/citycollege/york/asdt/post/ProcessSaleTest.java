package eu.citycollege.york.asdt.post;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProcessSaleTest {
    private App sut;
    private Register register;

    @Before
    public void setUpProcessSale() {
        sut = new App();
        register = sut.getRegister();
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
    public void processSaleWithOneItem() {

        givenProductWithCodeAndPrice("999", 10);

        whenNewSale();
        whenItemEnteredWithCodeAndQuantity("999", 2);

        thenTotalIs(20);
    }

    @Test
    public void processSaleWithTwoItems() {

        givenProductWithCodeAndPrice("999", 10);
        givenProductWithCodeAndPrice("888", 20);

        whenNewSale();
        whenItemEnteredWithCodeAndQuantity("999", 1);
        whenItemEnteredWithCodeAndQuantity("888", 1);

        thenTotalIs(30);
    }

    @Test
    public void processSaleWithNoItems() {

        whenNewSale();

        thenTotalIs(0);
    }

    // Helper methods for BDD style

    private void thenTotalIs(int expected) {
        assertEquals(expected, register.getSaleTotal());
    }

    private void whenItemEnteredWithCodeAndQuantity(String code, int qty) {
        register.enterItem(code, qty);
    }

    private void whenNewSale() {
        register.makeNewSale();
    }

    private void givenProductWithCodeAndPrice(String code, int price) {
        sut.addProduct(code, price);
    }

}
