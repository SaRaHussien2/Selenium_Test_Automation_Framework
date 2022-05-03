Feature: User Registration
	I want to check the user can register in our e-commerce website.
	
 
	Scenario Outline: User Registration
	Given the user in the home page
	When I clike on register link
	And  I entered "<firstName>","<lastName>","<email>","<username>","<password>"
	Then The registration oage displayed successfully
	
	
	Examples:
	| firstName | lastName | email | username | password |
	| sa | ra | sara123@ss.com | ssss | 123456 |
	| sara | hh | sara123@shh.com | soka | 1234567 |
			