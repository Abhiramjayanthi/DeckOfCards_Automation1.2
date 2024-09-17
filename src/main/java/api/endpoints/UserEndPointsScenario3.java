package api.endpoints;

import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UserEndPointsScenario3 {
    public static String deck_id;
    public static String pileName="Abhi";
    public static String cards;
    public String deck_idd;
    public String deck_iddd;
    public String firstCardsCodes;
    public String secondCardsCodes;

    public void getFirstDeck(){
        System.out.println("First Deck");
        deck_idd=given().when().get("https://www.deckofcardsapi.com/api/deck/new/").then().extract().response().body().path("deck_id");
        Response response=given()
                .when().get("https://www.deckofcardsapi.com/api/deck/"+deck_idd+"/draw/?count=52")
                .then().extract().response();
        System.out.println("First Deck ID value is "+deck_idd);

        JsonPath jsonPath = response.jsonPath();
        String firstCardsCodes = jsonPath.getString("cards.code");
        System.out.println("Drawn cards from First deck"+firstCardsCodes);
        getSecondDeck();
        addTwoDecksIntoPile();
    }

    public void getSecondDeck(){
        deck_iddd=given().when().get("https://www.deckofcardsapi.com/api/deck/new/").then().extract().response().body().path("deck_id");
        Response response=given()
                .when().get("https://www.deckofcardsapi.com/api/deck/"+deck_iddd+"/draw/?count=52")
                .then().extract().response();
        System.out.println("Second Deck ID value is "+deck_iddd);

        JsonPath jsonPath = response.jsonPath();
        String secondCardsCodes = jsonPath.getString("cards.code");
        System.out.println("Drawn cards from second deck"+secondCardsCodes);
    }

    public void addTwoDecksIntoPile(){
        given()
                .when().get("https://www.deckofcardsapi.com/api/deck/"+deck_id+deck_iddd+"/pile/"+pileName+"add/?cards="+firstCardsCodes+secondCardsCodes).then().log().body();
    }


    /*public void getTwoNewDeckOfCards(){
        deck_id=given().when().get("https://www.deckofcardsapi.com/api/deck/new/").then().extract().response().body().path("deck_id");
        Response response=given()
                .when().get("https://www.deckofcardsapi.com/api/deck/"+deck_id+"/draw/?count=52")
                .then().extract().response();
        System.out.println("Deck ID value is "+deck_id);

        JsonPath jsonPath = response.jsonPath();
       // List<String> cardsCodes = jsonPath.getList("cards.code");
        String cardsCodes = jsonPath.getString("cards.code");
        System.out.println("Drawn card codes"+cardsCodes);


        given().when().get("https://www.deckofcardsapi.com/api/deck/"+deck_id+"/pile/"+pileName+"/add/?cards="+cardsCodes)
                .then().log().body();
    } */
}
