package aceitacao;

import aceitacao.dto.UserDTO;
import aceitacao.dto.UserResponseDTO;
import aceitacao.service.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Test
public class UserAceitacaoTest {

    UserService userService = new UserService();

    public String lerJson(String caminhojson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhojson)));
    }

    @Test
    public void postUser() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/user.json");

        UserResponseDTO resultService = userService.adicionarUser(jsonBody);
        Assert.assertEquals(resultService.getCode(), "200");
        Assert.assertEquals(resultService.getType(), "unknown");
        Assert.assertEquals(resultService.getMessage(), "2022000001");
        userService.deleteUser("guzs");
    }

    @Test
    public void createList() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/userList.json");

        UserResponseDTO resultService = userService.createWithList(jsonBody);
        Assert.assertEquals(resultService.getCode(), "200");
        Assert.assertEquals(resultService.getType(), "unknown");
        Assert.assertEquals(resultService.getMessage(), "ok");
    }

    @Test
    public void createWithArray() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/userList.json");

        UserResponseDTO resultService = userService.createWithList(jsonBody);
        Assert.assertEquals(resultService.getCode(), "200");
        Assert.assertEquals(resultService.getType(), "unknown");
        Assert.assertEquals(resultService.getMessage(), "ok");
    }

    @Test
    public void getUser() throws IOException {
        postUserJson();
        String jsonBody = lerJson("src/test/resources/data/user.json");

        UserDTO resultService = userService.getUser("guzs", jsonBody);
        Assert.assertEquals(resultService.getId(), "2022000001");
        Assert.assertEquals(resultService.getUsername(), "guzs");
        Assert.assertEquals(resultService.getFirstName(), "Gustavo");
        Assert.assertEquals(resultService.getLastName(), "Teichmann");
        Assert.assertEquals(resultService.getEmail(), "gustavo_teichmann@outlook.com");
        Assert.assertEquals(resultService.getPassword(),"gustavoteste");
        Assert.assertEquals(resultService.getPhone(),"05198985050");
        Assert.assertEquals(resultService.getUserStatus(), "0");
        userService.deleteUser("guzs");
    }

    @Test
    public void logoutUser() {

        UserResponseDTO resultService = userService.logoutUser();
        Assert.assertEquals(resultService.getCode(), "200");
        Assert.assertEquals(resultService.getType(), "unknown");
        Assert.assertEquals(resultService.getMessage(), "ok");
    }

    @Test
    public void loginUser() {

        UserResponseDTO resultService = userService.loginUser("guzs", "gustavoteste");
        Assert.assertEquals(resultService.getCode(), "200");
        Assert.assertEquals(resultService.getType(), "unknown");
        Assert.assertEquals(resultService.getMessage(), resultService.getMessage());
    }

    @Test
    public void deleteUser() throws IOException {
        postUserJson();
        String username = "guzs";

        UserResponseDTO resultService = userService.deleteUser(username);
        Assert.assertEquals(resultService.getCode(), "200");
        Assert.assertEquals(resultService.getType(), "unknown");
        Assert.assertEquals(resultService.getMessage(), username);
    }

    @Test
    public void putUser() throws IOException {
        postUserPut();
        String jsonBody = lerJson("src/test/resources/data/userEditado.json");

        String username = "guzs";
        UserResponseDTO resultService = userService.putUser(username, jsonBody);
        Assert.assertEquals(resultService.getCode(), "200");
        Assert.assertEquals(resultService.getType(), "unknown");
        Assert.assertEquals(resultService.getMessage(), "2022000001");
        userService.deleteUser(username);
    }

    @Test
    public void postUserPut() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/userEditado.json");

        UserResponseDTO resultService = userService.adicionarUser(jsonBody);
    }

    @Test
    public void postUserJson() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/user.json");

        UserResponseDTO resultService = userService.adicionarUser(jsonBody);
    }


}
