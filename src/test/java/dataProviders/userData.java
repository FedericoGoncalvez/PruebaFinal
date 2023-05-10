package dataProviders;

import org.testng.annotations.DataProvider;

public class userData {
    @DataProvider(name = "userData")
    public static Object[][] getUserData() {
        return new Object[][]{
                {"xyz@test.com", "123456", "Hello, holamundo lasttest!"},
                {"yzx@test.com", "123123", "Hello, yzx test!"}
        };
    }
}
