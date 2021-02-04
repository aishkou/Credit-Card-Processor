# Credit Card Processor Application

This is a spring boot based credit card management application which exposes 2 RestEndpoints to execute the mentioned credit cart related operations

- add a new card
- get all cards from the database

### Technology Stack

The following technology stack has been used in line with the requirements outlined in the requirement document.

  - Spring Boot 2.0.3.Release
  - H2 Database (Runtime memory requirement)
  - Spring Boot JDBC
  - SpringFox Swagger
  - SpringFox UI
  - Junit
  - SureFire Reports
  - Maven 3.0

### Validation

1. Validation has been implemented for the add card interface to make sure incorrect data is not being allowed.
2. LUHN checks have also been hand written to validate the credit card numbers.

### PCI-DSS Compliance

According to the PCI compliance rules for storing credit card numbers , only the first 6 digits and last 4 digits can be stored.
The middle digits need to be masked and only the PAN should be stored and shown to the customer in the UI.

I have not implemented this due to the time constraint, but have added here to demonstrate my awareness regarding the same.

### Sequence Diagram:

![alt text](https://raw.githubusercontent.com/aishkou/Credit-Card-Processor/master/seqDiagram1.png)

### RestAPI Details

![alt text](https://raw.githubusercontent.com/aishkou/Credit-Card-Processor/master/RestAPISwagger.PNG)

### RestAPI Status Codes

201 - Created
401 - Unauthorized
403 - Forbidden
404 - Not Found

Swagger UI will be available on the following link:

```sh
http://localhost:8080/ccp/swagger-ui.html#/
```

### For Installation and Testing:

This application is built using maven and all dependencies will be added automatically.

```sh
$ cd CreditCardProcessor
$ mvn clean
$ mvn clean spring-boot:run
```

For Running Tests and Generating the Test Report:

```sh
$ mvn test
$ mvn surefire-report:report-only
$ mvn site -DgenerateReports=false
```
### H2 Database Settings
![alt text](https://raw.githubusercontent.com/aishkou/Credit-Card-Processor/master/h2-db.PNG)

### Test Summary
![alt text](https://raw.githubusercontent.com/aishkou/Credit-Card-Processor/master/SurefireReport1.PNG)

### Test Cases
![alt text](https://raw.githubusercontent.com/aishkou/Credit-Card-Processor/master/SurefireReport2.PNG)
