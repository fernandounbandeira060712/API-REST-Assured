package testes;

import bases.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static enums.EndPointEnum.ENDPOINT_GET_LIST_USERS;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.testng.Assert.assertEquals;
import static services.Services.getSemAutenticacao;
import static utils.Common.converterJsonParaJsonNode;

public class GetListUsersTest extends BaseTest {

	@Test(groups = {"regressivo"})
	public void validarStatusCode200EResponseBody() {
		JsonNode responseAtual = getSemAutenticacao(ENDPOINT_GET_LIST_USERS.getEndPoint())
				.statusCode(HttpStatus.SC_OK)
				.extract()
				.response().body().as(JsonNode.class);

		JsonNode responseEsperado = converterJsonParaJsonNode("src/test/resources/arquivos/responses/GetListUsers.json");

		assertEquals(responseAtual, responseEsperado);
	}


	@Test(groups = {"contrato"})
	public void validarSchema() {
		getSemAutenticacao(ENDPOINT_GET_LIST_USERS.getEndPoint())
				.body(matchesJsonSchemaInClasspath("arquivos/schemas/GetListUsersSchema.json"));
	}
}
