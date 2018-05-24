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


    @BeforeClass
    public void setUp() {
        cart = new Cart("igor-cart");
        realItem = new RealItem();
        virtualItem = new VirtualItem();
    }

    @Test
    public void getTotalPricePositiveTest() {


        double priceRealItem = 1000;
        double priceVirtualItem = 2000;

        double expectTotalPrice = 3600;

        realItem.setPrice(priceRealItem);
        virtualItem.setPrice(priceVirtualItem);

        cart.addRealItem(realItem);
        cart.addVirtualItem(virtualItem);

        Assert.assertEquals(cart.getTotalPrice(), expectTotalPrice);
    }


}
