package testsClasses;

import dataProviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import shop.RealItem;

public class RealItemTests {


    private RealItem realItem;


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        realItem = new RealItem();

    }


    @Test(dataProvider = "realItems", dataProviderClass = DataProviders.class, groups = {"smoke", "positive", "allFunctions"})
    public void toStringRealItemPositiveTest(String name, double price, double weight, String expectedResult) {
        realItem.setName(name);
        realItem.setPrice(price);
        realItem.setWeight(weight);

        Assert.assertEquals(realItem.toString(), expectedResult);
    }
}
