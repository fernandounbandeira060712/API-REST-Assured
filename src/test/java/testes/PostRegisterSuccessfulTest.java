package testes;

import bases.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.Test;

import static enums.EndPointEnum.*;
import static enums.UsuarioEnum.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.AssertJUnit.assertEquals;
import static services.Services.*;
import static utils.Common.*;

public class PostRegisterSuccessfulTest extends BaseTest {


    @Test(groups = {"regressivo"})
    public void validarStatusCode200EResponseBody() {
        JsonNode responseAtual = postComLoginNoBody(ENDPOINT_POST_REGISTER.getEndPoint(),
                requestBodyEmailPasssword(USUARIO_VALIDO_POST_REGISTER_SUCCESSFUL.getEmail(), USUARIO_VALIDO_POST_REGISTER_SUCCESSFUL.getPassword()))
                .statusCode(SC_OK)
                .extract().response().as(JsonNode.class);

        JsonNode responseEsperado = converterJsonParaJsonNode("src/test/resources/arquivos/responses/PostRegisterSuccessful.json");

        assertEquals(responseAtual, responseEsperado);
    }

    @Test(groups = {"contrato"})
    public void validarSchema() {
        postComLoginNoBody(ENDPOINT_POST_REGISTER.getEndPoint(), requestBodyEmailPasssword(USUARIO_VALIDO_POST_REGISTER_SUCCESSFUL.getEmail(), USUARIO_VALIDO_POST_REGISTER_SUCCESSFUL.getPassword()))
                .body(matchesJsonSchemaInClasspath("arquivos/schemas/PostRegisterSuccessfulSchema.json"));
    }

}