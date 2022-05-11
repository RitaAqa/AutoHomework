command to run tests:
mvn test


Some info about test framework:
Framework includes API and UI parts

Structure of test framework:
Common part:
1. Use testng.xml file to organize tests
2. default variables and settings should be in main/resources/common.properties file
3. common utils should be in main/java/utils folder

API part:
1. API tests should be in TEST/java/api folder
2. Implementation of REST requests (GET, POST, PATCH, PUT, DELETE) should be in main/java/app/api/BaseRequests class
3. EndPoint should be in main/java/app/api/Urls class
4. Business logic should be in main/java/app/api/ApiClient class

UI part
1. UI tests should be in TEST/java/ui folder
2. Implementation of pages should be in main/java/app/ui/page_object folder
3. Common methods for pages should be in main/java/app/ui/page_object/BasePage class
4. Classes for settings should be in main/java/app/ui/utils folder
5. EndPoint should be in main/java/app/ui/Urls class
6. Common methods for tests should be in main/java/app/ui/CosmosIDUI class
7. Initiation of page objects should be in main/java/app/ui/CosmosIDUI class




