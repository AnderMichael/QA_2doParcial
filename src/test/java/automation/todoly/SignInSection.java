package automation.todoly;

import automation.control.Button;
import automation.control.TextBox;
import org.openqa.selenium.By;

public class SignInSection {

    TextBox fullNameInput = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName"));
    TextBox emailInput = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail"));
    TextBox passwordInput = new TextBox(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword"));
    Button check = new Button(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms"));
}
