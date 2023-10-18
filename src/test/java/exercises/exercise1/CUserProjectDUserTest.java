package exercises.exercise1;

import apiTest.configuration.Configuration;
import apiTest.factoryRequest.FactoryRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;

public class CUserProjectDUserTest extends TestBase {
    private static String email;
    private static String fullName;
    private static String password;

    private static Random random;

    @BeforeAll
    public static void setup() {
        email = String.format("ander@andercito%s.com",random.nextInt());
        fullName = "Ander Michael";
        password = "pinias";
    }


    @Test
    public void createUserandItem() {
        JSONObject newUser = new JSONObject();
        newUser.put("Email", email);
        newUser.put("FullName", fullName);
        newUser.put("Password", password);

        createUser(newUser);

        Configuration.user = email;
        Configuration.password = password;

        JSONObject newProject = new JSONObject();
        newProject.put("Content", "Frambuesa y Chocolate");
        newProject.put("Icon", "4");

        createProject(newProject);
    }

    private void createProject(JSONObject newProject) {
        requestInfo.setUrl(Configuration.host + "/api/projects.json");
        requestInfo.setBody(newProject.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(newProject.get("Content")));

    }

    private void createUser(JSONObject newUser) {
        requestInfo.setUrl(Configuration.host + "/api/user.json");
        requestInfo.setBody(newUser.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(newUser.get("Email"))).
                body("FullName", equalTo(newUser.get("FullName")));
    }
}
