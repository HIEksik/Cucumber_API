package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class JPHStepDefinitions {

    String endPoint;
    Response response;
    JsonPath resJP;
    JSONObject posteRequestBody;

    @Given("kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String baseUrl) {
        endPoint=ConfigReader.getProperty(baseUrl);

    }
    @Then("kullanici path parametrleri olarak {string} girer")
    public void kullanici_path_parametrleri_olarak_girer(String pathParams) {
        endPoint=endPoint+"/"+pathParams;


    }
    @Then("kullanici bir GET request gonderir ve donen response degerini kaydeder")
    public void kullanici_bir_get_request_gonderir_ve_donen_response_degerini_kaydeder() {
        response=given().when().get(endPoint);

    }
    @Then("kullanici donen cevabin status degerinin {int} oldugunu kontrol eder")
    public void kullanici_donen_cevabin_status_degerinin_oldugunu_kontrol_eder(int statusCode) {

       assertEquals(statusCode,response.getStatusCode());
    }
    @Then("kullanici donen cevabin content-type degerinin {string} oldugunu kontrol eder")
    public void kullanici_donen_cevabin_content_type_degerinin_oldugunu_kontrol_eder(String contentType) {

        assertEquals(contentType,response.getContentType());
    }
    @Then("kullanici donen cevaptaki userid degerinin {int} oldugunu kontrol eder")
    public void kullanici_donen_cevaptaki_userid_degerinin_oldugunu_kontrol_eder(int userId) {

        resJP=response.jsonPath();

        assertEquals(userId,resJP.getInt("userId"));

    }
    @Then("kullanici donen cevaptaki title degerinin {string} oldugunu kontrol eder")
    public void kullanici_donen_cevaptaki_title_degerinin_oldugunu_kontrol_eder(String title) {

        assertEquals(title,resJP.getString("title"));

    }

    @Then("kullanici post request icin {string},{string}, {int} {int} bilgileri ile reqBody olusturur")
    public void kullanici_post_request_icin_bilgileri_ile_req_body_olusturur(String title, String body, int userId, int id) {

        posteRequestBody=new JSONObject();
        posteRequestBody.put("title",title);
        posteRequestBody.put("body",body);
        posteRequestBody.put("userId",userId);
        posteRequestBody.put("id",id);

    }
    @Then("kullanici post request gonderir ve donen response kaydeder")
    public void kullanici_post_request_gonderir_ve_donen_response_kaydeder() {

        response=given().when().body(posteRequestBody.toString()).contentType(ContentType.JSON).post(endPoint);
        // ----> Eğer yetki istenseydi nasıl bir request gonderilirdi
        //.post() demeden once .header("Authorization","apikey 5ce8BgifHKqNjeo1RV9n5D:3xqG2GwaHpvFx8KAhRTBvo")

    }
    @Then("kullanici donen cevabin {string} isimli header degerinin {string} oldugunu kontrol eder")
    public void kullanici_donen_cevabin_isimli_header_degerinin_oldugunu_kontrol_eder(String headerAtribute, String headerValue) {
        assertEquals(headerValue,response.header(headerAtribute));


    }
    @Then("kullanici donen cevabin attribute degerlerinin {string},{string},{int} {int} oldugunu kontrol eder")
    public void kullanici_donen_cevabin_attribute_degerlerinin_oldugunu_kontrol_eder(String title, String body, int userId, int id) {
        resJP=response.jsonPath();
        assertEquals(title,resJP.getString("title"));
        assertEquals(body,resJP.getString("body"));
        assertEquals(userId,resJP.getInt("userİd"));
        assertEquals(id,resJP.getInt("id"));
    }





}
