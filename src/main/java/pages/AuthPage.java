package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class AuthPage {

    public void setLogin(String val) {
        $(By.name("user")).val(val);
    }

    public void setPassword(String val) {
        $(By.name("password")).val(val);
    }
    public String getPassword() {
        return $(By.name("password")).getValue();
    }

    public String getPasswordType() {
        return $(By.name("password")).getAttribute("type");
    }

    public  void submitLoginPassword (){
        $(By.id("button_submit_login_form")).click();
    }

    public  void showPassword (){
        $(By.id("show_password")).click();
    }

    public String getTextNegativeAuthAlert(){
        return switchTo().alert().getText();
    }

    public void clickAlertOK(){
        switchTo().alert().accept();
    }
}
