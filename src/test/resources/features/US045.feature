Feature:

  Scenario: Financial summary', 'Payout', 'Charge account', 'Subscribe' links should be visible and
  active under the Financial heading in the Dashboard sidebar.
    
    Given user kullanıcı login olur
    Then user clicks on the Finacial buton
    Then User verify that links are visible under the Financial heading in the Dashboard sidebar

      | Financial summary    |
      | Payout               |
      | Charge account       |
      | Subscribe            |

Scenario: the 'Financial Summary' link is clicked, the list of Financial documents should be visible on the page.

  Given user kullanıcı login olur
  Then  user clicks on the Finacial buton
  Then user clicks Financial Summary button
  Then User Verifies that the list of financial documents is visible on the page

  Scenario: Payout' linkine tıklandıgında hesap tanımlanmamıs ise 'Your identity and financial information not verified so it might cause delay in payout process. Please define them from settings.'
  3linkinden hesap tanımlanabilmeli ve request olusturabilmeli