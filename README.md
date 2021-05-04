Lab-1

1. Create and run locally simple web/REST service using any open-source example on Java stack: Spring/maven/gradle/Jersey/Spring MVC.
2. Create GET endpoint with input parameters as URL query params, performing calculation based on your Option, and returning results in JSON format.

Lab-2

1. Add validation for the input parameters returning 400 HTTP error in case of empty or incorrect params provided
2. Add internal errors handling returning 500 HTTP error code in case of internal service exception/error
3. Add logging of all process steps and errors (use different log levels for errors and debug messages)
4. Add unit test for your service checking happy path and exceptional cases

Lab-3

1. Add simple cache for your service as in-memory Map where key is an input parameter and value is calculation results. This Map (cache) should be stored as a separate class (bean). Use dependencies injection mechanism of Spring Framework (autowiring) for adding cache to your service.
Web service should check cache to get calculation results from it first, if there are no calculation results for input parameter yet, do the calculation and put it into the cache before returning results in response.

Lab-4

1. Add a new service (Counter) which calculates number of your main service calls and returns the number when requested. Counter should be implemented as a separate thread safe bean with synchronized access.
2. Create high load test for your main service using JMeter, Postman or any other tool. The load test should make thousands of calls in short period of time. Then make sure that Counter correctly calculates number of service calls done by the load test.

Lab-5

1.	Update initial service created in first practical task to have ability to process sequence (stream) of input parameters. Stream API and lambdas should be used for this.
2.	Add new POST method which should get sequence of input parameters (they can be passed as JSON data in request body, or as simple CSV file), validate them and call new service for processing bulk data. Result can be returned as JSON or CSV file.

Lab-6

1. In previous task we did bulk operation for a stream of input data. In this task we need to apply some statistics calculation using aggregation/reduction. Calculated statistic should be added into POST response data (either JSON or CSV file). Statistics should include:
 
•	Total amount of input parameters (or pairs/triples of parameters) provided
•	Total amount of input parameters (or pairs/triples of parameters) which produced incorrect result (were not valid)
•	Maximum and minimum values from results calculated
•	Result which was returned most times (most popular)

Lab-7 
1. Добавить возможность сохранения всех результатов вычислений в базе данных или файле, используя стандартные persistence фреймворки Java (Spring Data/Hibernate/MyBatis)

