package automation.todoist;

import org.openqa.selenium.By;
import practice2.control.Button;

public class MenuSection {
    public Button addTask = new Button(By.xpath("//button[span[text()='Add task']]"));
    public Button deplegableProfile = new Button(By.xpath("//div[@class='ZmV8mtF']/button"));

    public Button inbox = new Button(By.xpath("//div[text()='Inbox']"));
}
