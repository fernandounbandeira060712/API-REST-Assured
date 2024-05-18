package testes;

import bases.BaseTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static enums.EndPointEnum.ENDPOINT_GET_SINGLE_RESOURCE_NOT_FOUND;
import static org.hamcrest.core.Is.is;
import static services.Services.getSemAutenticacao;

public class GetSingleResourceNotFoundTest extends BaseTest {

	@Test(groups = {"regressivo"})
	public void validarStatusCode404EResponseBody() {
		getSemAutenticacao(ENDPOINT_GET_SINGLE_RESOURCE_NOT_FOUND.getEndPoint())
				.statusCode(HttpStatus.SC_NOT_FOUND)
				.body(is("{}"));

	}

}
