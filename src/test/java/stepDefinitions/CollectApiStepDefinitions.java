package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class CollectApiStepDefinitions {


    String endPoint;
    Response response;



    @Given("kullanici {string} test adresine gider")
    public void kullanici_test_adresine_gider(String baseUrl) {
       endPoint= ConfigReader.getProperty(baseUrl);
    }
    @Then("kullanici path parametresi olarak {string} girer")
    public void kullanici_path_parametresi_olarak_girer(String pathParams) {

        endPoint=endPoint+"/"+pathParams;

    }
    @Then("kullanici query parametrelerini key degeri {string} value degeri {string} olarak girer")
    public void kullanici_query_parametrelerini_key_degeri_value_degeri_olarak_girer(String key1, String value1) {

        endPoint=endPoint+"?"+key1+"="+value1;

    }
    @Then("kullanici diger query parametrelerini key2 degeri {string} valeu2 degerini {string} olarak girer")
    public void kullanici_diger_query_parametrelerini_key2_degeri_valeu2_degerini_olarak_girer(String key2, String value2) {

        endPoint=endPoint+"&"+key2+"="+value2;

    }
    @Then("kullanici donen response degerini kaydeder")
    public void kullanici_donen_response_degerini_kaydeder() {
       response=given().when().header("Authorization","apikey 23rtCULosghrXY45OCUajh:7wBTkdxKoes7bg4tXlbnLa").get(endPoint);
    }
    @Then("kullanici donen response listesini yazdirir")
    public void kullanici_donen_response_listesini_yazdirir() {

        response.prettyPrint();
    }

}
