package fr.shooterdev;

import fr.shooterdev.dto.CouleurRequest;
import fr.shooterdev.resources.CouleurResource;
import fr.shooterdev.services.CouleurService;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectSpy;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestHTTPEndpoint(CouleurResource.class)
class CouleurResourceTest {
    @InjectSpy
    CouleurService couleurService;

    private int idCouleur;

    @Test
    void testCreateCouleurEndpoint() {
        String nomCouleur = "AAAAA";

        CouleurRequest couleurRequest = new CouleurRequest(nomCouleur);

        Response responce = given()
                .contentType("application/json")
                .body(couleurRequest)
                .when().post()
                .then().statusCode(201)
                .extract()
                .response();

        idCouleur = responce.jsonPath().getInt("id");

        Mockito.verify(couleurService, Mockito.times(1))
                .create(couleurRequest);
    }

    @Test
    void testGetCouleurByIdEndpoint() {
        given()
                .pathParam("id", idCouleur)
                .when().get("{id}")
                .then()
                .body("nomCouleur", equalTo("AAAAA"))
                .statusCode(200);

        Mockito.verify(couleurService, Mockito.times(1)).getById(idCouleur);
    }

    @Test
    void testUpdateCouleurEndpoint() {

        CouleurRequest couleurRequest = new CouleurRequest("BBBBB");
        var id = idCouleur;

        given()
                .contentType("application/json")
                .body(couleurRequest)
                .when().put("{id}",id)
                .then()
                .body("nomCouleur", equalTo("BBBBB"))
                .statusCode(200);

        Mockito.verify(couleurService, Mockito.times(1))
                .update(id, couleurRequest);
    }

    @Test
    void testGetCouleursEndpoint() {
        given().when().get()
                .then()
                .statusCode(200);

        Mockito.verify(couleurService, Mockito.times(1)).getAll();
    }

    @Test
    void testDeleteCouleurEndpoint() {
        var id = 1;

        given()
                .pathParam("id",id)
                .when().delete("{id}")
                .then().statusCode(200);

        Mockito.verify(couleurService, Mockito.times(1)).delete(id);
    }
}