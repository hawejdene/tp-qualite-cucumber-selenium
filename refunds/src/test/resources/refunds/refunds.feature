Feature: refunding process
  refunding process event
  Scenario Outline: item is hardware bought <bought> day ago in <condition> condition
    Given : the item is hardware bought <bought> day ago in <condition> condition
    When : ask for refund
    Then : refund <refunds>

    Examples:
      | bought |condition| refunds|
      | 1      |   good   |repare|
      | 1      |   bad   |refused|
      | 10     |    good  |refused |
      | 10     |      bad   |refused |

  Scenario Outline: item is clothes bought <bought> day ago in <condition> condition during <sales>
    Given : the item is clothes  bought <bought> day ago in <condition> condition during <sales>
    When : ask for refund
    Then : refund <refunds>

    Examples:
      | bought |condition|sales|refunds|
      | 1      |   good   |normal days|accepted|
      | 1      |   good   |sales days|refused|
      | 1      |   bad   |  normal days |refused|
      | 1      |   bad   |  sales days |refused|
      | 10     |    good  |normal days |refused |
      | 10     |    good  |sales days |refused |
      | 10     |      bad   |normal days|refused |
      | 10     |      bad   |sales days|refused |

