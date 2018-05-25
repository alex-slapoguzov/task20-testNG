package testsClasses;

import dataProviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import parser.JsonParser;
import parser.Parser;
import shop.Cart;

import java.io.File;

public class JsonParserTests {


    private Parser jsonParser;
    private Cart cart;
    private File file;


    @BeforeClass(alwaysRun = true)
    public void setUpBeforeClass() {
        jsonParser = new JsonParser();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanResources() {
        file = new File("src/main/resources/");
        for (File item : file.listFiles()) {
            if (!(item.getName().equals("andrew-cart.json") | item.getName().equals("eugen-cart.json"))) {
                item.delete();
            }
        }

    }


    @Test(groups = {"smoke", "positive", "allFunctions"}, dataProvider = "cartNamesPositive", dataProviderClass = DataProviders.class)
    public void writeToFileIsFilePresentPositive(String cartName) {
        String fileName = cartName + ".json";
        cart = new Cart(cartName);

        jsonParser.writeToFile(cart);

        Assert.assertTrue(isFilePresent(fileName));
    }

    @Test(dataProvider = "cartNamesNegative", dataProviderClass = DataProviders.class, enabled = false, groups = {"negative", "allFunctions"})
    public void writeToFileIsFilePresentNegative(String cartName) {
        String fileName = cartName + ".json";
        cart = new Cart(cartName);

        jsonParser.writeToFile(cart);

        Assert.assertFalse(isFilePresent(fileName));
    }

    @Test(dataProvider = "fileNamesPositive", dataProviderClass = DataProviders.class, groups = {"smoke", "positive", "allFunctions"})
    public void readFromFilePositive(String fileName, double expectedTotalPrice, String expectedCartName) {
        file = new File(fileName);

        cart = jsonParser.readFromFile(file);

        Assert.assertEquals(cart.getTotalPrice(), expectedTotalPrice);
        Assert.assertEquals(cart.getCartName(), expectedCartName);
    }

    @Test(dataProvider = "expectedExceptions", dataProviderClass = DataProviders.class, expectedExceptions = parser.NoSuchFileException.class,
            groups = {"exceptions", "allFunctions"})
    public void exceptionTest(String fileName) {
        file = new File(fileName);
        jsonParser.readFromFile(file);
    }


    public boolean isFilePresent(String fileName) {
        file = new File("src/main/resources/" + fileName);
        if (file.exists()) {
            return true;
        } else return false;
    }
}
