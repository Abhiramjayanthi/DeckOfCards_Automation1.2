Feature: Deck of Cards In-Depth Implementation

  Scenario Outline: Drawing cards from new shuffled deck and adding them to a pile

    Given A new deck of cards shuffled
    And I draw <number_of_cards> cards
    When I add them to '<pile_name>'
    Then '<pile_name>' has remaining cards
    @DeckOfCards1
    Examples:
      | number_of_cards | pile_name |
      | 2               | pile100   |
      | 5               | pile200   |
      | 10              | pile300   |

  Scenario Outline: Remove cards from shuffled New deck with Jokers

    Given A new deck of cards with jokers
    And shuffle the deck
    When I remove <number_of_cards> cards
    Then I have remaining cards cards left
    @DeckOfCards2
    Examples:
      | number_of_cards |
      | 2               |
      | 3               |
      | 4               |

  Scenario Outline: Draw multiple shuffled decks of cards

    Given <number_of_decks> new deck(s) of cards
    When I check the response
    Then Success is true and Deck_id is valid and shuffled is true and print remaining cards
    @DeckOfCards3
    Examples:
      | number_of_decks |
      | 2               |
      | 3               |

  Scenario Outline: New Deck of cards and draw too many cards

    Given I have a new deck of cards
    When I remove <number_of_cards> cards
    Then I get an error
    @DeckOfCards4
    Examples:
      | number_of_cards |
      | 53              |
      | 60              |