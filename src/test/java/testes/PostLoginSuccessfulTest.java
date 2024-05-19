package testes;

import bases.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.Test;

import static enums.EndPointEnum.ENDPOINT_POST_LOGIN;
import static enums.EndPointEnum.ENDPOINT_POST_REGISTER;
import static enums.UsuarioEnum.USUARIO_VALIDO_POST_LOGIN_SUCCESSFUL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.AssertJUnit.assertEquals;
import static services.Services.postComLoginNoBody;
import static utils.Common.*;

public class PostLoginSuccessfulTest extends BaseTest {


    @Test(groups = {"regressivo"})
    public void validarStatusCode200EResponseBody() {
        JsonNode responseAtual = postComLoginNoBody(ENDPOINT_POST_LOGIN.getEndPoint(),
                requestBodyEmailPasssword(USUARIO_VALIDO_POST_LOGIN_SUCCESSFUL.getEmail(), USUARIO_VALIDO_POST_LOGIN_SUCCESSFUL.getPassword()))
                .statusCode(SC_OK)
                .extract().response().as(JsonNode.class);

        JsonNode responseEsperado = converterJsonParaJsonNode("src/test/resources/arquivos/responses/PostLoginSuccessful.json");

        assertEquals(responseAtual, responseEsperado);
    }

    @Test(groups = {"contrato"})
    public void validarSchema() {
        postComLoginNoBody(ENDPOINT_POST_REGISTER.getEndPoint(), requestBodyEmailPasssword(USUARIO_VALIDO_POST_LOGIN_SUCCESSFUL.getEmail(), USUARIO_VALIDO_POST_LOGIN_SUCCESSFUL.getPassword()))
                .body(matchesJsonSchemaInClasspath("arquivos/schemas/PostRegisterSuccessfulSchema.json"));
    }

}