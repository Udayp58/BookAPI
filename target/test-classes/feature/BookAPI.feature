Feature: Book Management via Library API 
As a QA Analyst
I want to validate the Library API endpoints
So that I can ensure books are added, retrieved, and deleted correctly

Scenario Outline: Validate Add Book API is successfully adding book or not 
Given Add Book API Paylaod with "<isbn>" and "<aisle>"
When user hit "AddBookAPI" with http "post" method
Then the statuscode of response is 200 
And "Msg" in response body should be "successfully added"

Examples:
|isbn|aisle|
|Riyansh|4339|



Scenario Outline: Validate Add Book API for a book that already exists
Given Add Book API Paylaod with "<isbn>" and "<aisle>"
When user hit "AddBookAPI" with http "post" method
Then the statuscode of response is 200
And "Msg" in response body should be "Book Already Exists"

Examples:
|isbn|aisle|
|Riyansh|4339|


Scenario: Validate get Book API by Id
Given Get Book API Paylaod 
When user hit "GetBookAPI" with http "get" method
Then the statuscode of response is 200

Scenario: Validate delete Book API 
Given Delete book API Paylaod
When user hit "DeleteBookAPI" with http "delete" method
Then the statuscode of response is 200
And "msg" in response body should be "book is successfully deleted"
Given Get Book API Paylaod
When user hit "GetBookAPI" with http "get" method
Then the statuscode of response is 404
And The Response of getBook API contain "msg" "The book by requested bookid / author name does not exists!"
