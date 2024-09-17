package api.endpoints;
/*
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class UserEndPointsScenario2 {
    public static String deck_id;
    public static String firstCard;
    public static String secondCard;
    public static String response;
    public static String responseAfterRemovingTwoCards;
    public static String leftOverCards;
@Test
    public void newDeckWithJokers(){
        System.out.println("New Deck with Jokers");
        deck_id=given()
                .when().get(routes.getNewDeckWithJokersUrl())
                .then().log().body().extract().response().body().path("deck_id");
    }

    public void shuffleTheDeckWithJokers(){
        System.out.println("New Deck with Jokers is Shuffled");
         response = given()
                .when().get(routes.getShuffleDeckWithJokersUrl(deck_id))
                .then().log().body().extract().asString();
    }

    public void remove2CardsFromTheShuffledDeckWithJokers(){
        System.out.println("We have removed 2 cards");
        //RestAssured.baseURI = "https://deckofcardsapi.com";
        //Response response = RestAssured.get("/api/deck/"+deck_id+"/draw/?count=2");
        Response response = RestAssured.get(routes.getDrawCardsUrl(deck_id,2));
        firstCard= response.jsonPath().getString("cards[0].code");
        secondCard = response.jsonPath().getString("cards[1].code");
        responseAfterRemovingTwoCards=given()
                .when()//.delete("https://www.deckofcardsapi.com/api/deck/"+deck_id+"/?cards="+firstCard+","+secondCard)
                .delete(routes.getRemoveCardsUrl(deck_id,firstCard + "," + secondCard))
                .then().log().body().extract().asString();
    }

    public void leftOverCards(){
        System.out.println("After removing Left over cards");
        leftOverCards=given().when()//.get("https://www.deckofcardsapi.com/api/deck/"+deck_id+"/?jokers_enabled=true")
                .get(routes.getLeftOverCardsUrl(deck_id))
         .then().log().body().extract().asString();
    }
}
*/