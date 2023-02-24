package ui;

import framework.ui.BaseTestUI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import framework.ui.utilsForUIOnly.listeners.MyITestListener;

import static org.testng.Assert.*;
@Listeners(MyITestListener.class)


public class LoginTestWithDataProvider extends BaseTestUI {
/*

    @DataProvider(name = "users")
    public Iterator<Object[]> allUsers() throws IOException {

        //  List<UserLoginData> allUsersLoginData = getUserLoginDataFromCode();
        List<UserLoginData> allUsersLoginData = getUserLoginDataFromFile();

        List<Object[]> list = new ArrayList<>();
        for (UserLoginData data : allUsersLoginData) {
            list.add(new Object[]{data});
        }
        return list.iterator();
    }

    private static List<UserLoginData> getUserLoginDataFromFile() throws IOException {
        List<UserLoginData> allUsersLoginData = new ArrayList<>();
        String fileName = "src/main/resources/dataFiles/UsersLoginData.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String s = reader.readLine();
        while (s != null) {
            String[] parts = s.split(",");
            UserLoginData userLoginData = new UserLoginData(parts[0], parts[1]);
            allUsersLoginData.add(userLoginData);
            s = reader.readLine();
        }
        return allUsersLoginData;
    }

    private static List<UserLoginData> getUserLoginDataFromCode() {
        UserLoginData userLoginData1 = new UserLoginData("email@test1.com", "passwordtest1");
        UserLoginData userLoginData2 = new UserLoginData("email@test2.com", "passwordtest2");

        List<UserLoginData> allUsersLoginData = new ArrayList<>();
        allUsersLoginData.add(userLoginData1);
        allUsersLoginData.add(userLoginData2);
        return allUsersLoginData;
    }


    //test with data provider from code and file
    @Test(description = "Verify that login is failed", dataProvider = "users")
    public void testLoginIsFailed2(UserLoginData userLoginData) {
        logger.info("Close popup on app start");
        logger.info("Login with invalid credentials");
        app.closePopupOnStart()
                .login(userLoginData.login, userLoginData.password);
        logger.info("Check if an error message is displayed");
        assertTrue(app.getLoginPage().isLoginFailed(), "Error Login message is not displayed");
    }


   }*/


    @Test
    public void checkTCPassAnother() {
        assertNull(null);
    }

    @Test
    public void checkTCAnother() {
        assertNull("dsd");
    }
}
