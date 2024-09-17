package api.endpoints;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static io.restassured.RestAssured.given;

public class DeckOfCards {
    private static final Logger log = LoggerFactory.getLogger(DeckOfCards.class);

    public String getDeckId() {
        return deckId;
    }

    private String deckId;

    public enum DeckType {
        STANDARD,
        WITH_JOKERS,
        SHUFFLED,
        SHUFFLED_WITH_JOKERS,
        MULTIPLE
    }

    public DeckOfCards(DeckType deckType, int deckCount) {
        this.deckId = createDeckOfCards(deckType, deckCount);
    }

    public DeckOfCards(DeckType deckType) {
        this(deckType, 1);
    }

    private String createDeckOfCards(DeckType deckType, int deckCount) {
        String requestStorageContainer = "";

        switch (deckType) {
            case STANDARD:
                requestStorageContainer = routes.getNewDeckOfCardsUrl();
                break;
            case WITH_JOKERS:
                requestStorageContainer = routes.getNewDeckWithJokersUrl();
                break;
            case SHUFFLED:
                requestStorageContainer = routes.getNewShuffledDeckUrl();
                break;
            case SHUFFLED_WITH_JOKERS:
                requestStorageContainer = routes.getNewShuffleDeckWithJokersUrl();
                break;
            case MULTIPLE:
                requestStorageContainer = routes.getMultipleDeckOfCards(deckCount);
                break;
            default:
                log.error("Invalid deck type provided: {}", deckType);
        }

        return given()
                .when()
                .get(requestStorageContainer)
                .then().log().body().extract().response().body().path("deck_id");
    }

    public void shuffleDeck() {
        given().when()
                .get(routes.getExistingShuffledDeckUrl(deckId))
                .then().log().body();
        log.info("Deck shuffled.");
    }

    public List<String> drawCards(int count) {
        Response response = given().when()
                .get(routes.getDrawCardsUrl(deckId, count))
                .then().log().body().extract().response();
        List<String> cards = response.jsonPath().getList("cards.code");
        for (int i = 0; i < cards.size(); i++) {
            //log.info("Card {}: {}", (i + 1), cards.get(i));
            System.out.println(cards.get(i));
        }
        log.info("Deck ID: {}", deckId);
        return cards;
    }

    public void addToPile(List<String> cards, String pileName) {
        String cardsParameters = String.join(",", cards);

        int remaining = given()
                .when()
                .get(routes.getAddToPileUrl(deckId, cardsParameters,pileName))
                .then().log().body().extract().response().body().path("piles." + pileName + ".remaining");

        log.info("Cards added to Pile {}: remaining cards = {}", pileName, remaining);
    }

    public void displayPileCards(String pileName) {
        given().when()
                .get(routes.getListPileCardsUrl(deckId, pileName))
                .then().log().body();
    }

}