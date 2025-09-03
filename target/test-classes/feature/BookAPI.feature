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
|uday|4239|



Scenario Outline: Validate Add Book API for a book that already exists
Given Add Book API Paylaod with "<isbn>" and "<aisle>"
When user hit "AddBookAPI" with http "post" method
Then the statuscode of response is 200
And "Msg" in response body should be "Book Already Exists"

Examples:
|isbn|aisle|
|uday|4239|