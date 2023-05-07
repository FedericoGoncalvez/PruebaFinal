package dataProviders;

import org.testng.annotations.DataProvider;

public class userData {
    @DataProvider(name = "userData")
    public static Object[][] getUserData() {
        return new Object[][]{
                {"xyz@test.com", "123456", "MY DASHBOARD", "Hello, holamundo lasttest!"},
                {"asd@test.com", "123123", "Title 2", "Name 2"},
        };
    }
}
