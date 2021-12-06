package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
public class test1 {
    @Test
    public void searchActor(){
       when()
                .get("https://imdb-api.com/en/API/SearchName/k_wqdgfw7l/Jean Reno")
                .then()
                .statusCode(200)
               .body("expression",equalTo("Jean Reno"));
    }
    @Test
    public void actorFilm(){
        RestAssured.baseURI="https://imdb-api.com";
        RequestSpecification httpRequest=given();
        Response response = httpRequest.get("/en/API/SearchName/k_wqdgfw7l/Jean Reno");
        ResponseBody body= response.getBody();
        String bodyAsString=body.asString();
        System.out.println(bodyAsString);
        Assert.assertTrue(bodyAsString.contains("Actor, Léon: The Professional (1994)"));
    }
    @Test
    public void YouTubeTrailer()
    {
        when()
                .get("https://imdb-api.com/en/API/YouTubeTrailer/k_wqdgfw7l/tt1375666")
                .then()
                .statusCode(200)
                .body("fullTitle",equalTo("Inception (2010)"));
    }

}
