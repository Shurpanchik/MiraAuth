package pages;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public String getRoleEmployee() {
       return  $(By.className("avatar-full-current-role")).getText().trim();
    }
}
