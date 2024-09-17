package api.Main;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"/src/main/java/api/cucumber"},
        glue = {"stepDefinitions"},
        tags = "@DeckOfCards1",
        plugin = {"pretty","html: target/SystemTestReports/report.html"}

)
public class mainMethod {
//     public static void main(String[] args){
//         DeckOfCards deck = new DeckOfCards(DeckOfCards.DeckType.STANDARD);
//         List<String> drawnCards=deck.drawCards(5);
//         deck.addToPile(drawnCards ,"pile100");
//         deck.displayPileCards("pile100");

//     }
}
