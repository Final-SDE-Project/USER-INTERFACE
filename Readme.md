#USER-INTERFACE (Console Application)     
This is a health care application which works with just one user. Application holds the general information of the user such as name, age. Also the life status information such as weight and height. System also holds the data of the goals of the person. User can see any kind of information by requesting through menu options. User can change the current goals. Program allows user to change the name and amount of the goal. User can also change the his/her weight or height. When there is a change in life status, system automatically updates the BMI value of the person and sets a new goal for the person. This new goal suggest to lose or gain weight to the user. If users condition is okay, system suggest to lose "zero" kg to the user. Any time of the day, user can enter the amount of goal that he/she did. If goal is accomplished the user will get Congrats message. If goal does not accomplished the user gets Random Quote as a motivational message. Also system shows how much left to finish the task.

## How does the App work?

This console application can be used only by one predefined user (idPerson = '1'). 
When the application is run there is a MENU printed on screen. In order to proceed the user should type the number of operation that he wants to execute. There are the available operations:

 **MENU**
     
* 1 - Print your PERSONAL DETAILS & CURRENT HEALTH MEASURES
* 2 - Print your GOALS
* 3 - Have I reached my GOALS?!
* 4 - My weekly WALKING achievement
* 5 - My monthly WALKING achievement
* 6 - What is my IDEAL WEIGHT and set it as a GOAL
* 7 - My biggest WEIGHT change during the last 90 days
* 8 - Reminders to set GOAL or HEALTH MEASURE
* 9 - Print your HEALTH MEASURE HISTORY
* 10 - Print your GOALS HISTORY
* 11 - Save a GOAL
* 12 - Save a MEASURE
* 0 - Exit

-> Quote of the day: "Content of the motivational quote." - Author

##System Architecture
![alt tag](https://github.com/Final-SDE-Project/USER-INTERFACE/blob/master/Architecture.png)

###External Adapter Service (RESTful Web Services)
This service has to external API connection. One is BMI calculator the other one is Random Famous Quotes. This service sends the necessary JSON packages to the external APIs and then turns back the result to the Storage-Service.

####Random Quote API
This external adapter service obtains random famous quotes. The communication between these services are in REST and uses JSON objects.

####BMI Calculator API
This adapter takes some information such as "weight", "height" and "age" and returns BMI value of the person and the weight suggestion that person should have. The communication between this adapter and Storage service is in REST with JSON objects.

###Database Service (SOAP Services)
Data Service deals with all the data related requests in the application. This service is based on SQLite database and provide data related operations to Storage Service in this application. This service uses SOAP Protocol to communicate with other services.

###Storage Service (SOAP Services)
This Service collects all kind of necessary data from data-service and external services. While it uses SOAP technologies to connect with data-service, it is connected to external adapter services using RESTful client. Communication between them is made by using JSON messages. This service sends the requested data to Business-Logic and Process-Centric services by using SOAP technology.

###Business Logic Service (SOAP Services)
Business Logic Service implements all the logics and get requests that are used in this application. This layer receives requests from the UI layer and it gets data from the storage layer and processes it to send results back. It is responsible for checking if the goals are hit by the user and for getting the details from the storage (database).

###Process Centric Service (SOAP Services)
This service serves all requests coming directly from users (from application interface). These are the gateway to all other modules/services in an application context. This layer is doing nothing but redirecting a request to a proper underlying service or a set of services.

###User Interface (Console Application)
User Interface provides interface where the user can communicate with the Server-side. 


## Technologies used in the project

* The application was developed in Java 1.8.
* IntelliJ IDEA 15 was used as an IDE for the project.
* Database SQLite was used to store data at the local database level.
* GitHub was used a a code hosting, for this project the separate organisation was created and can be reached by this link https://github.com/Final-SDE-Project 
* Heroku: all five layers (services) of the application are deployed on Heroku. Free account has been used. 
* Wiki page was used to describe the APIs documentation.
* SOAP tehchnology was mostly used for communication between services. In addition, JSON format was used for a RESTful service. 
* Apache Ant was used to build the Java application.
* Apache Ivy - dependency manager

##RUN the code
Do 'git clone' for the current repository. Open 'USER-INTERFACE' folder and then enter "ant start" command. The program will run and you will be able to work with the client using the menu shown on the screen.

##Further Improvements
The current version of the application was made very simple in order to meet the set of requirements for the project (individual project work). There are a lot of other ways to improve the application, like:

1) More advanced user interface: instead of console user interface a web application or a mobile application can be developed to provide better user experience. Or Telegram/Slack bots can be used to provide better interaction experience between the user and application. Also this application works for just one user, the login and sign-in interfaces could be done as future improvement to support a lot of user at the same time.

2) More external APIs in use: more various external APIs can be used in the application to inform the user, for instance a service that will crawl the web and broadcast news and articles about health issues, healthy nutrition and sports activities. Applications that gather sports data from smart wearable devices (like fitness bracelets) or application that register physical activity data can be also useful and can be used as an external database for application. It will provide more automatic data insertion, so the user will not have to insert the data by himself.
