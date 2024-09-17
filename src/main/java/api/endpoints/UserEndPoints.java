/*
package api.sky.endpoints;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserEndPoints {
    private static final Logger log = LoggerFactory.getLogger(UserEndPoints.class);
    public static String deck_id;
    public static String firstCard;
    public static String secondCard;
    public static String drawnTwoCards;
    public static String pileName = "pile100";
    public static String firstCardAddIntoPile;
    public static int remaining;

    public String getNewShuffledDeck() {
        deck_id = given()
                .when()
                .get(routes.getNewShuffledDeckUrl())
                .then().log().body().extract().response().body().path("deck_id");
        return deck_id;
    }

    public void drawTwoCards() {
        Response response = RestAssured.get(routes.getDrawCardsUrl(deck_id, 2));
        firstCard = response.jsonPath().getString("cards[0].code");
        secondCard = response.jsonPath().getString("cards[1].code");
        System.out.println("The first card drawn =" + " " + firstCard);
        System.out.println("The second card drawn =" + " " + secondCard); //replace with logger
    }

    public void addingCardsToPile100() {
        remaining = given()
                .when()
                .get(routes.getAddToPileUrl( pileName, firstCard + "," + secondCard))
                .then().log().body().extract().response().body().path("piles.pile100.remaining");
        System.out.println("Cards added to Pile :" + remaining);
    }

    public void displayPile100Cards() {
        given().when()
                .get(routes.getListPileCardsUrl(deck_id, pileName))
                .then().log().body();
    }
}
*/