Feature: Get Country List 

#Background: 
#   Given valid VAAFI headers

@CI @VA @HappyPath
Scenario Outline: Get Country List - successful 
	Given I pass the header information to get the Country list 
		| Accept       | application/json;v=3 |
		| Content-Type | application/json;v=3 |
	When I make a GET request using "<ServiceURL>" 
	Then the response code to be 200
	And the response should be same as "<ResponseFile>" 
	
	Examples: 
		| ServiceURL                | ResponseFile         |
		| /api/refdata/v1/countries | countryList.Response |

@CI @VA @HttpError
Scenario Outline: Get Country List - partner service error 401
	Given I pass the header information to get the Country list
		| Accept       | application/json;v=3 |
		| Content-Type | application/json;v=3 |
	When Using bad token I make a GET request using "<ServiceURL>" 
	Then the response code to be 401
	And the response should be same as "<ResponseFile>" 
	
	Examples: 
		| ServiceURL                | ResponseFile                 |
		| /api/refdata/v1/countries | generalHttpError401.Response |

@CI @VA @HttpError
Scenario Outline: Get Country List - service error 406
	Given I pass the header information to get the Country list
		| Accept       | test |
		| Content-Type | application/json;v=3 |
	When I make a GET request using "<ServiceURL>" 
	Then the response code to be 406 
	
	Examples: 
		| ServiceURL                |
		| /api/refdata/v1/countries |
			