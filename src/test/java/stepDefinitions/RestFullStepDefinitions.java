package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class RestFullStepDefinitions {

    String endPoint;
    Response response;

    JSONObject reqBody;


    @Given("kullanici update icin {string} adresine gider")
    public void kullaniciUpdateIcinAdresineGider(String baseUrl) {
        endPoint= ConfigReader.getProperty(baseUrl);
    }

    @Then("kullanici update icin path parametresi olarak {string} girer")
    public void kullaniciUpdateIcinPathParametresiOlarakGirer(String pathParams1) {
        endPoint=endPoint+"/"+pathParams1;
    }

    @Then("kullanici update icin {string} girer")
    public void kullaniciUpdateIcinGirer(String bookingid) {
        endPoint=endPoint+"/"+bookingid;
    }

    @Then("kullanici update icin bir body olusturur")
    public void kullaniciUpdateIcinBirBodyOlusturur() {
        reqBody=new JSONObject();
        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin","2023-01-01");
        bookingDates.put("checkout","2024-01-01");
        reqBody.put("firstname","Murat");
        reqBody.put("lastname","Yiğit");
        reqBody.put("totalprice",485);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",bookingDates);
        reqBody.put("additionalneeds","Breakfast,lunch,wifi");
    }

    @Then("kullanici bir put request gonderip donen response degerini kaydeder")
    public void kullaniciBirPutRequestGonderipDonenResponseDegeriniKaydeder() {

        response=given().when().body(reqBody.toString()).contentType(ContentType.JSON).header("Cookie","token=c3188df856b9087").put(endPoint);

    }

    @Then("kullanici donen response degerini yazdirir")
    public void kullaniciDonenResponseDegeriniYazdirir() {
        response.prettyPrint();
    }
}
