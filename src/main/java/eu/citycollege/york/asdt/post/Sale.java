package eu.citycollege.york.asdt.post;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    List<SaleLine> saleLines;

    public Sale() {
        saleLines = new ArrayList<>();
    }

    public void makeSaleLineItem(ProductSpecification spec, int quantity) {
        SaleLine saleLine = new SaleLine(spec, quantity);
        saleLines.add(saleLine);
    }

    public int getTotal() {
        int total = 0;

        for (SaleLine saleLine : saleLines) {
            total += saleLine.getSubTotal();
        }
        return total;
    }

}

