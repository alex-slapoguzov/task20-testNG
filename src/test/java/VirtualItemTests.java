import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import shop.VirtualItem;

public class VirtualItemTests {


    private VirtualItem virtualItem;


    @BeforeClass
    public void setUp() {

        virtualItem = new VirtualItem();
    }


    @Test
    public void toStringVirtualItemPositiveTest() {
        String name = "Windows";
        double price = 300;
        double sizeOnDisk = 20000;

        String expected = "Class: class shop.VirtualItem; Name: Windows; Price: 300.0; Size on disk: 20000.0";

        virtualItem.setName(name);
        virtualItem.setPrice(price);
        virtualItem.setSizeOnDisk(sizeOnDisk);

        Assert.assertEquals(virtualItem.toString(), expected);
    }
}
