package dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "realItems")
    public static Object[][] realItemsDataProvider() {
        return new Object[][]{
                {"Audi", new Double(32026.9), new Double(1560.0), "Class: class shop.RealItem; Name: Audi; Price: 32026.9; Weight: 1560.0"},
                {"BMW", new Double(22103.9), new Double(1400.0), "Class: class shop.RealItem; Name: BMW; Price: 22103.9; Weight: 1400.0"},
                {"Nissan", new Double(25000), new Double(1600), "Class: class shop.RealItem; Name: Nissan; Price: 25000.0; Weight: 1600.0"}

        };
    }


    @DataProvider(name = "virtualItems")
    public static Object[][] virtualItemsDataProvider() {
        return new Object[][]{
                {"Microsoft office", new Double(30), new Double(8500.0), "Class: class shop.VirtualItem; Name: Microsoft office; Price: 30.0; Size on disk: 8500.0"},
                {"Windows", new Double(11), new Double(20000), "Class: class shop.VirtualItem; Name: Windows; Price: 11.0; Size on disk: 20000.0"},
                {"Dr.Web", new Double(300), new Double(20000), "Class: class shop.VirtualItem; Name: Dr.Web; Price: 300.0; Size on disk: 20000.0"},
        };
    }


    @DataProvider(name = "totalPrices")
    public static Object[][] cartGetTotalPriceDataProvider() {
        return new Object[][]{
                {new Double(1000), new Double(2000), new Double(3600)},
                {new Double(22103.9), new Double(30), new Double(26560.68)},
                {new Double(32026.9), new Double(11), new Double(38445.479999999996)}
        };
    }


    @DataProvider(name = "cartNamesPositive")
    public static Object[][] writeToFileCartNamesPositiveDataProvider() {
        return new Object[][]{
                {"alexey-cart"},
                {"111BBvv6"},
                {"!@#$%^&"},
                {"text"}
        };
    }


    @DataProvider(name = "cartNamesNegative")
    public static Object[][] writeToFileCartNamesNegativeDataProvider() {
        return new Object[][]{
                {"con"}, {">aaa"}, {"***aaaa"}, {"<aaaa"}
        };
    }


    @DataProvider(name = "fileNamesPositive")
    public static Object[][] readFromFileNameFilePositive() {
        return new Object[][]{
                {"src\\test\\resourses\\json\\eugen-cart.json", new Double(26560.68)},
                {"src\\test\\resourses\\json\\andrew-cart.json", new Double(38445.479999999996)}
        };
    }


    @DataProvider(name = "expectedExceptions")
    public static Object[][] readFromFileExceptions() {
        return new Object[][]{
                {"src\\test\\resourses\\json\\igor-cart.json"},
                {"src\\test\\resourses\\json\\igor-cart"},
                {"src\\test\\resources\\text.csv"},
                {"src\\main\\resourses\\igor-cart"},
                {"src\\main\\resourses\\andrew-cart"}
        };
    }

}


