Feature: LeafTaps Duplicate Lead Functionality

Scenario Outline: Duplicate Leads with Updating Mandatory Fields
    When Click <findLink> link
    And Click Phone Tab
    Given Give Phone Number as <phNo>
    When Click Find Lead Button
    And Click The First LeadId
    And Click <duplicateLink> link
    Then Title page should contains with <expecTitle>
    
Examples: 
|findLink|phNo|duplicateLink|expecTitle|
|'Find Leads'|'99'|'Duplicate Lead'|'Duplicate '|