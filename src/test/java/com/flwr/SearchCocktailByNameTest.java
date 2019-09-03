package com.flwr;

import com.flwr.utils.ConfigurationManager;
import com.flwr.utils.dto.CocktailModel;
import com.flwr.utils.dto.DrinkModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchCocktailByNameTest {

    private String cocktailNameToSearch = "margarita";

    @BeforeClass
    public void classSetup() throws IOException {
        RestAssured.baseURI = ConfigurationManager.getInstance().getProperty("baseUrl");
    }

    @Test
    public void nameTest(){
        Response response = RestAssured.given().contentType("application/json")
                .queryParam("s", cocktailNameToSearch)
                .get();
        CocktailModel drinks = response.getBody().as(CocktailModel.class);

        for (DrinkModel drink : drinks.getDrinks()){
            Assert.assertTrue(drink.getStrDrink().contains("Margarita"));
        }
    }

    @Test
    public void statusCodeTest(){
        RestAssured.given().contentType("application/json")
                .queryParam("s", cocktailNameToSearch)
                .get().then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void notEmptyTest(){
        String responseString = RestAssured.given().contentType("application/json")
                .queryParam("s", cocktailNameToSearch)
                .get().then().assertThat().extract().asString();
        Assert.assertNotNull(responseString);
    }
}
