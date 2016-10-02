# RestController-validation
Spring's @Validated is variant of  JSR-303's @Valid annotation. The limitation of @Valid is not being able to control the validation based on some conditional parameters.
using @Validated and group level validation we could achieve conditional validtion similar to using @Valid.

E.g : Application using @Valid Employee which has some params needs to validated conditionally for PUT/ POST requests.
Employee{
 @NotNull Sting Id; // needs to be validated only for PUT request.
}

App details : 
Rest Service.
Spring Boot.

To run the application:

run : VinsValidatedDemoApplication.java

url : http://localhost:8080/rules


