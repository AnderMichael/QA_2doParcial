package exercises.exercise4;

import automation.session.Session;
import automation.todoist.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddTaskTest {
    LoginSection loginSection = new LoginSection();
    MenuSection menuSection = new MenuSection();
    TaskSection taskSection = new TaskSection();
    TaskCard taskCard = new TaskCard();

    @BeforeEach
    public void open() {
        Session.getInstance().getBrowser().get("https://todoist.com/app/");
    }

    @AfterEach
    public void close() {
        Session.getInstance().closeSession();
    }

    @Test
    public void addTask() throws InterruptedException {
        login();
        Thread.sleep(5000);
        menuSection.addTask.click();
        Thread.sleep(2000);
        taskCard.taskName.click();
        taskCard.taskName.setText("Tarea 2");
        Thread.sleep(2000);
        taskCard.button.click();
        Thread.sleep(1000);

        menuSection.inbox.click();

        Assertions.assertTrue(taskSection.taskExists("Tarea 2"), "ERROR la tarea no existe!");
    }

    public void login() {
        loginSection.emailInput.setText("andersaurio@ander.com");
        loginSection.passwordInput.setText("Standbyme1");
        loginSection.confirmationButton.click();
    }


}
