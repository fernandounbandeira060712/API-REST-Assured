package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;


public class Common {
    public static JsonNode converterJsonParaJsonNode(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo JSON", e);
        }
    }

    public static Map<String, Object> requestBodyNameJob(String name, String job) {
        Map<String, Object> body_auth = new HashMap<>();
        body_auth.put("name", name);
        body_auth.put("job", job);

        return body_auth;
    }

    public static Map<String, Object> requestBodyEmailPasssword(String email, String password) {
        Map<String, Object> body_auth = new HashMap<>();
        body_auth.put("email", email);
        body_auth.put("password", password);

        return body_auth;
    }

    public static Map<String, Object> requestBodyEmail(String email) {
        Map<String, Object> body_auth = new HashMap<>();
        body_auth.put("email", email);

        return body_auth;
    }

    public static Map<String, Object> requestBodynull(String email, String password) {
        Map<String, Object> body_auth = new HashMap<>();
        body_auth.put("email", email);
        body_auth.put("password", password);


        return body_auth;
    }


    public static Map<String, Object> requestBodyPassword(String password) {
        Map<String, Object> body_auth = new HashMap<>();
        body_auth.put("password", password);

        return body_auth;
    }

}







