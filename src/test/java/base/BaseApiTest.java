package base;

import io.restassured.http.Header;

public class BaseApiTest {

    public static final String baseUrl = "https://dummyapi.online";
    public static final Header header = new Header("Accept", "application/json");
}
