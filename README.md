# MovieService

Steps to install application on local machine and run

1) Take git clone from https://github.com/jitender4440/MovieService.git
2) mvn update
3) mvn clean
4) mvn install  -- Make sure build is successful
5) Run the application from com.luxoft.App class
6) Once App startup successfully then check following service from browser 
http://localhost:8080/api/v1/comment/1

It should ask for a username and password as basic authentication is used to secure the restful webservices.
