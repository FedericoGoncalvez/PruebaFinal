package dataProviders;

import org.testng.annotations.DataProvider;

public class userData {
    @DataProvider(name = "userData")
    public static Object[][] getUserData() {
        return new Object[][]{
                {"xyz@test.com", "123456", "MY DASHBOARD"},
                {"xyz@test.com", "123456", "MY DASHBOAR"}
        };
    }
}
