package api.endpoints;

public class routes {

    private static final String BASE_URL = "https://www.deckofcardsapi.com/api/deck/";
    //public static final String pileName = "pile100";

    public static String getNewShuffledDeckUrl() {
        return BASE_URL + "new/shuffle/?deck_count=1";
    }
    public static String getExistingShuffledDeckUrl(String deckId) {
        return BASE_URL + deckId + "/shuffle/?deck_count=1";
    }
    public static String getDrawCardsUrl(String deckId,int count) {
        return BASE_URL + deckId + "/draw/?count=" + count;
    }
    public static String getAddToPileUrl( String deckId, String cardsParameters,String pileName) {
        return BASE_URL + deckId + "/pile/" + pileName + "/add/?cards=" + cardsParameters;
    }
    public static String getListPileCardsUrl(String deckId,String pileName) {
        return BASE_URL + deckId + "/pile/" + pileName + "/list/";
    }
    public static String getNewDeckWithJokersUrl(){
        return BASE_URL + "new/?jokers_enabled=true";
    }
    public static String getShuffleDeckWithJokersUrl(String deckId) {
        return BASE_URL + deckId + "/shuffle/?deck_count=1";
    }
    public static String getNewShuffleDeckWithJokersUrl() {
        return BASE_URL + "/new/shuffle/?jokers_enabled=true";
    }
    public static String getRemoveFirstCardAndSecondCardsUrl(String deckId,String cards) {
        return BASE_URL + deckId + "/?cards=" + cards;
    }
    public static String getLeftOverCardsUrl(String deckId) {
        return BASE_URL + deckId; //+ "/?jokers_enabled=true";
    }
    public static String getTwoNewDeckOfCardsUrl(){
        return BASE_URL+"new/shuffle/?deck_count=2";
    }
    public static String getMultipleDeckOfCards(int deckCount){
        return BASE_URL+"new/shuffle/?deck_count="+deckCount;
    }
    public static String getNewDeckOfCardsUrl(){
        return BASE_URL+"new/";
    }
    public static String getRemoveMultipleCardsFromDeck(String deckId,int removeCardsCount){
        return BASE_URL+deckId+"/draw/?count="+removeCardsCount;
    }
}