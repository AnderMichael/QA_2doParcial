package exercises.exercise1;

import apiTest.configuration.Configuration;
import apiTest.factoryRequest.FactoryRequest;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class CUserProjectDUserTest extends TestBase {
    private static String email;
    private static String fullName;
    private static String password;

    private static Random random = new Random();

    @BeforeAll
    public static void setup() {
        email = String.format("ander@andercito%s.com", random.nextInt());
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
        int idUser = response.then().extract().path("Id");

        Configuration.user = email;
        Configuration.password = password;

        JSONObject newProject = new JSONObject();
        newProject.put("Content", "Frambuesa y Chocolate");
        newProject.put("Icon", "4");

        createProject(newProject);

        deleteUser(idUser, delete, newUser);

        JSONObject newProject2 = new JSONObject();
        newProject2.put("Content", "Frambuesa y Chocolate 2");
        newProject2.put("Icon", "3");

        createProject2(newProject2);
    }

    private void createProject(JSONObject newProject) {
        requestInfo.setUrl(Configuration.host + "/api/projects.json");
        requestInfo.setBody(newProject.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(newProject.get("Content")));

    }

    private void createProject2(JSONObject newProject) {
        requestInfo.setUrl(Configuration.host + "/api/projects.json");
        requestInfo.setBody(newProject.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", not(equalTo(newProject.get("Content"))));
    }

    private void createUser(JSONObject newUser) {
        requestInfo.setUrl(Configuration.host + "/api/user.json");
        requestInfo.setBody(newUser.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(newUser.get("Email"))).
                body("FullName", equalTo(newUser.get("FullName")));
    }

    private void deleteUser(int idUser, String delete, JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/user/" + idUser + ".json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(body.get("Email"))).
                body("FullName", equalTo(body.get("FullName")));
    }
}
