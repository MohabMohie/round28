# round28
Automatest: Test Automation training round 28 practice project


## Rules of xpath


relative xpath:

//tagName[@attribute='value']

//tagName[@attribute]
//tagName
//tagName[@attribute='value'][@attribute2='value2']

//tagName[@attribute='value'][index]
(//tagName[@attribute='value'][@attribute2='value2'])[index]

//*[@attribute='value']

//parentTagName[@attribute='value']/tagName[@attribute='value']
//grandParentTagName[@attribute='value']//tagName[@attribute='value']

//tagName[contains(@attribute,'subValue')]
//tagName[not(contains(@attribute,'subValue'))]

//tagName[text()='element text']
//tagName[contains(text(),'partial text')]

//tagName[contains(.,'partial text')]



//section[not(contains(@class, 'shrink'))]/a/img


factors of a good/stable xpath:
- number of nodes
- number of attributes
- stability of values
- using index (3amal 3ala batal) *Automation Hell*
- copy x-path *Automation Hell*
- don't use class equals (especially with multiple classes), use class contains instead
- maps to business requirements
- do not use text to identify elements in a website that supports multiple languages




## Rules of test structure

Test Cases:

- test class should be created per module
- one test method per test case
- before/after method for setup/teardown
- test case should start with navigation
- test case should end with assertion
- [test cases should be independent]


Test Scenarios:

- test package per module
- test class per scenario
- before/after class for setup/teardown
- navigation in the before class
- test case should end with assertion
- [test cases should be dependent]
