package exercises.exercise1;

import automation.todoly.MainPage;
import automation.todoly.SignInSection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class CreateUserProjectTest {
    MainPage mainPage = new MainPage();
    SignInSection signInSection= new SignInSection();
    static String newAccount;
    static String newPassword;
    static String newProject;
    static Random random;
    @BeforeAll
    public static void setup(){
        newAccount = String.format("andersito%d@gmail.com", random.nextInt());
        newPassword = "HugoNoTeComasEsaHamburguesa";
    }

    @Test
    public void createUserProject(){
        mainPage.signInButton.click();
        creatingUser();
    }

    public void creatingUser(){

    }
}
