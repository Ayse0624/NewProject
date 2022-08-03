
@UserStoreStepDefination
Feature: userStore
  Background:
    Given user already on the dashboard page
    When click login icon


  @viewWishList
  Scenario: user should be view wishlist
    Given user already on the magento page
    When enter my wishlist link
    Then user should be see wishlist

  @updateAndViewAddressBook
  Scenario: update and view address book
    Given user already on the magento page
    When enter address book link view and update
    Then user update successfully

