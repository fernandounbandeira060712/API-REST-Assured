package enums;

public enum UsuarioEnum {

    USUARIO_VALIDO_POST_CREATE("morpheus", "leader", null, null),
    
    USUARIO_VALIDO_UPDATE("morpheus", "zion resident", null, null),

    USUARIO_VALIDO_POST_REGISTER_SUCCESSFUL(null, null, "eve.holt@reqres.in", "pistol"),

    USUARIO_VALIDO_POST_REGISTER_UNSUCCESSFUL (null, null, "eve.holt@reqres.in", null),

    USUARIO_VALIDO_POST_LOGIN_SUCCESSFUL(null, null, "eve.holt@reqres.in", "cityslicka"),

    USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUL_PASSWORD_NULL (null, null, "peter@klaven", null),

    USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUL_EMAIL_NULL (null, null, null, "cityslicka"),

    USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUL_NULL (null, null, null, null),

    USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUL_PASSWORD_EMPTY (null, null, "peter@klaven", ""),

    USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUL_EMAIL_EMPTY (null, null, "", "cityslicka"),

    USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUK_EMPTY (null, null, "", "");




    private final String name;
    private final String job;
    private final String email;
    private final String password;

    UsuarioEnum(String name, String job, String email, String password) {
        this.name = name;
        this.job = job;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}

