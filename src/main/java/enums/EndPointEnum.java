package enums;

public enum EndPointEnum {
    ENDPOINT_GET_LIST_USERS("/users?page=2"),
    ENDPOINT_GET_SINGLE_USER("/users/2"),
    ENDPOINT_GET_SINGLE_USER_NOT_FOUND("/users/23"),
    ENDPOINT_GET_LIST_RESOURCE("/unknown"),
    ENDPOINT_GET_SINGLE_RESOURCE("/unknown/2"),
    ENDPOINT_GET_SINGLE_RESOURCE_NOT_FOUND("/unknown/23"),
    ENDPOINT_POST_CREATE("/users"),
    ENDPOINT_PUT_UPDAYE("/users/2"),
    ENDPOINT_PATCH_UPDAYE("/users/2"),
    ENDPOINT_DELETE("/users/2"),
    ENDPOINT_POST_REGISTER("/register"),
    ENDPOINT_POST_LOGIN("/login"),
    ENDPOINT_GET_DELAYED_RESPONSE("/users?page=2")
    ;

    private String endPoint;

    EndPointEnum(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }
}