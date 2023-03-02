package framework.datamodels;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserLoginDataProvider {

    // 1 option - return Iterator<Object[]>
    @DataProvider(name = "users")
    public static Iterator<Object[]> allUsers() throws IOException {

        //  List<UserLoginData> allUsersLoginData = getUserLoginDataFromCode();
        List<UserLoginData> allUsersLoginData = getUserLoginDataFromFile();

        List<Object[]> list = new ArrayList<>();
        for (UserLoginData data : allUsersLoginData) {
            list.add(new Object[]{data});
        }
        return list.iterator();
    }

/*
    // 2nd option -  return Object[][]
    @DataProvider(name = "users")
    public static Object[][] allUsers() throws IOException {
        List<UserLoginData> allUsersLoginData = getUserLoginDataFromFile();

        return new Object[][] {new Object[] {allUsersLoginData.get(0)},
                new Object[] {allUsersLoginData.get(1)}
        };
    }
*/

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
}
