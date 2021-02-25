# Jukebox

### Application setup

* Install mysql in local machine
* Login to mysql server
* create a database named "jukebox" - CREATE DATABASE jukebox
* Create a jar build of the application using the maven command - mvn clean install
* Run the application using the command : java -jar path/to/jar/build
* By default the application runs on the port 8089


### API documentation
* Login to the application by the API <br />
   url - http://localhost:8089/api/v1/auth/signIn <br />
   Method - POST <br />
   body - <br />
   {<br />
       "email" : "admin@jukebox.com",<br />
       "password" : "password"<br />
   }<br />
   
   Response - <br />
   {<br />
       "body": {<br />
           "id": 1,<br />
           "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBqdWtlYm94LmNvbSIsImlhdCI6MTYxNDE3OTg2NywiZXhwIjoxNjE0MjY2MjY3fQ.abyoz3Y9EJDR6q1oMwgb4zJunBBJie2RLYaSNuJ18tUWTN-Jp9Znyp1SKJ0VEsHvpbXlU_R_7TCtPtVCq9IZEg",<br />
           "email": "admin@jukebox.com"<br />
       }<br />
   }<br />
   
* Copy the token string which is passed as Authorization header. <br />
  Format for sending Auth header <br />
  Authorization - Bearer <token><br />
  
* Create Musician API <br />
  url - http://localhost:8089/api/v1/musician <br />
  Header - Authorization - Bearer <token> <br />
  example Request Body - <br />
  {<br />
      "name" : "Julia michaels",<br />
      "type" : "Composer"<br />
      "albumIds" : [1, 2, 3, 4]<br />
  }<br />
* Update Musician API <br />
  Method - PATCH <br />
  url - http://localhost:8089/api/v1/musician <br />
  Header - Authorization - Bearer <token> <br />
  example Request Body - <br />
  {   <br />  
        "id" : 1000, <br />
        "name" : "Julia michaels",<br />
        "type" : "Composer"<br />
        "albumIds" : [1, 2, 3, 4]<br />
   }<br />
* Fetch musicians based on music album sorted by name<br />
  Method - GET<br />
  url - http://localhost:8089/api/v1/musician/sort/name?albumId=2&pageNo=0&size=5<br />
  Header - Authorization - Bearer <token> <br />
  Query params -<br />
  albumId - id of the music album<br />
  pageNo - page no for pagination<br />
  size - size of each page<br />
  
* Create music album <br />
  url - http://localhost:8089/api/v1/album/<br />
  Method - PUT<br />
  Header - Authorization - Bearer <token> <br />
  example Request Body - <br />
  {<br />
      "name" : "Hybrid theory",<br />
      "price" : 100,<br />
      "description" : "First album by Linkin park",<br />
      "dateOfRelease" : "30-04-1999",<br />
      "genre" : "rock",<br />
      "musicianId" : [2]<br />
  }<br />
  
* Update Music Album <br />
  url - http://localhost:8089/api/v1/album/
  Method - PATCH
  Header - Authorization - Bearer <token> <br />
  example Request Body - <br />
  {<br />
      "id" : 2,<br />
      "name" : "Hybrid theory",<br />
      "price" : 200,<br />
      "description" : "First album by Linkin park",<br />
      "dateOfRelease" : "30-04-1999",<br />
      "genre" : "rock",<br />
      "musicianId" : [2, 3, 4]<br />
  }<br />
  
* Fetch list of Music albums sorted by Date of release in ascending order<br />
  url - http://localhost:8089/api/v1/album/sort/date<br />
  Method - GET<br />
  Header - Authorization - Bearer <token> <br />
 
* Fetch list of Music albums for a specified musician sorted by Price in
  ascending order<br />
  url - http://localhost:8089/api/v1/album/sort/price?pageNo=0&size=5&musicianId=1<br />
  Method - GET<br />
  Header - Authorization - Bearer <token> <br />
  Query params -<br />
  musicianId - id of the musician <br />
  pageNo -  page number for pagination<br />
  size -  size of each page<br />
  
* Fetch list of musicians for a specified music album sorted by musician's
  Name in ascending order.<br />
  url - http://localhost:8089/api/v1/musician/sort/name?albumId=2&pageNo=0&size=5
  Method - GET<br />
  Header - Authorization - Bearer <token> <br />
  Query params - <br />
  albumId - id of the album based on which the musician should be listed<br />
  pageNo -  page number for pagination<br /><br />
  size -  size of each page<br /><br />