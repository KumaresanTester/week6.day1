Feature: Leaftaps Merge Lead Functionality

Scenario Outline: Merge Lead With Updating Mandatory Field
    When Click <mergeLink> link
    And Click From Lead Img
    Given Enter the First Name as <fromLead>
    When Click Find Lead Button in New Window
    Given Get 1st LeadID Text in New Window
    When Click The First LeadId in New Window
    And Click To Lead Img
    Given Enter the First Name as <toLead>
    When Click Find Lead Button in New Window
    And Click The First LeadId in New Window
    And Click <mergeLead> link
    And Handle Alert by Accept
    And Click <findLink> link
    Given Enter LeadID Text
    When Click Find Lead Button
    Then LeadID Should not be Displayed Expected Text <expecText>
    
Examples: 
|mergeLink|fromLead|toLead|mergeLead|findLink|expecText|
|'Merge Leads'|'hari'|'babu'|'Merge'|'Find Leads'|'No records to display'|
    