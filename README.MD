 1) Compile with Gradle before running.
 2) Run the main method in the DemoApplication.java file
 3) Use Postman for http requests by test.postman_collection.json

http request URLs:

1)POST http://127.0.0.1:8080/api/add

2)POST http://127.0.0.1:8080/api/spend

3)GET  http://127.0.0.1:8080/api/balance



Description:
1) Use CopyOnWriteArrayList as a local cache
2) Override the equals method in the TransactionRoute file to prevent adding a new Transaction Route record failing
3) Maintain the id of the last Transaction Route record with AtomicInteger
4) Balance is returned in the order in which Transaction Route was added
5) URL /api/spend is returned in the order in which Transaction Route was added

