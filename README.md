#String reverce

Lab-1

1. Create and run locally simple web/REST service using any open-source example on Java stack: Spring/maven/gradle/Jersey/Spring MVC.
2. Create GET endpoint with input parameters as URL query params, performing calculation based on your Option, and returning results in JSON format.

Lab-2

1. Add validation for the input parameters returning 400 HTTP error in case of empty or incorrect params provided
2. Add internal errors handling returning 500 HTTP error code in case of internal service exception/error
3. Add logging of all process steps and errors (use different log levels for errors and debug messages)
4. Add unit test for your service checking happy path and exceptional cases

Lab-3

Add simple cache for your service as in-memory Map where key is an input parameter and value is calculation results. This Map (cache) should be stored as a separate class (bean). Use dependencies injection mechanism of Spring Framework (autowiring) for adding cache to your service.
Web service should check cache to get calculation results from it first, if there are no calculation results for input parameter yet, do the calculation and put it into the cache before returning results in response.
