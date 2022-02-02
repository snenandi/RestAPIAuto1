import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITests {
    @Test
    void test1(){
        given().get("http://api.intigral-ott.net/popcorn-api-rs-7.9.17/v1/promotions?apikey=sjadkjfgruie").
                then().statusCode(403);

    }
    @Test
    void test2(){
        given().get("http://api.intigral-ott.net/popcorn-api-rs-7.9.17/v1/promotions?apikey=sjadkjfgruie").
                then().assertThat().body(("error.code"),equalTo ("8001"));

    }
    @Test
    void test3(){
        given().get("http://api.intigral-ott.net/popcorn-api-rs-7.9.17/v1/promotions?apikey=sjadkjfgruie").
                then().assertThat().body(("error.message"),equalTo ("invalid api key"));

    }
    @Test
    void test4(){
        Response response=get("http://api.intigral-ott.net/popcorn-api-rs-7.9.17/v1/promotions?apikey=sjadkjfgruie");
        System.out.println("Request Id: "+response.getBody().asString());
            }

}
