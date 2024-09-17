package api.stepDefinitions;

import api.endpoints.DeckOfCards;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class deckOfCardsStepDefinitions {
    private String pileName;
    private DeckOfCards deckOfCards;
    private List<String> drawnCards;
    private List<String> removedCards;

    @Given("A new deck of cards shuffled")
    public void aNewDeckOfCardsShuffled() {
        deckOfCards = new DeckOfCards(DeckOfCards.DeckType.SHUFFLED);
        deckOfCards.shuffleDeck();
    }

    @And("I draw {int} cards")
    public void iDrawNumber_of_cardsCards(int numberOfCards) {
        drawnCards = deckOfCards.drawCards(numberOfCards);
    }

    @When("I add them to {string}")
    public void iAddThemToPile_name(String pileName) {
        this.pileName = pileName;
        deckOfCards.addToPile(drawnCards, pileName);
    }

    @Then("{string} has remaining cards")
    public void pile_nameHasRemainingCards(String pileName) {
        deckOfCards.displayPileCards(pileName);
    }

    @Given("A new deck of cards with jokers")
    public void aNewDeckOfCardsWithJokers() {
        deckOfCards = new DeckOfCards(DeckOfCards.DeckType.WITH_JOKERS);
    }

    @And("shuffle the deck")
    public void shuffleTheDeck() {
        deckOfCards.shuffleDeck();
    }

    @When("I remove {int} cards")
    public void iRemoveNumber_of_cardsCards(int numberOfCards) {
        removedCards = deckOfCards.drawCards(numberOfCards);
    }


    @Then("I have remaining cards cards left")
    public void iHaveRemainingCardsCardsLeft() {
    }

    @Given("{int} new deck\\(s) of cards")
    public void number_of_decksNewDeckSOfCards(int numberOfCards) {
        deckOfCards = new DeckOfCards(DeckOfCards.DeckType.MULTIPLE);
        deckOfCards.shuffleDeck();
    }

    @When("I check the response")
    public void iCheckTheResponse() {

    }

    @Then("Success is true and Deck_id is valid and shuffled is true and print remaining cards")
    public void successIsTrueAndDeck_idIsValidAndShuffledIsTrueAndPrintRemainingCards() {
    }

    @Given("I have a new deck of cards")
    public void iHaveANewDeckOfCards() {
        deckOfCards = new DeckOfCards(DeckOfCards.DeckType.STANDARD);
    }

    @Then("I get an error")
    public void iGetAnError() {
    }

}