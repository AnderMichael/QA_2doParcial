package exercises.exercise3;

import automation.session.Session;
import automation.todoly.MainPage;
import automation.todoly.MenuSection;
import automation.todoly.ProjectsSection;
import automation.todoly.SignInSection;
import org.junit.jupiter.api.*;

import java.util.Random;

public class CreateUserProjectTest {
    MainPage mainPage = new MainPage();
    SignInSection signInSection = new SignInSection();
    MenuSection menuSection = new MenuSection();
    ProjectsSection projectsSection = new ProjectsSection();


    static String newAccount;
    static String newPassword;
    static String newUsername;

    static String newProject;
    static Random random = new Random();

    @BeforeAll
    public static void setup() {
        newAccount = String.format("andersito%d@gmail.com", random.nextInt());
        newPassword = "HugoNoTeComasEsaHamburguesa";
        newUsername = "Andersaurio wrey";
        newProject = "Proyecto final";
    }

    @BeforeEach
    public void open() {
        Session.getInstance().getBrowser().get("https://todo.ly/");
    }

    @AfterEach
    public void close() {
        Session.getInstance().closeSession();
    }

    @Test
    public void createUserProject() throws InterruptedException {
        mainPage.signInButton.click();
        creatingUser();
        createProject();
    }

    public void creatingUser() {
        signInSection.fullNameInput.setText(newUsername);
        signInSection.emailInput.setText(newAccount);
        signInSection.passwordInput.setText(newPassword);
        signInSection.check.click();
        signInSection.signin.click();
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR al iniciar sesion");
    }

    public void createProject() throws InterruptedException {
        projectsSection.addProjectButton.click();
        projectsSection.textBoxProjectName.setText(newProject);
        projectsSection.addButton.click();

        Thread.sleep(1000);

        int lastProjectIndex = projectsSection.getProjects(newProject).size();
        Assertions.assertEquals(newProject, projectsSection.getProjects(newProject).get(lastProjectIndex - 1).getName(), "ERROR proyecto creado no encontrado!");
    }
}

