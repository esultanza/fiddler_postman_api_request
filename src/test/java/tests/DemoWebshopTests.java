package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;

public class DemoWebshopTests {
    @BeforeAll
    static void beforeEach() {
        RestAssured.baseURI = "http://demowebshop.tricentis.com";
    }

    @Test
    void someCalculateTest() {
        String data = "product_attribute_72_5_18=53&product_attribute_72_6_19=54&product_attribute_72_3_20=57&addtocart_72.EnteredQuantity=1";
        Response response = given()
                .cookie("NOPCOMMERCE.AUTH=939460DC838BA1B096A483AA19908FAA18CD65ADFE275258849C909970AD9F549B8E42453BF51FE3502664D8C10A5BF1AFF7E5581AFF725D4950A778781D9569DABE30C0F9ADD48823ABE54DFE7AC182A7E49EE051C6B2A40D534FB452B1CE29A956A052E8830BB0F84DE79223F6306F9B9D8D378A63635E1F9968DB72CDBA56F276F791A68C1F4FCD7FD5D07E90B095;")
                .contentType(ContentType.URLENC)
                .body(data)
                .when()
                .post("/addproducttocart/details/72/1")
                .then()
                .statusCode(200)
                .extract()
                .response();

        Boolean successResult = response.path("success");
        assertTrue(successResult, response.asString());
    }

    @Test
    void some1CalculateTest() {
        String data = "product_attribute_72_5_18=53&product_attribute_72_6_19=54&product_attribute_72_3_20=57&addtocart_72.EnteredQuantity=1";
        given()
                .cookie("NOPCOMMERCE.AUTH=939460DC838BA1B096A483AA19908FAA18CD65ADFE275258849C909970AD9F549B8E42453BF51FE3502664D8C10A5BF1AFF7E5581AFF725D4950A778781D9569DABE30C0F9ADD48823ABE54DFE7AC182A7E49EE051C6B2A40D534FB452B1CE29A956A052E8830BB0F84DE79223F6306F9B9D8D378A63635E1F9968DB72CDBA56F276F791A68C1F4FCD7FD5D07E90B095;")
                .contentType(ContentType.URLENC)
                .body(data)
                .when()
                .post("/addproducttocart/details/72/1")
                .then()
                .statusCode(200)
                .body("success", is(true));
    }
}
