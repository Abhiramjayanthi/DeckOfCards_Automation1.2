package api.unitTests;

import api.endpoints.DeckOfCards;
import api.endpoints.DeckResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeckOfCardsTest {
    private DeckOfCards deckOfCards;

    @BeforeEach
    public void setUp() {
        deckOfCards = new DeckOfCards(DeckOfCards.DeckType.SHUFFLED_WITH_JOKERS);
    }

    @Test
    public void testCreateDeck(){
        String deckId = deckOfCards.getDeckId();
        assertNotNull(deckId, "Deck ID should not be null");
    }
    @Test
    public void testDrawCards(){
        List<String> drawCards = deckOfCards.drawCards(4);
        assertNotNull(drawCards);
    }
    @Test
    public void testShuffleDeck(){
        String.

    }
}
