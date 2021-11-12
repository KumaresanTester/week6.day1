Feature: Leaftaps Edit Lead Functionality

Scenario Outline: Edit Lead with Valid Reason
    When Click <findLink> link
    And Click Phone Tab
    Given Give Phone Number as <phNo>
    When Click Find Lead Button
    And Click The First LeadId
    And Click <editLink> link
    Given Update Company Name as <compName>
    When Click Update Button
    Then Company Name Should be <compName>
    
Examples: 
|findLink|phNo|editLink|compName|
|'Find Leads'|'99'|'Edit'|'TCS'|