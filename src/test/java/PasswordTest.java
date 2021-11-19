import static com.codeborne.selenide.Selenide.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.AuthPage;


public class PasswordTest {

    @Before
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
        Assert.assertEquals(authPage.getPassword(),valPassword);
        Assert.assertEquals(authPage.getPasswordType(),"text");
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
        Assert.assertEquals(passwordType,"password");
    }
    /*
        Тест на скрытие пароля при первичном наборе
    */
    @Test
    public void invisiblePasswordTestWithOutCLICK()  {
        String valPassword = "adfsjdkfj";
        AuthPage authPage = new AuthPage();
        authPage.setPassword(valPassword);
        String passwordType = authPage.getPasswordType();
        Assert.assertEquals(passwordType,"password");
    }
}
