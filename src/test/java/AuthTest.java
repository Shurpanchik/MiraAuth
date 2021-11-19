import static com.codeborne.selenide.Selenide.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.AuthPage;


public class AuthTest {


    @Before
    public void setUp() {
        open("https://lmslite47vr.demo.mirapolis.ru/mira");
    }

    /*
        Тест успешной авторизации
     */

    @Test
    @Ignore
    public void happyAuthTest() {
        //TODO: Требуется доработка теста, так как не известны верные логин и пароль
        AuthPage authPage = new AuthPage();
        authPage.setLogin("Валидный логин");
        authPage.setPassword("Валидный пароль");
        authPage.submitLoginPassword();
    }


    /*
        Тест неуспешной авторизации
     */
    @Test
    public void negativeAuthTest() {
        AuthPage authPage = new AuthPage();
        authPage.setLogin("Невалидный логин");
        authPage.setPassword("Невалидный пароль");
        authPage.submitLoginPassword();
        Assert.assertTrue(authPage.getTextNegativeAuthAllert().contains("Неверные данные для авторизации"));
    }



}
