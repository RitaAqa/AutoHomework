command to run tests:
mvn clean test -DsuiteName=testng


Information about test framework:
Framework includes API and UI parts

Structure of test framework:
Common part:
1. Use testng.xml file to organize tests
2. Use pom.xml file to configure maven plugins
3. Screenshots, logs and report are saved in target folder and corresponding sub-folders
(results/, logs/, extent-reports/) 
Notes: logs are overridden each time after mvn clean 
4. common utils should be in main/java/utils folder
5. data files, drivers, properties files should be in main/resources/
6. default variables and settings should be in main/resources/common.properties file
7. Data models should be in main/java/framework/data/models folder
8. Data providers should be in main/java/framework/data/providers folder

API part (TBD):
1. API tests should be in TEST/java/api folder
2. Implementation of REST requests (GET, POST, PATCH, PUT, DELETE) should be in main/java/framework/api/BaseRequests class
3. EndPoint should be in main/java/framework/api/Urls class
4. Business logic should be in main/java/framework/api/ApiClient class

UI part
1. UI tests should be in TEST/java/ui folder
2. Implementation of pages should be in main/java/framework/ui/pages folder
3. Common methods for pages should be in main/java/framework/ui/base/BasePage class
4. Common methods for tests should be in main/java/framework/ui/base/BaseTest* class
5. Common actions for tests should be in main/java/framework/ui/base/actions folder (TBD: move from CosmosUID class)
6. EndPoint should be in main/java/framework/ui/Urls class
7. Initiation of page objects should be in main/java/framework/ui/CosmosIDUI class





