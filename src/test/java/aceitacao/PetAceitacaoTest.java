package aceitacao;

import aceitacao.dto.DeleteDTO;
import aceitacao.dto.TagsDTO;
import org.testng.Assert;
import aceitacao.dto.PetPayloadDTO;
import aceitacao.service.PetService;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Test
public class PetAceitacaoTest {

    PetService petService = new PetService();

    // Massa de dados para body
    public String lerJson(String caminhojson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhojson)));
    }

    // Metodo de teste
    @Test
    public void incluirPet() throws IOException {
        Integer idpet = 2022000001;
        String jsonBody = lerJson("src/test/resources/data/pet.json");

        PetPayloadDTO resultService = petService.adicionarPet(jsonBody);

        Assert.assertEquals(resultService.getId(), "2022000001");
        Assert.assertEquals(resultService.getName(), "Dogaomic");
        Assert.assertEquals(resultService.getCategory().getName(), "Hulk");
        petService.deletePet(idpet);
    }

    @Test
    public void getPet() throws IOException {
        addPeloJson();
        Integer idPet = 2022000001;

        PetPayloadDTO resultService = petService.getPet(idPet);

        List<String> lista = List.of("string");
        List<TagsDTO> listaTags = List.of(new TagsDTO("2" , "Tag"));
        Assert.assertEquals(resultService.getId(), "2022000001");
        Assert.assertEquals(resultService.getName(), "Dogaomic");
        Assert.assertEquals(resultService.getCategory().getId(), "2");
        Assert.assertEquals(resultService.getCategory().getName(), "Hulk");
        Assert.assertEquals(resultService.getPhotoUrls(), lista);
        Assert.assertEquals(resultService.getTags(), listaTags);
        Assert.assertEquals(resultService.getStatus(), "available");
        petService.deletePet(idPet);
    }

    @Test
    public void editarPet() throws IOException {
        addPeloJsonPut();
        Integer idPet = 34343434;
        // Caminho da massa de dados
        String jsonBody = lerJson("src/test/resources/data/pet-editado.json");

        PetPayloadDTO resultService = petService.editarPet(jsonBody);

        Assert.assertEquals(resultService.getId(),"34343434");
        Assert.assertEquals(resultService.getName(), "felix");
        Assert.assertEquals(resultService.getCategory().getName(), "Gato");
        petService.deletePet(idPet);
    }


    @Test
    public void deletePet() throws IOException {

        addPeloJson();

        Integer idPet = 2022000001;

        DeleteDTO resultService = petService.deletePet(idPet);

        Assert.assertEquals(resultService.getCode(), "200");
        Assert.assertEquals(resultService.getType(), "unknown");
        Assert.assertEquals(resultService.getMessage(), "2022000001");

    }

    private PetPayloadDTO addPeloJson() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/pet.json");

        return petService.adicionarPet(jsonBody);
    }

    private PetPayloadDTO addPeloJsonPut() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/pet-editado.json");

        return petService.adicionarPet(jsonBody);
    }
}
