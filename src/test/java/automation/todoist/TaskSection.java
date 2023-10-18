package automation.todoist;

import org.openqa.selenium.By;
import practice2.control.Task;

public class TaskSection {
    public Task task;

    public boolean taskExists(String name){
        task = new Task(By.xpath(String.format("//div[text()='%s']", name)));
        return task.isControlDisplayed();
    }
}
