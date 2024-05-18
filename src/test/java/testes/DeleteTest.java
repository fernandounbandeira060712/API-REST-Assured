package testes;

import bases.BaseTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static enums.EndPointEnum.ENDPOINT_DELETE;
import static services.Services.deleteSemAutenticacao;

public class DeleteTest extends BaseTest {

	@Test(groups = {"regressivo"})
	public void validarStatusCode204() {
				deleteSemAutenticacao(ENDPOINT_DELETE.getEndPoint())
				.statusCode(HttpStatus.SC_NO_CONTENT);
	}

}
