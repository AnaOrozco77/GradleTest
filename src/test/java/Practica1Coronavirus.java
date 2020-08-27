import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;


public class Practica1Coronavirus {

    @Test
    public void Datos(){
        RestAssured.baseURI = String.format("https://api.quarantine.country/api/v1/summary/latest");
        /*RequestSpecification httpRequest = RestAssured.given();*/

        Response response = given().log().all().header("Accept","application/json").get();
        String body = response.getBody().asString();

        System.out.println("Body Response: " + body);
        System.out.println("Status Expected: 200");
        System.out.println("Response Status: " + response.getStatusCode());
        System.out.println("Response Headers: " + response.getHeaders());
        System.out.println("Response ContentType: " + response.contentType());

        assertEquals(200, response.getStatusCode());
        assertTrue(body.contains("summary"));

    }

    @Test
    public void Datos_RegionMx_Error(){
        RestAssured.baseURI = String.format("https://api.quarantine.country/api/v1/region?region=mx");
        Response response = given().log().all().header("Accept","application/json").get();
        String body = response.getBody().asString();

        System.out.println("Body Response= " + body);
        System.out.println("Response Status = " + response.getStatusCode());
        System.out.println("Response Headers = " + response.getHeaders());
        System.out.println("Response ContentType = " + response.contentType());
        assertEquals(404,response.getStatusCode());
    }



    @Test
    public void Datos_Semanales_RegionRusia(){

        Response response = given().queryParam("region","russia").when()
                .log().all()
                .get("https://api.quarantine.country/api/v1/spots/week");

        String body = response.getBody().asString();

        System.out.println("Body Response= " + body);
        System.out.println("Response Status = " + response.getStatusCode());
        System.out.println("Response Headers = " + response.getHeaders());
        System.out.println("Response ContentType = " + response.contentType());

        assertEquals(200,response.getStatusCode());
        assertNotNull(body);
        assertTrue(body.contains("total_cases"));

    }
}
