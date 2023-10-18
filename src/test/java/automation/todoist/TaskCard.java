package automation.todoist;

import org.openqa.selenium.By;
import practice2.control.Button;
import practice2.control.TextBox;

public class TaskCard {
    public TextBox taskName = new TextBox(By.xpath("//p[@data-placeholder=\"Task name\"]"));
    public Button button = new Button(By.xpath("//button[@data-testid=\"task-editor-submit-button\"]"));
}
