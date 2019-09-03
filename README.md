# flwr

Java version: 1.8.0_181

Apache Maven 3.6.0

TestNG - 7.0.0

Rest-assured - 3.0.0

To run tests use this command line:
```bash
mvn clean test
```
Rest assured library was using cause it is simple to send request, receive and parse response. Human readable with given, when, then notation.

1. I would conduct performance testing, to make sure that server can handle lots of users (Jmeter, Gatling tool can be used)
2. Check search by id request. First to make call to search by name, get all ids, and then search by each of this ids.
3. Sql injection can be executed
4. Negative cases, to send unexisting data or incorrect values to the server
5. Measure response time when request thousands of records
