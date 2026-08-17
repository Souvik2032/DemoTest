Feature: Checking the login functionality

@login
Scenario Outline: Verify Login Functionality

	When User enters username "<username>"
	And User enters password "<passwordType>"
	And User clicks Login Button
	Then User should see "<result>"

Examples:
| username | passwordType | result                    |
| student  | valid        | Logged In Successfully    |
| student  | invalid      | Your password is invalid! |