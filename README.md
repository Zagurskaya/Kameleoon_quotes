﻿## Quotes service

### General description
   The web application provides the ability to create user pages and quotes in them.
   The user can view his quotes and update, delete them.
   Anybody can vote on quotes (either upvote or downvote). 
  
____
### Guest
  * **Anybody scope**   
  
      * **Registration**  
        * Create new account

      * **Active** 
        * View all quotes
		* Vote on upvote  quotes (pros) 
		* vote on downvote quotes (cons)
		
    
### Users

 The user has active roles: **USER** and one nominal role: **GUEST**
 
  * **User's scope**  
  
	* View all his quotes
	* Create new quote
	* Delete his quote
	* Update his quote
		
____
### Assembly and start-up instructions
  * **Description (Linux)**   
  
      * **Minimum requirements**  
        * openjdk-8-jdk

      * **Assembly and start-up instructions** 
        * Making a copy of the project repository
          git clone https://github.com/Zagurskaya/Kameleoon_quotes.git
          
		* Building a project from the project root
		  mvn clean install
		   
		* Starting application from telegram-bot\spring-boot-module\
		  mvn spring-boot:run
		  
		* Project URL
    	  localhost:8080/