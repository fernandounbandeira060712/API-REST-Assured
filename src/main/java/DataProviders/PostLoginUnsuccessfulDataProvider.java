package DataProviders;

import org.testng.annotations.DataProvider;

import static enums.UsuarioEnum.*;
import static utils.Common.*;

public class PostLoginUnsuccessfulDataProvider {

    private static final String ERRO_SENHA = "Missing password";
    private static final String ERRO_EMAIL_OU_NOME_USUARIO = "Missing email or username";

    @DataProvider(name = "validarCamposObrigatorios")
    public Object[][] validarCamposObrigatorios() {
        return new Object[][]{


                {
                        requestBodyEmail(USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUL_PASSWORD_NULL.getEmail()),
                        ERRO_SENHA
                },
                {
                        requestBodyPassword(USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUL_EMAIL_NULL.getPassword()),
                        ERRO_EMAIL_OU_NOME_USUARIO
                },
                {
                        requestBodyPassword(USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUL_PASSWORD_NULL.getPassword()),
                        ERRO_EMAIL_OU_NOME_USUARIO
                },
                {
                        requestBodyEmail(USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUL_EMAIL_NULL.getEmail()),
                        ERRO_EMAIL_OU_NOME_USUARIO
                },
                {
                        requestBodynull(USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUL_NULL.getEmail(), USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUL_NULL.getPassword()),
                        ERRO_EMAIL_OU_NOME_USUARIO
                },
                {
                        requestBodyPassword(USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUL_PASSWORD_EMPTY.getPassword()),
                        ERRO_EMAIL_OU_NOME_USUARIO
                },
                {
                        requestBodyEmail(USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUL_EMAIL_EMPTY.getEmail()),
                        ERRO_EMAIL_OU_NOME_USUARIO
                },
                {
                        requestBodynull(USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUK_EMPTY.getEmail(), USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUK_EMPTY.getPassword()),
                        ERRO_EMAIL_OU_NOME_USUARIO
                }
        };
    }
}
