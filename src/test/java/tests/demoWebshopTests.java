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

public class demoWebshopTests {
    @BeforeAll
    static void beforeEach() {
        RestAssured.baseURI = "http://demowebshop.tricentis.com";
    }

    @Test
    void addToCartTest() {
        String data = "addtocart_31.EnteredQuantity=1";

        given()
                .cookie("Nop.customer=30240831-542a-451f-9213-b737e9b0db3c; ARRAffinity=ee34a24226ab32a8911d8213bc61638c0a238bf662e0bad7090e344fefc05587; __utmc=78382081; __utmz=78382081.1601729663.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=52; __utma=78382081.733719277.1601729663.1601729663.1601737272.2; __utmt=1; __atuvc=5%7C40; __atuvs=5f789273ee9f6639000; __utmb=78382081.7.10.1601737272")
                .contentType(ContentType.URLENC)
                .body(data)
                .when()
                .post("/addproducttocart/details/31/1")
                .then()
                .statusCode(200)
                .body("success", is(true));
    }
    @Test
    void removeFromCartTest() {
        String data = "removefromcart=1491408";

        given()
                .cookie("Nop.customer=30240831-542a-451f-9213-b737e9b0db3c; ARRAffinity=ee34a24226ab32a8911d8213bc61638c0a238bf662e0bad7090e344fefc05587; __utmc=78382081; __utmz=78382081.1601729663.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=52; __utma=78382081.733719277.1601729663.1601729663.1601737272.2; __utmt=1; __atuvc=5%7C40; __atuvs=5f789273ee9f6639000; __utmb=78382081.7.10.1601737272")
                .contentType(ContentType.URLENC)
                .body(data)
                .when()
                .post("/cart")
                .then()
                .statusCode(200)
                .body("success", is(true));
    }
}
