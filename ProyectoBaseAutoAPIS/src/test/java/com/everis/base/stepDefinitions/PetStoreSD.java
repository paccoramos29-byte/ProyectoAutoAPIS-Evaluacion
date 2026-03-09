package com.everis.base.stepDefinitions;

import com.everis.base.PetStoreStep;
import com.everis.base.models.Order;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import com.everis.base.models.Pet;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PetStoreSD {

    @Steps
    PetStoreStep petStore;
    Pet pet;
    @Given("configuro petstore")
    public void configuro_petstore() {
        petStore.configurarBaseUri();
    }
    @Given("creo pet valido")
    public void creo_pet_valido() {
        pet = petStore.crearPetValido();
    }
    @When("envio POST pet")
    public void envio_post_pet() {
        petStore.enviarPostPet(pet);
    }
    // ✅ ESTE ES EL QUE TE FALTABA (para inventario y cualquier GET con string)
    @When("envio GET {string}")
    public void envio_get_string(String endpoint) {
        petStore.enviarGet(endpoint);
    }
    @When("envio GET pet por id")
    public void envio_get_pet_por_id() {
        petStore.enviarGet("/pet/" + petStore.petId);
    }
    @When("envio GET pet inexistente")
    public void envio_get_pet_inexistente() {
        petStore.enviarGet("/pet/999999999");
    }
    // ✅ NEGATIVO ESTABLE (400)
    @When("envio POST pet invalido raw")
    public void envio_post_pet_invalido_raw() {
        petStore.enviarPostPetInvalidoRaw();
    }
    @Then("valido status {int}")
    public void valido_status(Integer status) {
        Assert.assertEquals(status.intValue(), petStore.response.statusCode());
    }
    @Then("valido header content-type")
    public void valido_header_content_type() {
        String ct = petStore.response.getHeader("Content-Type");
        Assert.assertNotNull(ct);
        Assert.assertTrue(ct.contains("application/json"));
    }
    @Then("valido nombre {string}")
    public void valido_nombre(String nombre) {
        Assert.assertEquals(nombre,
                petStore.response.jsonPath().getString("name"));
    }

}
