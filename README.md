### Pre-requisites to run this project ###

This project was compiled on **Java JDK version 11**. So it should run on any other java version higher than 11. 
Be sure to have Java JDK and JRE set up in you machine.

https://developer.ibm.com/languages/java/semeru-runtimes/downloads

Also I am using Postman to test the services/APIs. You may consider installing it, or if you a command geek, curl should do the trick as well ;)
https://www.postman.com/downloads/


### Installation Steps ###

1. Download the zipped file from github and extract to a temporary folder
2. Open this temporary folder on the prompt command (cmd) and make sure you are at the root level of the project.
3. Type in **gradlew build** (This command will download the dependencies, compile, and build the program)
4. Type in **gradlew bootRun** (This command will load the services)
5. Please find the collections of requests in **/vehicle-management/src/main/resources/vehicle mgmt requests.postman_collection.json**. Import this file into postman and you should be able to test the implemented request according to the requirements.
