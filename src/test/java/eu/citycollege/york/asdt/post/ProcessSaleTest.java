package eu.citycollege.york.asdt.post;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A test class for the Process Sale use case.
 */
public class ProcessSaleTest {
    private PointOfSaleTerminal sut;
    private Register register;
    private Exception caughtException;

    @Before
    public void setUpProcessSale() {
        sut = new PointOfSaleTerminal();
        register = sut.getRegister();
    }

    /**
     * Scenario: Calculate total for a sale with one items
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

    @Test
    public void processSaleWithNotFoundItem() {

        whenNewSale();
        whenItemEnteredWithCodeAndQuantity("111", 1);

        thenExceptionIsThrownForNotFoundProduct("111");
    }

    // Helper methods for BDD style

    private void thenExceptionIsThrownForNotFoundProduct(String productId) {
        assertEquals(ProductSpecificationNotFound.class, caughtException.getClass());
        assertEquals(productId, ((ProductSpecificationNotFound) caughtException).getProductId());
    }

    private void thenTotalIs(int expected) {
        assertEquals(expected, register.getSaleTotal());
    }

    private void whenItemEnteredWithCodeAndQuantity(String productId, int qty) {
        try {
            register.enterItem(productId, qty);
        } catch (Exception e) {
            caughtException = e;
        }
    }

    private void whenNewSale() {
        register.makeNewSale();
    }

    private void givenProductWithCodeAndPrice(String productId, int price) {
        sut.addProduct(productId, price);
    }

}
