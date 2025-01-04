# round28
Automatest: Test Automation training round 28 practice project

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


Assert that the Country for the Company [Ernst Handel] is [Austria]

-- locate the country using the company name


/html/body/div[5]/div[1]/div[1]/div[3]/div/table/tbody/tr[4]/td[3]


//*[@id="customers"]/tbody/tr[4]/td[3]

//td[text()='Austria']

---> option 1
//tr[contains(.,'Ernst Handel')]/td[3]    >>  //tr[td[text()='Ernst Handel']]/td[3]

---> option 2
//td[text()='Ernst Handel']/parent::tr/td[3]   >>  //td[text()='Ernst Handel']/../td[3]

---> option 3
//td[text()='Ernst Handel']/following-sibling::td[2]


