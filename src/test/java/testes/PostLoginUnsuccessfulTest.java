package testes;

import bases.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import DataProviders.PostLoginUnsuccessfulDataProvider;

import java.util.Map;

import static enums.EndPointEnum.ENDPOINT_POST_LOGIN;
import static enums.UsuarioEnum.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.testng.AssertJUnit.assertEquals;
import static services.Services.postComLoginNoBody;
import static utils.Common.*;

public class PostLoginUnsuccessfulTest extends BaseTest {


    @Test(groups = "regressivo", dataProviderClass = PostLoginUnsuccessfulDataProvider.class, dataProvider = "validarCamposObrigatorios")
    public void validarStatusCode400ECamposObrigatorios(Map<String, Object> body, String mensagemEsperada) {

        String responseError = postComLoginNoBody(ENDPOINT_POST_LOGIN.getEndPoint(), body)
                .statusCode(SC_BAD_REQUEST)
                .extract().response().body().path("error");
        assertEquals(responseError, mensagemEsperada);

    }

    @Test(groups = {"contrato"})
    public void validarSchema() {
        postComLoginNoBody(ENDPOINT_POST_LOGIN.getEndPoint(),
                requestBodyEmail(USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUL_PASSWORD_NULL.getEmail()))
                .body(matchesJsonSchemaInClasspath("arquivos/schemas/PostLoginUnsuccessfulSchema.json"));
    }

}