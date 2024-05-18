package testes;

import bases.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.Test;

import static enums.EndPointEnum.ENDPOINT_POST_REGISTER;
import static enums.UsuarioEnum.USUARIO_VALIDO_POST_LOGIN_SUCCESSFUK;
import static enums.UsuarioEnum.USUARIO_VALIDO_POST_REGISTER_UNSUCCESSFUK;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.testng.AssertJUnit.assertEquals;
import static services.Services.postComLoginNoBody;
import static utils.Common.*;


public class PostRegisterUnuccessfulTest extends BaseTest {


    @Test(groups = {"regressivo"})
    public void validarStatusCode201EResponseBody() {
        JsonNode responseAtual = postComLoginNoBody(ENDPOINT_POST_REGISTER.getEndPoint(),
                requestBodyEmail(USUARIO_VALIDO_POST_REGISTER_UNSUCCESSFUK.getEmail()))
                .statusCode(SC_BAD_REQUEST)
                .extract().response().as(JsonNode.class);

        JsonNode responseEsperado = converterJsonParaJsonNode("src/test/resources/arquivos/responses/PostRegisterUnsuccessful.json");

        assertEquals(responseAtual, responseEsperado);
    }

    @Test(groups = {"contrato"})
    public void validarCorpoObrigatorioNoRequestBody() {
        validarCorpoObrigatorio(USUARIO_VALIDO_POST_LOGIN_SUCCESSFUK.getEmail());
    }

    @Test(groups = {"contrato"})
    public void validarSchemaPostProductsAddTest() {
        postComLoginNoBody(ENDPOINT_POST_REGISTER.getEndPoint(), requestBodyEmail(USUARIO_VALIDO_POST_REGISTER_UNSUCCESSFUK.getEmail()))
                .body(matchesJsonSchemaInClasspath("arquivos/schemas/PostRegisterUnsuccessfulschema.json"));
    }

}