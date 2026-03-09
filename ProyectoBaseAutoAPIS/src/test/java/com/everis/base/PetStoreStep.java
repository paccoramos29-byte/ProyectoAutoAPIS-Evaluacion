package com.everis.base;


import com.everis.base.models.Pet;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Collections;


public class PetStoreStep {

    public Response response;
    public Long petId;
    public void configurarBaseUri() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
    public Pet crearPetValido() {
        Pet pet = new Pet();
        pet.setId(System.currentTimeMillis());
        pet.setName("Firulais");
        pet.setStatus("available");
        pet.setPhotoUrls(Collections.singletonList("https://test.com"));
        return pet;
    }
    // POST valido con POJO
    public void enviarPostPet(Pet pet) {
        response = RestAssured.given()
                .baseUri(RestAssured.baseURI)
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post("/pet");
        if (response.statusCode() == 200) {
            petId = response.jsonPath().getLong("id");
        }
    }
    // GET generico
    public void enviarGet(String path) {
        response = RestAssured.given()
                .baseUri(RestAssured.baseURI)
                .when()
                .get(path);
    }
    // NEGATIVO ESTABLE: JSON MAL FORMADO -> 400
    public void enviarPostPetInvalidoRaw() {
        response = RestAssured.given()
                .baseUri(RestAssured.baseURI)
                .contentType(ContentType.JSON)
                .body("esto no es un json")
                .when()
                .post("/pet");
    }
}
