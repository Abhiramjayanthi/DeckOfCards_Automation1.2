package api.endpoints;
/*
import static io.restassured.RestAssured.given;

public class UserEndPointsScenario4 {
    public static String deck_id;
    public static String bodyResponse;

    public void getNewDeckOfCards(){
        System.out.println(" A new deck of cards");
        deck_id=given()
                .when()//.get("https://www.deckofcardsapi.com/api/deck/new/")
                .get(routes.getNewDeckOfCardsUrl()).then().log().body().extract().response().body().path("deck_id");
        System.out.println(deck_id);
    }

    public void removeFifthyThreeCards(){ // create a method nd remove cards and pass the parameter
        System.out.println("Drawing 53 cards");
        bodyResponse=given().when()//.get("https://www.deckofcardsapi.com/api/deck/"+deck_id+"/draw/?count=53")
                .get(routes.getRemovingFiftyThreeCardsUrl()).then().log().body().extract().asString();
    }
}
*/