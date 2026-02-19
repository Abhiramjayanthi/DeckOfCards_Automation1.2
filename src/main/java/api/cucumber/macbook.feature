@api
@hss
@macbook
@macbook_CO
@customer_order
@unipart
@delivery

Feature: Macbook delivery through DPD and fulfilment through Unipart

  Scenario Outline: <scenarioDescription> is placed and order fulfilment through Unipart [<testid>]
    Given an EXISTING_UK_CUSTOMER <deliveryOptions> NEW INTERNAL_ORS order for <productList> via V1 API to DUNDEE address is SENT
    When the DELIVER order is CONFIRMED_V1 by Unipart for V1 API
    When the DELIVER order is ALLOCATED by Unipart for V1 API
    Then the DELIVER order is PICKED by Unipart for V1 API
    Then the DELIVER order is DISPATCHED by Unipart for V1 API
    Then UNIPART_PICK_STOCK_FROM_SLC for the PICKED Unipart DELIVER order
    Then the DELIVER order is DELIVERED by Unipart for V1 API

    @macbook
    @dongle
    @sim
    @macbook_reg
    @HSSFT-T2040
    Examples:
      | testid       | scenarioDescription                        | productList                              | deliveryOptions         |
      | @HSSFT-T2040 | MacBook,Dongle and Sim card delivery order | APPMBAM113256GRY,TPLM70004GLTEBLA,SKYSIM | UL_EXPRESS_DPD_DELIVERY |

    @macbook
    @HSSFT-T2041
    @popup
    Examples:
      | testid       | scenarioDescription    | productList      | deliveryOptions         |
      | @HSSFT-T2041 | MacBook delivery order | APPMBAM113256GRY | UL_EXPRESS_DPD_DELIVERY |

    @dongle
    @HSSFT-T2042
    Examples:
      | testid       | scenarioDescription   | productList      | deliveryOptions         |
      | @HSSFT-T2042 | Dongle delivery order | TPLM70004GLTEBLA | UL_EXPRESS_DPD_DELIVERY |

    @dongle
    @royal_mail
    @HSSFT-T2043
    Examples:
      | testid       | scenarioDescription   | productList      | deliveryOptions          |
      | @HSSFT-T2042 | Dongle delivery order | TPLM70004GLTEBLA | UL_STANDARD_DPD_DELIVERY |