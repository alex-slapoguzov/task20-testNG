import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import shop.RealItem;

public class RealItemTests {


    private RealItem realItem;


    @BeforeClass
    public void setUp() {
        realItem = new RealItem();

    }


    @Test
    public void toStringRealItemPositiveTest() {
        String name = "BMW";
        double price = 25000;
        double weight = 1600;

        String expected = "Class: class shop.RealItem; Name: BMW; Price: 25000.0; Weight: 1600.0";

        realItem.setName(name);
        realItem.setPrice(price);
        realItem.setWeight(weight);
        Assert.assertEquals(realItem.toString(), expected);
    }
}
