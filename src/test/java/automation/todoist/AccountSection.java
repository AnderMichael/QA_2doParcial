package automation.todoist;

import org.openqa.selenium.By;
import practice2.control.Button;
import practice2.control.TextBox;

public class AccountSection {
    public Button changePass = new Button(By.xpath("//a[@href=\"/app/settings/account/password\"]"));

    public TextBox name =  new TextBox(By.xpath("//span[text()=\"Name\"]/../../..//input"));
    public Button buttonClose = new Button(By.xpath("//button[@class=\"dOAUdcnSj9gBY1w5ax6aQxa5xcA8ASxf\"]"));
    public Button buttonUpdate = new Button(By.xpath("//button[span[text()='Update']]"));

}
