package testes;

import bases.BaseTest;
import org.testng.annotations.Test;

import static enums.EndPointEnum.*;
import static enums.UsuarioEnum.USUARIO_VALIDO_POST_CREATE;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.Matchers.*;
import static services.Services.postComLoginNoBody;
import static utils.Common.*;

public class PostCreateTest extends BaseTest {

    @Test(groups = {"regressivo"})
    public void validarStatusCode201EResponseBody() {
        postComLoginNoBody(ENDPOINT_POST_CREATE.getEndPoint(),
                requestBodyNameJob(USUARIO_VALIDO_POST_CREATE.getName(), USUARIO_VALIDO_POST_CREATE.getJob()))
                .statusCode(SC_CREATED)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"))
                .body("id", matchesPattern("\\d+"))
                .body("createdAt", matchesPattern("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}Z"));
    }

    @Test(groups = {"contrato"})
    public void validarCorpoObrigatorioNoRequestBody() {
        validarCorpoObrigatorio(USUARIO_VALIDO_POST_CREATE.getName(), USUARIO_VALIDO_POST_CREATE.getJob());
    }

    @Test(groups = {"contrato"})
    public void validarSchemaPostAuthLoginTest() {
        postComLoginNoBody(ENDPOINT_POST_CREATE.getEndPoint(), requestBodyNameJob(USUARIO_VALIDO_POST_CREATE.getName(), USUARIO_VALIDO_POST_CREATE.getJob()))
                .body(matchesJsonSchemaInClasspath("arquivos/schemas/CreateSchema.json"));

    }

}