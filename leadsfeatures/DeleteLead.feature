Feature: LeafTaps Delete Lead Functionality

Scenario Outline: Delete Lead With Updating Mandatory Field
    When Click <findLink> link
    And Click Phone Tab
    Given Give Phone Number as <phNo>
    When Click Find Lead Button
    Given Get 1st LeadID Text
    When Click The First LeadId
    And Click <deleteLink> link
    And Click <findLink> link
    Given Enter LeadID Text
    When Click Find Lead Button
    Then LeadID Should not be Displayed Expected Text <expecText>
    
Examples: 
|findLink|phNo|deleteLink|expecText|
|'Find Leads'|'99'|'Delete'|'No records to display'|