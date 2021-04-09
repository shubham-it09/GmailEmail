Feature: Gmail email send scenarios
Description: optional

@gmail
Scenario: Login gmail
#When click sigin button
Then Enter UserName
Then click Next button
Then Enter Password
Then click Next button
#Then Confirm Recovery Email
#Then click Next button
#Then  Enter Credentials and click on Login button
Then click Compose button
Then Enter To Email ID
|Email|shubham.it09@gmail.com|
Then Enter Subject
|Subject|Incubyte|
Then Enter Body
|Message|Hello World|
Then click Send button


