package api.endpoints;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class UserEndPointsScenarioThreePointOne {
    public static String responseAfterAddingTwoDecks;
    @Test
    public void twoNewDeckOfCards(){
        System.out.println("Two new deck of cards");
            responseAfterAddingTwoDecks= given()
                    .when()//.get("https://www.deckofcardsapi.com/api/deck/new/shuffle/?deck_count=2")
        .get(routes.getTwoNewDeckOfCardsUrl()).then().log().body().extract().asString();
    }
}
