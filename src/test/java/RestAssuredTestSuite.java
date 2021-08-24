import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class RestAssuredTestSuite {
    @Test
    public void CheckStatus200Test(){
        given().
            param("q","tascott").header("auth-key","1ab80388-3675-4957-a32b-ba80730215e7").
        when().
            get("https://digitalapi.auspost.com.au/postcode/search.json").
        then().
            statusCode(200);
    }

    @Test
    public void GivenSuburb_WhenGet_CheckPostcodeTest(){
        given().
            param("q","tascott").header("auth-key","1ab80388-3675-4957-a32b-ba80730215e7").
        when().
            get("https://digitalapi.auspost.com.au/postcode/search.json").
        then().
            statusCode(200).
            assertThat().body("localities.locality.postcode", equalTo(2250));
    }
}
