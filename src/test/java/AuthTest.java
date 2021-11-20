import static com.codeborne.selenide.Selenide.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.AuthPage;
import pages.HomePage;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AuthTest {


    @BeforeEach
    public void setUp() {
        open("https://lmslite47vr.demo.mirapolis.ru/mira");
    }

    /*
        Тест успешной авторизации
     */

    @Test
    @Disabled
    void happyAuthTest() {
        //TODO: Требуется доработка теста, так как не стоит выкладывать в явном виде логины и пароли
        AuthPage authPage = new AuthPage();
        authPage.setLogin("Валидный логин");
        authPage.setPassword("Валидный пароль");
        authPage.submitLoginPassword();
        // Убеждаемся, что открылась страница с пользователем
        // Решила делать это, через поле Роль
        HomePage homePage = new HomePage();
        Assertions.assertEquals(homePage.getRoleEmployee(), "Сотрудник");
    }


    /*
        Тест неуспешной авторизации
     */
    @ParameterizedTest
    @MethodSource("data")
    public void negativeAuthTest(String login, String password) {
        AuthPage authPage = new AuthPage();
        authPage.setLogin(login);
        authPage.setPassword(password);
        authPage.submitLoginPassword();
        Assertions.assertTrue(authPage.getTextNegativeAuthAlert().contains("Неверные данные для авторизации"));
        authPage.clickAlertOK();
    }


    /*
*  Метод получения коллекции данных для  теста авторизации из файла data.json
 */
    public static List<Arguments> data() throws IOException, ParseException {
        List<Arguments> res = new ArrayList<>();

        JSONParser parser = new JSONParser();

        Reader reader = new FileReader("src/test/resources/parameters/data.json");
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        JSONArray testData = (JSONArray) jsonObject.get("data");
        Iterator testDataIterator = testData.iterator();
        while (testDataIterator.hasNext()) {
            JSONObject currentData = (JSONObject) testDataIterator.next();
            String login = (String) currentData.get("login");
            String password = (String) currentData.get("password");
            res.add(Arguments.of(login, password));
        }

        return res;
    }

}
