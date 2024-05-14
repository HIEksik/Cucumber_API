package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class NasaStepDefinitions {

    String endPoint;
    Response response;

    @Given("kullanici resim icin {string} adresine gider.")
    public void kullaniciResimIcinAdresineGider(String baseUrl) {
        endPoint = ConfigReader.getProperty(baseUrl);
    }

    @Then("kullanici site path parametresi olarak {string} girer.")
    public void kullaniciSitePathParametresiOlarakGirer(String pathParams) {
        endPoint = endPoint +pathParams;
    }

    @Then("kullanici query parametrelerini key degeri {string} value degeri {string} olarak girer.")
    public void kullaniciQueryParametreleriniKeyDegeriValueDegeriOlarakGirer(String key1, String value1) {
        endPoint = endPoint +"?"+key1+"="+value1;
    }

    @Then("kullanici diger query parametrelerini key_2 degeri {string} value_2 degerini {string} olarak girer.")
    public void kullaniciDigerQueryParametreleriniKey_DegeriValue_DegeriniOlarakGirer(String key2, String value2) {
        endPoint = endPoint +"&"+key2+"="+value2;
    }

    @Then("kullanici diger query parametrelerini key_3 degeri {string} value_3 degerini {string} olarak girer.")
    public void kullaniciDigerQueryParametreleriniKey_DegeriValue_DegeriniOlarakGirer2(String key3, String value3) {
        endPoint = endPoint +"&"+key3+"="+value3;
    }

    @Then("kullanici donen response degerini kaydeder.")
    public void kullaniciDonenResponseDegeriniKaydeder() {
        response = given().when().get(endPoint);
    }

    @Then("kullanici donen response listesini yazdirir.")
    public void kullaniciDonenResponseListesiniYazdirir() {
        response.prettyPrint();
    }
}