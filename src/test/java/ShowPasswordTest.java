import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AuthPage;


public class ShowPasswordTest {

    @BeforeEach
    public void setUp() {
        open("https://lmslite47vr.demo.mirapolis.ru/mira");
    }

    /*
            Тест на отображение пароля
    */
    @Test
    public void visiblePasswordTest() {
        String valPassword = "adfsjdkfj";
        AuthPage authPage = new AuthPage();
        authPage.setPassword(valPassword);
        authPage.showPassword();
        Assertions.assertEquals(authPage.getPassword(), valPassword);
        Assertions.assertEquals(authPage.getPasswordType(), "text");
    }

    /*
        Тест на скрытие пароля по двойному клику
    */
    @Test
    public void invisiblePasswordTestWithDoubleClick() {
        String valPassword = "adfsjdkfj";
        AuthPage authPage = new AuthPage();
        authPage.setPassword(valPassword);
        authPage.showPassword();
        authPage.showPassword();
        String passwordType = authPage.getPasswordType();
        Assertions.assertEquals(passwordType, "password");
    }

    /*
        Тест на скрытие пароля при первичном наборе
    */
    @Test
    public void invisiblePasswordTestWithOutCLICK() {
        String valPassword = "adfsjdkfj";
        AuthPage authPage = new AuthPage();
        authPage.setPassword(valPassword);
        String passwordType = authPage.getPasswordType();
        Assertions.assertEquals(passwordType, "password");
    }
}
