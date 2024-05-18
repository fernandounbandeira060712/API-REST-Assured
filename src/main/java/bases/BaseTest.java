package bases;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static io.restassured.config.RestAssuredConfig.newConfig;
import static io.restassured.http.ContentType.JSON;
import static org.apache.commons.codec.Charsets.UTF_8;

public class BaseTest {
    private static final String URI = "https://reqres.in/api";

    @BeforeSuite(groups = {"regressivo", "contrato"})
    public void setupSuite() {
        baseURI = URI;
        config = newConfig().encoderConfig(encoderConfig().defaultContentCharset(UTF_8));
        requestSpecification = new RequestSpecBuilder().setContentType(JSON)
                .setAccept(JSON).setUrlEncodingEnabled(false).build();
        enableLoggingOfRequestAndResponseIfValidationFails();
        filters(
                new RequestLoggingFilter(),
                new ResponseLoggingFilter()
        );
    }
}
