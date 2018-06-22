package testsClasses;

import dataProviders.DataProviderForTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import shop.VirtualItem;

public class VirtualItemTest {

    private VirtualItem virtualItem;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        virtualItem = new VirtualItem();
    }

    @Test(dataProvider = "virtualItems", dataProviderClass = DataProviderForTest.class, groups = {"smoke", "positive", "allFunctions"})
    public void toStringVirtualItemPositiveTest(String name, double price, double sizeOnDisk, String expectedResult) {
        virtualItem.setName(name);
        virtualItem.setPrice(price);
        virtualItem.setSizeOnDisk(sizeOnDisk);

        Assert.assertEquals(virtualItem.toString(), expectedResult, "Method toString in class VirtualItem doesn't work correctly!");
    }
}
