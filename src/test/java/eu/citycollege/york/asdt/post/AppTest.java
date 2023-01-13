package eu.citycollege.york.asdt.post;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AppTest {
    @Test
    public void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }

    @Test
    public void enterItemTest() {
        App sut = new App();

        // GIVEN that there is a product with the code 999 and a price of 10
        // add a product with a code and and price
        sut.addProduct("999", 10);

        // WHEN a new sale is created and an item is entered with the code 999 and a quantity of 2
        sut.makeNewSale();
        sut.enterItem("999", 2);

        // THEN the total of the sale is 20
        assertEquals(20, sut.getSaleTotal());


    }
}
