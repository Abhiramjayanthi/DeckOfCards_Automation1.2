package api.unitTests;

import api.endpoints.DeckOfCards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DeckOfCardsTest {
    private DeckOfCards deckOfCards;

    @BeforeEach
    void setup(){
        deckOfCards = new DeckOfCards(DeckOfCards.DeckType.STANDARD);
    }

    @Test
    public void testCreateDeck(){
        assertNotNull(deckOfCards.getDeckId());
    }
    @Test
    public void testDrawCards(){
        
    }
}
