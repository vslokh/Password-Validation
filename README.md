Spring Boot-based Java 17 microservice for password validation. This service will use Spring's dependency injection (IoC container) for configurability and Maven for build management.


REST API details:
URL: http://localhost:8080/api/password/validate
Request Type : POST

Body: { "password": "abc123" }
Response : 200 HTTP Status code with message "Password is valid."

Body: { "password": "ABCDASE" }
Response : 400 HTTP Status code with message "Password is invalid."


