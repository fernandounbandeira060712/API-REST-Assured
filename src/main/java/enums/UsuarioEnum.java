package enums;

public enum UsuarioEnum {

    USUARIO_VALIDO_POST_CREATE("morpheus", "leader", null, null),
    
    USUARIO_VALIDO_UPDATE("morpheus", "zion resident", null, null),

    USUARIO_VALIDO_POST_REGISTER_SUCCESSFUK(null, null, "eve.holt@reqres.in", "pistol"),

    USUARIO_VALIDO_POST_REGISTER_UNSUCCESSFUK (null, null, "eve.holt@reqres.in", null),

    USUARIO_VALIDO_POST_LOGIN_SUCCESSFUK(null, null, "eve.holt@reqres.in", "cityslicka"),

    USUARIO_VALIDO_POST_LOGIN_UNSUCCESSFUK (null, null, "peter@klaven", null),;




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

