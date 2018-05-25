package testsClasses;

import dataProviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

public class CartTests {


    private Cart cart;
    private RealItem realItem;
    private VirtualItem virtualItem;


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        realItem = new RealItem();
        virtualItem = new VirtualItem();
    }


    @Test(dataProvider = "totalPrices", dataProviderClass = DataProviders.class, groups = {"smoke", "positive", "allFunctions"})
    public void getTotalPricePositiveTest(double priceRealItem, double priceVirtualItem, double expectTotalPrice) {
        cart = new Cart("igor-cart");
        realItem.setPrice(priceRealItem);
        virtualItem.setPrice(priceVirtualItem);


        cart.addRealItem(realItem);
        cart.addVirtualItem(virtualItem);

        Assert.assertEquals(cart.getTotalPrice(), expectTotalPrice);
    }
}
