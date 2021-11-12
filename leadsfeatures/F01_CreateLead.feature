Feature: Leaftaps Create Lead Functionality

Scenario Outline: Create Lead With Mandatory Details
    When Click <createLeadLnk> link
    Given Enter Company Name as <compName>
    And Enter First Name as <firstName>
    And Enter Last Name as <lastName>
    And Enter Phone Number as <phNo>
    When Click Submit Button
    Then Title page should contains with <expecTitle>
   
Examples: 
|createLeadLnk|compName|firstName|lastName|phNo|expecTitle|
|'Create Lead'|'TestLeaf'|'Hari'|'R'|'99'|'View Lead'| 